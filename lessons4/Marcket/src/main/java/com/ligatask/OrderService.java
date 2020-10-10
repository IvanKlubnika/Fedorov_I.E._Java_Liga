package com.ligatask;


public class OrderService {

    OrderRepository orderRepository;

    protected void createOrder(Order order) throws Exception {

        if ((order.getCustomerID() > 0) && (order.getPrice() > 0) && (order.name != null)) {
            Customer customer = new Customer(order.getCustomerID());
            orderRepository.save(customer, order);
        } else throw new Exception("Некорректный запрос");
    }
}
