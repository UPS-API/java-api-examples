package com.ups.oauth.client.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ups.oauth.client.dto.AuthTokenResponce;
import com.ups.oauth.client.dto.LassoRedirectModel;
import com.ups.oauth.client.service.ClientService;
import org.junit.jupiter.api.Test;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

import static org.hamcrest.CoreMatchers.is;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.*;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.BDDMockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;

@WebMvcTest
class ClientControllerTest {

    @Autowired
    private MockMvc mockMvc;


    @Autowired
    private ObjectMapper objectMapper;

    @MockBean
    ClientService clientService;


    @Test
    void genToken() {
        AuthTokenResponce authTokenResponce= new AuthTokenResponce();
        authTokenResponce.setAccess_token("abc TOKEN");
        String  code ="X8y7tazW-U2FsdGVkX19ZzhmzZQytDydbxHqx1XqBM6akXoyerEIb6Ec+2aEY5TsIONi3E2pJj8N5P6/O6Xf4Ph36M+wlgw==";
        given(clientService.genToken(code)).willReturn(authTokenResponce);
        try {
            ResultActions response = mockMvc.perform(get("/client/generate-token?code=X8y7tazW-U2FsdGVkX19ZzhmzZQytDydbxHqx1XqBM6akXoyerEIb6Ec+2aEY5TsIONi3E2pJj8N5P6/O6Xf4Ph36M+wlgw==")
                    //.contentType(MediaType.APPLICATION_JSON)
                   );

            response.andExpect(status().isOk())
                    .andDo(print())
                    .andExpect(jsonPath("$.access_token", is(authTokenResponce.getAccess_token())));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

    @Test
    void getValidateClient() {

        String client_id ="test client_id";
        String redirect_uri = "test redirect_uri";
        LassoRedirectModel lassoRedirectModel = new LassoRedirectModel();
        lassoRedirectModel.setLassoRedirectURL("https://www.ups.com/lasso/signin?client_id=QUlFrHA9NXwmXUKz48QT9MJhaAizkdeXDiAYcGWtsVFYbJRJ&redirect_uri=https://www.ups.com&response_type=code&scope=read&&type=ups_com_api");
        given(clientService.getValidateClient(client_id,redirect_uri)).willReturn(lassoRedirectModel);
        try {
            ResultActions response = mockMvc.perform(get("/client/validate-client")
                    .param("client_id",client_id)
                    .param("redirect_uri",redirect_uri)
            );

            response.andExpect(status().isOk())
                    .andDo(print())
                    .andExpect(jsonPath("$.lassoRedirectURL", is(lassoRedirectModel.getLassoRedirectURL())));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    void refreshToken() {
        MultiValueMap<String, String> paramMap = new LinkedMultiValueMap<>();
        String token = "any token test";
        List<String> list = new ArrayList<>();
        list.add(token);
        AuthTokenResponce authTokenResponce= new AuthTokenResponce();
        authTokenResponce.setAccess_token("abc");
        paramMap.addAll("refresh_token",list);
        given(clientService.refreshToken(token)).willReturn(authTokenResponce);
        try {
            ResultActions response = mockMvc.perform(post("/client/refresh-token")
                    .contentType(MediaType.APPLICATION_FORM_URLENCODED_VALUE)
                    .params(paramMap)
            );

            response.andExpect(status().isOk())
                    .andDo(print())
                    .andExpect(jsonPath("$.access_token", is(authTokenResponce.getAccess_token())));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }
}