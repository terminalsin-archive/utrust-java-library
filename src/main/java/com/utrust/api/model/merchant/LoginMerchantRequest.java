package com.utrust.api.model.merchant;

import com.google.gson.annotations.SerializedName;

public class LoginMerchantRequest {
    @SerializedName("data")
    private Data data = new Data();

    static class Data {
        @SerializedName("type")
        private String type = "session";

        @SerializedName("attributes")
        private Attributes attributes = new Attributes();
    }

    static class Attributes {
        @SerializedName("email")
        private String email;

        @SerializedName("password")
        private String password;

    }

    public void setEmail(String email) {
        this.data.attributes.email = email;
    }

    public void setPassword(String password) {
        this.data.attributes.password = password;
    }

    public void setData(Data data) {
        this.data = data;
    }

    public void setType(String type) {
        this.data.type = type;
    }
}
