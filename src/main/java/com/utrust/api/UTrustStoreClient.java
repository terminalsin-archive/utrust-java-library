package com.utrust.api;

import com.google.gson.Gson;
import com.utrust.api.model.OrderRequest;
import com.utrust.api.model.OrderResponse;
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
public class UTrustStoreClient {
    private static final String API_ROOT = "https://merchants.api.utrust.com/api/stores/orders";
    private static final String API_SANDBOX = "https://merchants.api.sandbox-utrust.com/api/stores/orders";
    private static final Gson GSON = new Gson();

    private final String apiKey;
    private final boolean sandbox;

    public UTrustStoreClient(String apiKey, boolean sandbox) {
        this.apiKey = apiKey;
        this.sandbox = sandbox;
    }

    public OrderResponse generateOrder(OrderRequest order) {
        final Request request;
        try {
            request = new Request(new URL(sandbox ? API_SANDBOX : API_ROOT));
        } catch (MalformedURLException e) {
            throw new IllegalStateException("Beep boop: Something is wrong, API url is malformed?");
        }

        request.setType(Request.MethodType.POST);
        request.setContentData("application/vnd.api+json");
        request.addProperty("Authorization", "Bearer " + apiKey);
        request.setUseragent("UStore Java Client API v1.0.0 [By Ghast]");
        request.setData(GSON.toJson(order));
        request.setFollowRedirects(false);


        try {
            final Response response = request.getResponse();

            if (response.getResponseCode() != 201) {
                throw new IllegalArgumentException(response.getResponse());
            }

            final OrderResponse orderResponse = GSON.fromJson(response.getResponse(), OrderResponse.class);

            if (orderResponse.getRedirectUrl() == null) {
                throw new IllegalArgumentException(orderResponse.toString());
            }

            return orderResponse;

        } catch (IOException e) {
            throw new IllegalStateException(e);
        }
    }
}
