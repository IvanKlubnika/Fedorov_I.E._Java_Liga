package com.ligatask;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;


@Component
@Repository
public class OrderRepository implements OrderDAO{

    private final JdbcTemplate jdbcTemplate;

    KeyHolder holder = new GeneratedKeyHolder();

    @Autowired
    public OrderRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Order insert(Order order) {
        String insertCustomer = "INSERT INTO CUSTOMER (PERSON_ID, NAME, EMAIL_ADDRESS) values (?, ?, ?)";
        String insertOrders = "INSERT INTO ORDERS (ORDER_ID, NAME, PERSON_ID, PRICE) values (?, ?, ?, ?)";


        jdbcTemplate.update(insertCustomer, order.getCustomer().getCustomerId(), order.getCustomer().getName(), order.getCustomer().getEmailAddress());
        jdbcTemplate.update(insertOrders, holder, order.getName(), order.getCustomer().getCustomerId(), order.getPrice());

        order.getCustomer().setCustomerId((int) holder.getKey());
        return order;
    }
}


