package com.ups.api.app;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.UUID;

import org.junit.jupiter.api.Test;
import org.openapitools.track.client.model.TrackApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.ups.api.TrackApplication;
import com.ups.api.app.AppConfig;
import com.ups.api.app.Track;
import com.ups.api.app.tool.Util;

@SpringBootTest(classes = TrackApplication.class)
public class TrackAppTest {
	@Autowired
	AppConfig appConfig;

	@Autowired
	RestTemplate restTemplate;

	@Test
    void testMain() {
		assertDoesNotThrow(() -> {
	        TrackApplication.main(new String[]{
	                "--spring.main.web-environment=false"
	        });
		});
    }

	@Test
	public void getAccessToken() {
		String accessToken = Util.getAccessToken(this.appConfig, this.restTemplate);
		assertNotNull(accessToken);
	}

	/**
	 * @throws JsonProcessingException
	 */
	@Test
	public void getTrackResponse() throws JsonProcessingException {
		Track track = new Track(this.restTemplate, this.appConfig);
		// create a 32 character unique id.
		final String transId = UUID.randomUUID().toString().replace("-", "");

		// Get Tracking information
		final TrackApiResponse trackApiResponse = track.sendRequest(this.appConfig.getInquiryNumber(), transId,
				this.appConfig.getTransactionSrc(),
				"en_US",
				"false");
		assertNotNull(trackApiResponse);
		assertNotNull(trackApiResponse.getTrackResponse());
		assertNotNull(trackApiResponse.getTrackResponse().getShipment());
	}
}
