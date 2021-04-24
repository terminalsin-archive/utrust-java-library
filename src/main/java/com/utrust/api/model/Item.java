package com.utrust.api.model;

import com.google.gson.annotations.SerializedName;

public class Item {
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

    @Override
    public String toString() {
        return "Item{" +
                "sku='" + sku + '\'' +
                ", name='" + name + '\'' +
                ", price='" + price + '\'' +
                ", currency='" + currency + '\'' +
                ", quantity=" + quantity +
                '}';
    }
}