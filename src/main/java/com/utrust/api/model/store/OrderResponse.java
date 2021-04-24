package com.utrust.api.model;

import com.google.gson.annotations.SerializedName;

/**
 * @author Ghast
 * @since 19/02/2021
 * UTrust-Java-Library © 2021
 */
public class OrderResponse {
    @SerializedName("data")
    private Data data;

    static class Data {
        @SerializedName("type")
        protected String type;

        @SerializedName("id")
        protected String id;

        @SerializedName("attributes")
        protected Attributes attributes;
    }

    static class Attributes {
        @SerializedName("redirect_url")
        protected String redirectUrl;
    }

    public String getType() {
        return data.type;
    }

    public String getId() {
        return data.id;
    }

    public String getRedirectUrl() {
        return data.attributes.redirectUrl;
    }

    @Override
    public String toString() {
        return "OrderResponse{" +
                "type='" + data.type + '\'' +
                ", id='" + data.id + '\'' +
                ", redirectUrl='" + data.attributes.redirectUrl + '\'' +
                '}';
    }

}
