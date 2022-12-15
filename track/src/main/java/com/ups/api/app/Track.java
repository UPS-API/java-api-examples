package com.ups.api.app;

import java.util.UUID;

import org.openapitools.track.client.ApiClient;
import org.openapitools.track.client.api.SingleTrackApiControllerApi;
import org.openapitools.track.client.model.TrackApiResponse;
import org.springframework.boot.CommandLineRunner;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.ups.api.app.tool.Util;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
@AllArgsConstructor
public class Track implements CommandLineRunner {

	RestTemplate restTemplate;

	AppConfig appConfig;

	private static final ThreadLocal<SingleTrackApiControllerApi> api = new ThreadLocal<>();

	@Override
	public void run(String... args) throws Exception {
		try {
			// create a 32 character unique id.
			final String transId = UUID.randomUUID().toString().replace("-", "");

			// Get Tracking information
			final TrackApiResponse trackApiResponse = this.sendRequest(this.appConfig.getInquiryNumber(), transId,
					this.appConfig.getTransactionSrc(),
					"fr_FR",
					"false");
			ObjectMapper mapper = new ObjectMapper();

			mapper.enable(SerializationFeature.INDENT_OUTPUT);
			// convert user object to json string and return it
			log.info(" response[{}]", mapper.writeValueAsString(trackApiResponse));

		} catch (HttpClientErrorException httpClientException) {
			log.warn("Http exception - " + httpClientException.getStatusCode(), httpClientException);
		} catch (Exception ex) {
			this.applicationErrorHandler(ex);
		} finally {
			this.cleanup();
		}
		log.info("\n");
	}

	public TrackApiResponse sendRequest(final String inquiryNumber, final String transId, final String transSrc,
			final String locale, final String returnSignature) {
		log.info("transId: {}", transId);
		final String accessToken = Util.getAccessToken(this.appConfig, this.restTemplate);
		SingleTrackApiControllerApi trackApi = api.get();
		if (null == trackApi) {
			trackApi = new SingleTrackApiControllerApi(new ApiClient(this.restTemplate));
			trackApi.getApiClient().setBasePath(this.appConfig.getTrackBaseUrl());
			api.set(trackApi);
		}

		trackApi.getApiClient().addDefaultHeader(HttpHeaders.AUTHORIZATION, "Bearer " + accessToken);
		trackApi.getApiClient().addDefaultHeader(HttpHeaders.CONTENT_TYPE, "application/json");
		trackApi.getApiClient().addDefaultHeader(HttpHeaders.ACCEPT, "application/json");
		return trackApi.getSingleTrackResponseUsingGET(inquiryNumber, transId,
				transSrc,
				locale,
				returnSignature);
	}

	private void cleanup() {
		SingleTrackApiControllerApi trackApi = api.get();
		if (null != trackApi) {
			api.remove();
		}
	}

	private void applicationErrorHandler(Exception ex) {
		log.warn("failed to complete request", ex);
	}
}
