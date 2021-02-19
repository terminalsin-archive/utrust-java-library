package com.utrust.api.model;

import com.google.gson.annotations.SerializedName;

/**
 * @author Ghast
 * @since 19/02/2021
 * UTrust-Java-Library © 2021
 */
public class Account {
    @SerializedName("data.type")
    private final String type = "account";

    @SerializedName("data.attributes.email")
    private String email;

    @SerializedName("data.attributes.password")
    private String password;

    @SerializedName("data.attributes.organization_name")
    private String orgName;

    @SerializedName("data.attributes.first_name")
    private String firstName;

    @SerializedName("data.attributes.last_name")
    private String lastName;

    public Account() {
        this(null, null, null, null, null);
    }

    public Account(String email, String password, String orgName, String firstName, String lastName) {
        this.email = email;
        this.password = password;
        this.orgName = orgName;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setOrgName(String orgName) {
        this.orgName = orgName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
