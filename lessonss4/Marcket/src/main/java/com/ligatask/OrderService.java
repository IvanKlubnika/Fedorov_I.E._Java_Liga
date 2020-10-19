package com.ligatask;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepository orderRepository;

    protected Order createOrder(Order order) throws InvalidRequest {

        if ((order.getCustomerID() > 0) && (order.getPrice() > 0) && (order.name != null)) {
            Customer customer = new Customer();
            customer.setID(order.getCustomerID());
            return orderRepository.insert(customer, order);
        } else throw new InvalidRequest("Некорректный запрос");
    }
}

class InvalidRequest extends Exception{
    public InvalidRequest(String message){
        super(message);
    }
}
