package com.ups.api.app.tool;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ups.api.app.AppConfig;
import com.ups.api.app.PickupDemo;
import lombok.extern.slf4j.Slf4j;
import org.openapitools.oauth.client.ApiClient;
import org.openapitools.oauth.client.api.OAuthApi;
import org.openapitools.oauth.client.model.GenerateTokenSuccessResponse;
import org.springframework.http.HttpHeaders;
import org.springframework.web.client.RestTemplate;

import java.nio.charset.StandardCharsets;
import java.util.*;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import java.util.function.Consumer;

@Slf4j
public class Util {


    private static String CLIENT_CREDENTIALS = "client_credentials";
    private static String BASIC_AUTH = "Basic ";
    private static final AtomicLong EXPIRY = new AtomicLong(0);
    private static final AtomicLong TOKEN_EXPIRY_TOLERANCE_IN_SEC = new AtomicLong(5);
    private static boolean readExpiryToleranceFromConfig = false;

    private static final Map<String, API_TYPE> JSON_OBJECT_TO_TARGET_TYPE = new HashMap<>();
    static {
        JSON_OBJECT_TO_TARGET_TYPE
                .put("\"PickupPendingStatusResponse\".\"PendingStatus\"", API_TYPE.ARRAY);
    }

    private enum API_TYPE {
        ARRAY
    }
    private static boolean isTokenExpired() {
        return( (EXPIRY.get() - new Date().getTime()/1000) - 1 < TOKEN_EXPIRY_TOLERANCE_IN_SEC.get());
    }



    /**
     * getting JWT token from the api
     *
     * @param appConfig
     * @param restTemplate
     * @return
     */
    public static String getAccessToken(final AppConfig appConfig, final RestTemplate restTemplate) {
        if(!readExpiryToleranceFromConfig) {
            TOKEN_EXPIRY_TOLERANCE_IN_SEC.set(appConfig.getTokenExipryToleranceInSec());
            readExpiryToleranceFromConfig = true;
        }
        String accessToken = appConfig.getAccessTokenStore().get(appConfig.getClientID());
        if(null == accessToken || isTokenExpired()) {
            synchronized(Util.class) {
                if(null == accessToken || isTokenExpired()) {
                    OAuthApi oauthApi = new OAuthApi(new ApiClient(restTemplate));
                    final String encodedClientIdAndSecret = Base64.getEncoder().encodeToString(
                            (appConfig.getClientID() + ':' + appConfig.getSecret()).
                                    getBytes(StandardCharsets.UTF_8));
                    oauthApi.getApiClient().setBasePath(appConfig.getOauthBaseUrl());
                    oauthApi.getApiClient().addDefaultHeader(HttpHeaders.AUTHORIZATION, BASIC_AUTH + encodedClientIdAndSecret);
                    log.info("ecnoded clientId and secret: [{}]", encodedClientIdAndSecret);

                    try {
                        GenerateTokenSuccessResponse generateAccessTokenResponse = oauthApi.generateToken(CLIENT_CREDENTIALS, null);
                        accessToken = generateAccessTokenResponse.getAccessToken();
                        EXPIRY.set(new Date().getTime()/1000 + Long.parseLong(generateAccessTokenResponse.getExpiresIn()) - 2);
                    } catch (Exception ex) {
                        throw new IllegalStateException(ex);
                    }
                }
            }
        }
        log.info("access token [{}], expiry [{}]", accessToken, EXPIRY.get());
        appConfig.getAccessTokenStore().put(appConfig.getClientID(), accessToken);
        return accessToken;
    }

    /**
     * preparing request from the json file to object
     *
     * @param filePath
     * @param requestClass
     * @param appConfig
     * @param <T>
     * @return
     */
    public static <T> T createRequestFromJsonFile(final String filePath, final Class<T> requestClass,
                                                  final AppConfig appConfig) {
        try {
            ObjectMapper mapper = new ObjectMapper();
            T request = mapper.readValue(PickupDemo.class.getClassLoader().getResourceAsStream(filePath),
                    requestClass);

            return request;
        } catch (Exception ex) {
            throw new RuntimeException("failed to constrcut object from [" + filePath + ']', ex);
        }
    }
    /**
     * json result preprocessing
     *
     * @param resultResponse
     * @param jsonObject2TargetType
     * @param targetClassType
     * @return
     * @param <T>
     * @throws JsonProcessingException
     */
    public static <T> T jsonResultPreprocess(final String resultResponse,
                                             final Map<String, API_TYPE> jsonObject2TargetType, Class<T> targetClassType)
            throws JsonProcessingException {
        AtomicReference<String> response = new AtomicReference<>(resultResponse);

        Consumer<Map.Entry<String, API_TYPE>> convertObjectToArray = entry -> {
            final String elementString = entry.getKey();

            String updatedResponse = response.get();

            // find the end position of last element.
            AbstractMap.SimpleEntry<String, Integer> pointer = indexOf(elementString, updatedResponse);
            if (pointer.getValue() != -1) {
                updatedResponse = updateJsonResponse(updatedResponse, pointer);
            }
            // store the updated response for next element processing in the
            // jsonObject2TargetType.
            response.set(updatedResponse);
        };

        // Currently converting object to array of object.
        jsonObject2TargetType.entrySet().stream().filter(entry -> entry.getValue() == API_TYPE.ARRAY)
                .forEach(convertObjectToArray::accept);

        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.readValue(response.get(), targetClassType);
    }

    /**
     * updating json response
     *
     * @param response
     * @param pointer
     * @return
     */
    private static String updateJsonResponse(final String response, final AbstractMap.SimpleEntry<String, Integer> pointer) {
        int position = pointer.getValue();
        String lastElement = pointer.getKey();

        String updatedResponse = response;
        while (-1 != position) {
            position = updatedResponse.indexOf(":", position);

            // Is last element already an array in resultResponse?
            boolean arrayType = false;
            boolean done = false;
            for (int i = position + 1; i < updatedResponse.length(); i++) {
                if (updatedResponse.charAt(i) == '{') {
                    // non-array
                    position = i;
                    done = true;
                } else if (updatedResponse.charAt(i) == '[') {
                    arrayType = true;
                    done = true;
                }

                if (done) {
                    break;
                }
            }

            if (!arrayType) {
                StringBuilder builder = new StringBuilder(updatedResponse.substring(0, position));
                builder.append('[').append(updatedResponse.substring(position, updatedResponse.length()));
                updatedResponse = addClosingArray(builder.toString(), position);
            }
            position = updatedResponse.indexOf(lastElement, position);
        }
        return updatedResponse;
    }

    /**
     * mapping json object to responce
     *
     * @param elementString
     * @param response
     * @return
     */
    private static AbstractMap.SimpleEntry<String, Integer> indexOf(final String elementString, final String response) {
        int position = 0;
        final String[] elements = elementString.split("\\.");
        String lastElement = null;
        for (String element : elements) {
            position = response.indexOf(element, position);
            if (-1 == position) {
                return new AbstractMap.SimpleEntry<>(lastElement, position);
            }
            lastElement = element;
            position += lastElement.length();
        }

        if (-1 == position || null == lastElement) {
            throw new NoSuchElementException(elementString + " does not exist in response");
        }

        return new AbstractMap.SimpleEntry<>(lastElement, position);
    }

    private static String addClosingArray(final String response, int position) {
        position = response.indexOf('{', position);
        if (-1 == position) {
            throw new NoSuchElementException("internal error - cannot find beginning of element.");
        }

        int outstandingParathesis = 0;

        for (int i = position + 1; i < response.length(); i++) {
            if (response.charAt(i) == '}') {
                if (outstandingParathesis == 0) {
                    // found the element of element.
                    StringBuilder builder = new StringBuilder(response.substring(0, i + 1));
                    builder.append(']').append(response.substring(i + 1, response.length()));
                    return builder.toString();
                } else {
                    outstandingParathesis--;
                }
            }
            if (response.charAt(i) == '{') {
                outstandingParathesis++;
            }
        }
        throw new NoSuchElementException("incomplete response - missing ending element parathesis [" + response + ']');
    }

    public static void dayRoll(final Calendar startDay, int days) {
        int offsetBy = 1;
        if (0 > days) {
            offsetBy = -1;
            days = Math.abs(days);
        }
        for (int i = 0; i < days; i++) {
            do {
                startDay.add(Calendar.DAY_OF_MONTH, offsetBy);
            } while (!isWeekDay(startDay));
        }
    }

    public static boolean isWeekDay(Calendar cal) {
        int dayOfWeek = cal.get(Calendar.DAY_OF_WEEK);
        return (dayOfWeek != Calendar.SUNDAY && dayOfWeek != Calendar.SATURDAY);
    }
    public static Map<String, API_TYPE> getJsonToObjectConversionMap() {
        return Collections.unmodifiableMap(JSON_OBJECT_TO_TARGET_TYPE);
    }

    private Util() {
    }
}
