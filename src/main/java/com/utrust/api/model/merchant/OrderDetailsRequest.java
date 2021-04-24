package com.utrust.api.model.merchant;

public class OrderDetailsRequest {
    private String orderId;

    public OrderDetailsRequest(String orderId) {
        this.orderId = orderId;
    }

    public OrderDetailsRequest() {
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }
}
