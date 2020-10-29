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
    @Mock
    KeyHolder keyHolder;

    @BeforeEach
    public void init(){
        MockitoAnnotations.initMocks(this);
        orderRepository = new OrderRepository(jdbcTemplate);
    }

    @Test
    @DisplayName("Создание заказа")
    void insertTest() {
        Order order = new Order("blade", 11, 1500);


        Mockito.verify(keyHolder).getKey();
        Mockito.verify(jdbcTemplate).update(Mockito.any(String.class), Mockito.any(Integer.class), Mockito.any(String.class), Mockito.any(String.class));

        keyHolder = Mockito.spy(new GeneratedKeyHolder());
        orderRepository.holder = keyHolder;
        Mockito.doReturn(1).when(keyHolder).getKey();

    }
}

