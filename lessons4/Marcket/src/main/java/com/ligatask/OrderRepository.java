package com.ligatask;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;


@Component
public class OrderRepository implements OrderDAO{

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public OrderRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void save(Customer customer, Order order) {
        String insert = "insert into Orders (first_Name, Last_Name, Address) values (?, ?, ?)";
        jdbcTemplate.update(insert, customer.getID(), order.getName(), order.getPrice());
    }



}


