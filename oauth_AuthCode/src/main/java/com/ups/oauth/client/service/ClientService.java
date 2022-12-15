package com.ups.oauth.client.service;

import org.springframework.stereotype.Service;

import com.ups.oauth.client.dto.AuthTokenResponce;
import com.ups.oauth.client.dto.LassoRedirectModel;

@Service
public interface ClientService {
	
	public AuthTokenResponce genToken(String code);
	
	public LassoRedirectModel getValidateClient( String clientId, String redirectUri);
	
	public AuthTokenResponce refreshToken(String token);
}
