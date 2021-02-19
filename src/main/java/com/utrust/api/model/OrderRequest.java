package com.utrust.api.model;

import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Ghast
 * @since 19/02/2021
 * UTrust-Java-Library © 2021
 */
public class OrderRequest {

    @SerializedName("data")
    private final Data data = new Data();

    static class Data {
        @SerializedName("type")
        protected final String type = "orders";

        @SerializedName("attributes")
        protected final Attributes attributes = new Attributes();
    }

    static class Attributes {
        @SerializedName("order")
        protected final Order order = new Order();

        @SerializedName("customer")
        protected final Customer customer = new Customer();

    }

    static class Order {

        @SerializedName("reference")
        protected String reference;

        @SerializedName("amount")
        protected final Amount amount = new Amount();

        @SerializedName("return_urls")
        protected final Return returnUrls = new Return();

        @SerializedName("line_items")
        protected final List<Item> items = new ArrayList<>();

    }

    static class Return {
        @SerializedName("return_url")
        private String returnUrl;

        @SerializedName("cancel_url")
        private String cancelUrl = "";

        @SerializedName("callback_url")
        private String callbackUrl = "";
    }

    static class Customer {
        @SerializedName("email")
        private String email;

        @SerializedName("country")
        private String country;
    }

    static class Amount {
        @SerializedName("total")
        protected String total;

        @SerializedName("currency")
        protected String currency;

    }


    public void setReference(String reference) {
        this.data.attributes.order.reference = reference;
    }

    public void setTotal(String total) {
        this.data.attributes.order.amount.total = total;
    }

    public void setCurrency(String currency) {
        this.data.attributes.order.amount.currency = currency;
    }

    public void setReturnUrl(String returnUrl) {
        this.data.attributes.order.returnUrls.returnUrl = returnUrl;
    }

    public void setCancelUrl(String cancelUrl) {
        this.data.attributes.order.returnUrls.cancelUrl = cancelUrl;
    }

    public void setCallbackUrl(String callbackUrl) {
        this.data.attributes.order.returnUrls.callbackUrl = callbackUrl;
    }

    public void setEmail(String email) {
        this.data.attributes.customer.email = email;
    }

    public void setCountry(String country) {
        this.data.attributes.customer.country = country;
    }

    public void addItem(Item item) {
        this.data.attributes.order.items.add(item);
    }

    public static class Item {
        @SerializedName("sku")
        private String sku;

        @SerializedName("name")
        private String name;

        @SerializedName("price")
        private String price;

        @SerializedName("currency")
        private String currency;

        @SerializedName("quantity")
        private int quantity;

        public Item(String sku, String name, String price, String currency, int quantity) {
            this.sku = sku;
            this.name = name;
            this.price = price;
            this.currency = currency;
            this.quantity = quantity;
        }

        public Item() {
            this(null, null, null, null, 0);
        }

        public void setSku(String sku) {
            this.sku = sku;
        }

        public void setName(String name) {
            this.name = name;
        }

        public void setPrice(String price) {
            this.price = price;
        }

        public void setCurrency(String currency) {
            this.currency = currency;
        }

        public void setQuantity(int quantity) {
            this.quantity = quantity;
        }
    }


}
