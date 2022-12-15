package com.ups.oauth.client.service;

import java.util.Base64;
import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import com.ups.oauth.client.dto.AuthTokenResponce;
import com.ups.oauth.client.dto.LassoRedirectModel;
import com.ups.oauth.client.dto.ValidateClientResponse;

@Service
public class ClientServiceImpl implements ClientService {

	private static final Logger log = LoggerFactory.getLogger(ClientServiceImpl.class);

	@Autowired
	private RestTemplate restTemplate;

	@Value("${token.api.url}")
	private String tokenUrl;

	@Value("${token.api.client}")
	private String clientId;

	@Value("${token.api.secrete}")
	private String secretId;

	@Value("${api.valid.client.url}")
	private String validateClientUrl;

	@Value("${refresh.api.url}")
	private String refreshUrl;

	@Value("${redirect.url}")
	private String redirectUrl;

	@Override
	/**
	 * validate client and prepare redirect url
	 */
	public LassoRedirectModel getValidateClient(String clientId, String redirectUri) {

		HttpHeaders headers = new HttpHeaders();

		headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
		HttpEntity<Void> entity = new HttpEntity<>(headers);
		Map<String, String> params = new HashMap<>();
		params.put("client_id", clientId);
		params.put("redirect_uri", redirectUri);

		String finalValidateClientUrl = validateClientUrl + "?client_id=" + clientId + "&redirect_uri=" + redirectUri;

		log.info("url client validation api :- {}", finalValidateClientUrl);
		ResponseEntity<ValidateClientResponse> res = restTemplate.exchange(finalValidateClientUrl, HttpMethod.GET,
				entity, ValidateClientResponse.class, params);
		String callbackURL =null;
		
		ValidateClientResponse validateClient = res.getBody();

		if(null != validateClient  && null != validateClient.getLassoRedirectURL() && null !=validateClient.getType()) {
		callbackURL = validateClient.getLassoRedirectURL() + "?client_id=" + clientId + "&redirect_uri="
				+ redirectUri + "&response_type=code&scope=read&&type=" + validateClient.getType();

		}
		LassoRedirectModel lassoRedirectModel = new LassoRedirectModel();
		lassoRedirectModel.setLassoRedirectURL(callbackURL);
		return lassoRedirectModel;
	
	}

	@Override
	/**
	 * this method used for generate auth code base JWT token
	 */
	public AuthTokenResponce genToken(String code) {

		String authStr = clientId + ":" + secretId;
		String base64Creds = Base64.getEncoder().encodeToString(authStr.getBytes());
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
		headers.add("Authorization", "Basic " + base64Creds);
		MultiValueMap<String, String> map = new LinkedMultiValueMap<>();
		map.add("grant_type", "authorization_code");
		map.add("code", code);
		map.add("redirect_uri", redirectUrl);
		HttpEntity<MultiValueMap<String, String>> entity = new HttpEntity<>(map, headers);
		ResponseEntity<AuthTokenResponce> res = restTemplate.postForEntity(tokenUrl, entity, AuthTokenResponce.class);
		return res.getBody();

	}

	@Override
	/**
	 * this method used for generate JWT token based on refresh token
	 */
	public AuthTokenResponce refreshToken(String token) {

		String authStr = clientId + ":" + secretId;
		String base64Creds = Base64.getEncoder().encodeToString(authStr.getBytes());
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
		headers.add("Authorization", "Basic " + base64Creds);
		MultiValueMap<String, String> map = new LinkedMultiValueMap<>();
		map.add("grant_type", "refresh_token");
		map.add("refresh_token", token);
		HttpEntity<MultiValueMap<String, String>> entity = new HttpEntity<>(map, headers);
		ResponseEntity<AuthTokenResponce> res = restTemplate.postForEntity(refreshUrl, entity, AuthTokenResponce.class);
		return res.getBody();
	}

}
