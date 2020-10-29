package com.ligatask;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepository orderRepository;

    public Order createOrder(Order order) throws InvalidRequest {

        if ((order.getCustomer().getCustomerId() > 0) && (order.getPrice() > 0) && (order.getName() != null)) {
            return orderRepository.insert(order);
        } else throw new InvalidRequest("Некорректный запрос");
    }
}


class InvalidRequest extends Exception{
    public InvalidRequest(String message){
        super(message);
    }
}
