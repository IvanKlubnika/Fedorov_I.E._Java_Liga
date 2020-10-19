package com.ligatask;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;

public class OrderRepositoryTest {
    private OrderRepository orderRepository;

    @Mock
    private JdbcTemplate jdbcTemplate;


    private KeyHolder keyHolder;

    @BeforeEach
    public void init(){
        MockitoAnnotations.initMocks(this);
        orderRepository = new OrderRepository(jdbcTemplate);
    }

    @Test
    @DisplayName("Создание заказа")
    void insertTest() {
        Order order = new Order(11, "blade", 1500);
        Customer customer = new Customer();
        customer.setID(2);

        keyHolder = Mockito.spy(new GeneratedKeyHolder());
        orderRepository.holder = keyHolder;
        Mockito.doReturn(1).when(keyHolder).getKey();
        Assertions.assertEquals(order, orderRepository.insert(customer, order));
    }
}
