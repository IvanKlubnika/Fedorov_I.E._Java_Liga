package com.ligatask;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Order {
   private String  name;
   private Integer price;
   private Customer customer;
   private Integer orderId;

   Order(String name, Integer price, Integer customerId){
      this.name = name;
      this.price = price;
      this.customer = new Customer(customerId);

   }
}