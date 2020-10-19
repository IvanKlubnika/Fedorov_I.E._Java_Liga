package com.ligatask;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;


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
    public Order insert(Customer customer, Order order) {
        String insert = "insert into Orders (ORDER_ID, NAME, PERSON_ID, PRICE) values (?, ?, ?, ?)";

        jdbcTemplate.update(insert, holder, order.getName(), customer.getID(), order.getPrice());
        order.setOrderID((int) holder.getKey());
        return order;
    }
}


