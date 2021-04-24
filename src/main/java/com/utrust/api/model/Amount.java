package com.utrust.api.model;

import com.google.gson.annotations.SerializedName;

public class Amount {
    @SerializedName("total")
    private String total;

    @SerializedName("currency")
    private String currency;


    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    @Override
    public String toString() {
        return "Amount{" +
                "total='" + total + '\'' +
                ", currency='" + currency + '\'' +
                '}';
    }
}