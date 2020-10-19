package com.ligatask;

import java.util.List;

interface OrderDAO {
    Order insert(Customer customer, Order order);
}