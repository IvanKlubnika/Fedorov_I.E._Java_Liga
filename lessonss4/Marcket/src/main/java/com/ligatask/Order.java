package com.ligatask;

import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

@Getter @Setter
public class Order {
    Integer customerID;
    String  name;
    Integer price;
    Integer orderID;

    @NonNull
    Order(Integer customerID, String name, Integer price){
        this.customerID = customerID;
        this.name = name;
        this.price = price;
    }
}