package com.utrust.api.model.merchant;

import com.google.gson.annotations.SerializedName;
import com.utrust.api.model.Amount;
import com.utrust.api.model.Customer;
import com.utrust.api.model.Item;

import java.util.List;

public class OrderDetailsResponse {
    @SerializedName("data")
    private Data data;

    static class Data {
        @SerializedName("id")
        private String id;

        @SerializedName("type")
        private String type;

        @SerializedName("attributes")
        private Attributes attributes;

        @Override
        public String toString() {
            return "Data{" +
                    "id='" + id + '\'' +
                    ", type='" + type + '\'' +
                    ", attributes=" + attributes +
                    '}';
        }
    }

    static class Attributes {
        @SerializedName("status")
        private String status;

        @SerializedName("created_at")
        private String createdAd;

        @SerializedName("total_amount")
        private Amount amount;

        @SerializedName("customer")
        private Customer customer;

        @SerializedName("merchant_uuid")
        private String merchantUuid;

        @SerializedName("items")
        private List<Item> items;


        @Override
        public String toString() {
            return "Attributes{" +
                    "status='" + status + '\'' +
                    ", createdAd='" + createdAd + '\'' +
                    ", amount=" + amount +
                    ", customer=" + customer +
                    ", merchantUuid='" + merchantUuid + '\'' +
                    ", items=" + items +
                    '}';
        }
    }

    public Data getData() {
        return data;
    }

    public String getStatus() {
        return data.attributes.status;
    }

    public String getCreatedAd() {
        return data.attributes.createdAd;
    }

    public Amount getAmount() {
        return data.attributes.amount;
    }

    public Customer getCustomer() {
        return data.attributes.customer;
    }

    public String getMerchantUuid() {
        return data.attributes.merchantUuid;
    }

    public List<Item> getItems() {
        return data.attributes.items;
    }

    @Override
    public String toString() {
        return "OrderDetailsResponse{" +
                "data=" + data +
                '}';
    }
}
