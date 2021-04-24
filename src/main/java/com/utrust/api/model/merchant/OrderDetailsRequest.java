package com.utrust.api.model;

import com.google.gson.annotations.SerializedName;

public class OrderDetailsRequest {
    @SerializedName("order_id")
    private String orderId;

    @SerializedName("include")
    private String include;

    public OrderDetailsRequest(String orderId, String include) {
        this.orderId = orderId;
        this.include = include;
    }
}
