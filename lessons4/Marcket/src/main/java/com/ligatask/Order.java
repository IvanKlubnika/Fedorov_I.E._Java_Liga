package com.ligatask;

import lombok.NonNull;

public class Order {
    Integer customerID;
    String name;
    Integer price;

    @NonNull
    void setCustomerID(Integer customerID){
        this.customerID = customerID;
    }

    @NonNull
    void setName(String name){
        this.name = name;
    }

    @NonNull
    void  setPrice(Integer price){
        this.price = price;
    }

    Integer getCustomerID(){ return this.customerID; }

    String getName(){
        return this.name;
    }

    Integer getPrice(){
        return this.price;
    }
}