package com.utrust.api.model.store;

import com.google.gson.annotations.SerializedName;
import com.utrust.api.model.Amount;
import com.utrust.api.model.Customer;
import com.utrust.api.model.Item;

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

    public void setReference(String reference) {
        this.data.attributes.order.reference = reference;
    }

    public void setTotal(String total) {
        this.data.attributes.order.amount.setTotal(total);
    }

    public void setCurrency(String currency) {
        this.data.attributes.order.amount.setCurrency(currency);
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
        this.data.attributes.customer.setEmail(email);
    }

    public void setFirstName(String firstName) {
        this.data.attributes.customer.setFirstName(firstName);
    }

    public void setLastName(String lastName) {
        this.data.attributes.customer.setLastName(lastName);
    }

    public void setCountry(String country) {
        this.data.attributes.customer.setCountry(country);
    }

    public void addItem(Item item) {
        this.data.attributes.order.items.add(item);
    }





}
