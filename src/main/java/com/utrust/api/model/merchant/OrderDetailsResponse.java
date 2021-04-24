package com.utrust.api.model;

import com.google.gson.annotations.SerializedName;

public class OrderDetailsResponse {
    @SerializedName("data")
    private Data data;

    static class Data {
        @SerializedName("id")
        private String id;

        @SerializedName("type")
        private String type;


    }

    static class Attributes {
        @SerializedName("status")
        private String status;

        @SerializedName("created_at")
        private String createdAd;

        @SerializedName("total_amount")
    }
}
