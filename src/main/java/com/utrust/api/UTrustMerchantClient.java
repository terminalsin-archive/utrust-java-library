package com.utrust.api;

import com.google.gson.Gson;
import com.utrust.api.model.merchant.LoginMerchantRequest;
import com.utrust.api.model.merchant.LoginMerchantResponse;
import com.utrust.api.model.merchant.OrderDetailsRequest;
import com.utrust.api.model.merchant.OrderDetailsResponse;
import com.utrust.api.model.store.OrderRequest;
import com.utrust.api.model.store.OrderResponse;
import com.utrust.api.util.Request;
import com.utrust.api.util.Response;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * @author Ghast
 * @since 19/02/2021
 * UTrust-Java-Library © 2021
 */
public class UTrustMerchantClient {
    private static final String API_ROOT = "https://merchants.api.utrust.com/api/";
    private static final String API_SANDBOX = "https://merchants.api.sandbox-utrust.com/api/";
    private static final Gson GSON = new Gson();

    private final String apiKey;
    private final boolean sandbox;

    public UTrustMerchantClient(String email, String password, boolean sandbox) {
        this.sandbox = sandbox;
        this.apiKey = this.generateSession(email, password);
    }

    private String generateSession(String email, String password) {
        final Request request;
        try {
            request = new Request(new URL((sandbox ? API_SANDBOX : API_ROOT) + "session"));
        } catch (MalformedURLException e) {
            throw new IllegalStateException("Beep boop: Something is wrong, API url is malformed?");
        }

        final LoginMerchantRequest loginMerchantRequest = new LoginMerchantRequest();
        loginMerchantRequest.setEmail(email);
        loginMerchantRequest.setPassword(password);

        request.setType(Request.MethodType.POST);
        request.setContentData("application/vnd.api+json");
        request.setUseragent("UStore Java Client API v1.0.0 [By Ghast]");
        request.setFollowRedirects(false);
        request.setData(new Gson().toJson(loginMerchantRequest));

        try {
            final Response response = request.getResponse();

            if (response.getResponseCode() != 200) {
                throw new IllegalArgumentException(response.getResponse());
            }

            final LoginMerchantResponse orderResponse = GSON.fromJson(response.getResponse(), LoginMerchantResponse.class);

            if (orderResponse.getToken() == null) {
                throw new IllegalArgumentException(orderResponse.toString());
            }

            Runtime.getRuntime().addShutdownHook(new Thread(() -> {
                final Request request1;
                try {
                    request1 = new Request(new URL((sandbox ? API_SANDBOX : API_ROOT) + "session"));
                } catch (MalformedURLException e) {
                    throw new IllegalStateException("Beep boop: Something is wrong, API url is malformed?");
                }

                request1.setType(Request.MethodType.DEL);
                request1.setContentData("application/vnd.api+json");
                request1.setUseragent("UStore Java Client API v1.0.0 [By Ghast]");
                request1.addProperty("Authorization", "Bearer " + orderResponse.getToken());
                request1.setFollowRedirects(false);

                try {
                    request1.getResponse();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }));

            return orderResponse.getToken();

        } catch (IOException e) {
            throw new IllegalStateException(e);
        }
    }

    public OrderDetailsResponse checkOrder(OrderDetailsRequest order) {
        final Request request;
        try {
            request = new Request(new URL((sandbox ? API_SANDBOX : API_ROOT) + "orders/" + order.getOrderId()));
        } catch (MalformedURLException e) {
            throw new IllegalStateException("Beep boop: Something is wrong, API url is malformed?");
        }

        request.setType(Request.MethodType.GET);
        request.setContentData("application/vnd.api+json");
        request.addProperty("Authorization", "Bearer " + apiKey);
        request.setUseragent("UStore Java Client API v1.0.0 [By Ghast]");
        request.setFollowRedirects(false);

        try {
            final Response response = request.getResponse();

            if (response.getResponseCode() != 200) {
                throw new IllegalArgumentException(response.getResponse());
            }

            final OrderDetailsResponse orderResponse = GSON.fromJson(response.getResponse(), OrderDetailsResponse.class);

            if (orderResponse.getData() == null) {
                throw new IllegalArgumentException(orderResponse.toString());
            }

            return orderResponse;

        } catch (IOException e) {
            throw new IllegalStateException(e);
        }
    }
}
