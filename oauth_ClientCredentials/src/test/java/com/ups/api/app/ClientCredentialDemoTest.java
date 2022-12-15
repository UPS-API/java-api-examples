package com.ups.api.app;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThrows;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import com.ups.api.ClientCredentialApplication;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.util.ReflectionTestUtils;
import org.springframework.web.client.RestTemplate;

@SpringBootTest(classes = ClientCredentialApplication.class)
class ClientCredentialDemoTest {

    @Autowired
    AppConfig appConfig;

    @Autowired
    RestTemplate restTemplate;

    @Test
     void getAccessToken() {
        String accessToken = ClientCredentialDemo.getAccessToken(appConfig, restTemplate);
        assertNotNull( accessToken);
    }

    @Test
    void getAccessTokenWithError() {
        //appConfig.setPreviousObtainedToken(null);
       // appConfig.setAccessToken(null);
        ReflectionTestUtils.setField(appConfig, "clientID", "test client_id");
        Exception exception = assertThrows(RuntimeException.class, () -> {
            //Integer.parseInt("1a");
            ClientCredentialDemo.getAccessToken(appConfig, restTemplate);
        });
       // assertNotNull( accessToken);
    }

    @Test
    void testMain() {
        assertDoesNotThrow(() -> {
            ClientCredentialApplication.main(new String[]{
                    "--spring.main.web-environment=false",
                    "--spring.autoconfigure.exclude=blahblahblah"
            });
        });
    }
}