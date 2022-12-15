package com.ups.oauth.client.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ups.oauth.client.dto.AuthTokenResponce;
import com.ups.oauth.client.dto.LassoRedirectModel;
import com.ups.oauth.client.service.ClientService;

@RestController
@RequestMapping("client")
public class ClientController {

	private static final Logger log = LoggerFactory.getLogger(ClientController.class);

	@Autowired
	ClientService clientService;
	
	private String refreshToken ="refresh_token";

	@GetMapping(value = "/generate-token")
	public AuthTokenResponce genToken(@RequestParam(name = "code") String code) {
		AuthTokenResponce token =null;
	    token = clientService.genToken(code);

		return token;
	}

	@GetMapping(value = "/validate-client")
	public LassoRedirectModel getValidateClient(@RequestParam(name = "client_id") String clientId,
			@RequestParam(name = "redirect_uri") String redirectUri) {

		log.info("clint id is : {} and redirect Url is :-{}", clientId, redirectUri);
		LassoRedirectModel lasso =null;
		lasso = clientService.getValidateClient(clientId, redirectUri);

		return lasso;
	}

	@PostMapping(value = "/refresh-token", consumes = "application/x-www-form-urlencoded")
	public AuthTokenResponce refreshToken(@RequestBody MultiValueMap<String, String> paramMap) {
		AuthTokenResponce newToken = null;
		if (paramMap.containsKey(refreshToken) && null != paramMap.get(refreshToken).get(0)) {
			String token = paramMap.get(refreshToken).get(0);
			log.info("refresh token :-{}", token);
			newToken = clientService.refreshToken(token);
		}
		return newToken;

	}

}
