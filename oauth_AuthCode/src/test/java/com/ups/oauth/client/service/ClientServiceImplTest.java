package com.ups.oauth.client.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ups.oauth.client.dto.AuthTokenResponce;
import com.ups.oauth.client.dto.LassoRedirectModel;
import com.ups.oauth.client.dto.ValidateClientResponse;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.*;
import static org.junit.Assert.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.*;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.util.ReflectionTestUtils;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;


import java.util.Base64;
import java.util.HashMap;
import java.util.Map;

import static org.springframework.test.web.client.match.MockRestRequestMatchers.requestTo;


@SpringBootTest()
class ClientServiceImplTest {

    @Autowired
    private ObjectMapper objectMapper;

    @Mock
    private RestTemplate restTemplate = new RestTemplate();

    @InjectMocks
    private ClientService clientService = new ClientServiceImpl();


    @BeforeEach
    void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        ReflectionTestUtils.setField(clientService, "clientId", "test client_id");
        ReflectionTestUtils.setField(clientService, "secretId", "test secret_id");
        ReflectionTestUtils.setField(clientService, "tokenUrl", "https://onlinetools.ups.com/security/v1/oauth/token");
        ReflectionTestUtils.setField(clientService, "validateClientUrl", "https://onlinetools.ups.com/security/v1/oauth/validate-client");
        ReflectionTestUtils.setField(clientService, "refreshUrl", "https://onlinetools.ups.com/security/v1/oauth/refresh");
        ReflectionTestUtils.setField(clientService, "redirectUrl", "https://www.ups.com");

    }
    @Test
    void getValidateClient() throws JsonProcessingException {

        HttpHeaders headers = new HttpHeaders();

        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
        HttpEntity<Void> entity = new HttpEntity<>(headers);
        Map<String, String> params = new HashMap<String, String>();
        String client_id ="test client_id";
        String redirect_uri = "https://www.ups.com";
        params.put("client_id", client_id);
        params.put("redirect_uri", redirect_uri);
        String finalValidateClientUrl = "https://onlinetools.ups.com/security/v1/oauth/validate-client" + "?client_id=" + client_id +
                "&redirect_uri="+redirect_uri;
        ValidateClientResponse validateClientResponse = new ValidateClientResponse();
        validateClientResponse.setResult("success");
        validateClientResponse.setLassoRedirectURL("https://www.ups.com/lasso/signin");
        validateClientResponse.setType("ups_com_api");

        ResponseEntity<ValidateClientResponse> res = new ResponseEntity(validateClientResponse, HttpStatus.OK);
        Mockito
                .when(restTemplate.exchange(
                        finalValidateClientUrl, HttpMethod.GET,entity,ValidateClientResponse.class,params))
          .thenReturn(res);
        ValidateClientResponse validateClientResponse1= res.getBody();
        LassoRedirectModel resSedrvice =  clientService.getValidateClient(client_id,redirect_uri);
        String callbackURL = validateClientResponse.getLassoRedirectURL() + "?client_id=" + client_id + "&redirect_uri=" + redirect_uri
                + "&response_type=code&scope=read&&type=" + validateClientResponse.getType();
        assertEquals(validateClientResponse.getResult(),validateClientResponse1.getResult());
        assertEquals(validateClientResponse.getType(),validateClientResponse1.getType());
        assertEquals(validateClientResponse.getLassoRedirectURL(),validateClientResponse1.getLassoRedirectURL());
        assertEquals(callbackURL,resSedrvice.getLassoRedirectURL());

    }

    @Test
    void genToken() {
        String client_id ="test client_id";
        String authStr = "test client_id" + ":" + "test secret_id";
        String base64Creds = Base64.getEncoder().encodeToString(authStr.getBytes());
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
        headers.add("Authorization", "Basic " + base64Creds);
        MultiValueMap<String, String> map = new LinkedMultiValueMap<>();
        map.add("grant_type", "authorization_code");
        map.add("code", "abc Code");
        map.add("redirect_uri", "https://www.ups.com");
        HttpEntity<MultiValueMap<String, String>> entity = new HttpEntity<>(map, headers);
        String tokenUrl = "https://onlinetools.ups.com/security/v1/oauth/token";
        AuthTokenResponce authTokenResponce = new AuthTokenResponce();
        authTokenResponce.setAccess_token("test abc token");
        authTokenResponce.setClient_id("test");
        authTokenResponce.setIssued_at("test");
        authTokenResponce.setToken_type("test");
        authTokenResponce.setExpires_in("test");
        authTokenResponce.setStatus("test");
        authTokenResponce.setScope("test");
        authTokenResponce.setRefresh_token("test");
        authTokenResponce.setRefresh_token_status("test");
        authTokenResponce.setRefresh_token_expires_in("test");
        authTokenResponce.setRefresh_count("test");
        authTokenResponce.setRefresh_token_issued_at("test");

        ResponseEntity<AuthTokenResponce> res = new ResponseEntity(authTokenResponce, HttpStatus.OK);
        Mockito
                .when(restTemplate.postForEntity(
                        tokenUrl,entity,AuthTokenResponce.class))
                .thenReturn(res);

        AuthTokenResponce token = clientService.genToken("abc Code");
        assertEquals(token.getAccess_token(),authTokenResponce.getAccess_token());

    }

    @Test
    void refreshToken() {
        String authStr = "test client_id" + ":" + "test secret_id";
        String base64Creds = Base64.getEncoder().encodeToString(authStr.getBytes());
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
        headers.add("Authorization", "Basic " + base64Creds);
        MultiValueMap<String, String> map = new LinkedMultiValueMap<>();
        map.add("grant_type", "refresh_token");
        map.add("refresh_token", "test refresh toekn");
        HttpEntity<MultiValueMap<String, String>> entity = new HttpEntity<>(map, headers);
        String refreshUrl = "https://onlinetools.ups.com/security/v1/oauth/refresh";
        AuthTokenResponce authTokenResponce = new AuthTokenResponce();
        authTokenResponce.setAccess_token("test refresh token response");
        ResponseEntity<AuthTokenResponce> res = new ResponseEntity(authTokenResponce, HttpStatus.OK);
        Mockito
                .when(restTemplate.postForEntity(
                        refreshUrl,entity,AuthTokenResponce.class))
                .thenReturn(res);

        AuthTokenResponce token = clientService.refreshToken("test refresh toekn");
        assertEquals(token.getAccess_token(),authTokenResponce.getAccess_token());
    }
}