package com.ligatask;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Customer {
    private Integer customerId;
    private String name;
    private String emailAddress;


    Customer(Integer customerId){
        this.customerId = customerId;
    }


    Customer(Integer customerId, String name){
        this.customerId = customerId;
        this.name = name;
    }

}
