package com.ligatask;

import lombok.NonNull;

public class Customer {
    Integer ID;
    String name;
    String emailAddress;

    @NonNull Customer(Integer ID) {
        this.ID = ID;
    }

    @NonNull
    public void setName(String name) {
        this.name = name;
    }

    @NonNull
    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }


    public String getName() {
        return this.name;
    }

    public Integer getID() {
        return this.ID;
    }

    public String getEmailAddress() {
        return this.emailAddress;
    }
}
