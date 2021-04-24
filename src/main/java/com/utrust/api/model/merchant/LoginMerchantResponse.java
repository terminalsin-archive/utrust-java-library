package com.utrust.api.model.merchant;

import com.google.gson.annotations.SerializedName;

public class LoginMerchantResponse {
    @SerializedName("data")
    private Data data;

    static class Data {
        @SerializedName("type")
        private String type;

        @SerializedName("id")
        private String id;

        @SerializedName("attributes")
        private Attributes attributes;
    }

    static class Attributes {
        @SerializedName("token")
        private String token;

        @SerializedName("tfa_missing")
        private boolean tfa;


    }

    public String getType() {
        return data.type;
    }

    public String getId() {
        return data.id;
    }

    public String getToken() {
        return data.attributes.token;
    }

    public boolean isTfa() {
        return data.attributes.tfa;
    }
}
