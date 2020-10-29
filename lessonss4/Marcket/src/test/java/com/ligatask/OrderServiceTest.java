package com.ligatask;

import org.junit.Before;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.*;

public class OrderServiceTest {

    private OrderService orderService;

    @Mock
    OrderRepository orderRepository;


    @BeforeEach
    public void init(){
        MockitoAnnotations.initMocks(this);
        orderService = new OrderService(orderRepository);
    }

    @Test
    @DisplayName("Тестируем новый заказ и создание заказчика")
    void createOrderTest() throws Exception {

        Order order = new Order("blade", 11, 1500);

        //Проверяем что insert с аргументами (qcustomer, order), был вызван один раз при вызове orderService.createOrder(order)
        orderService.createOrder(order);
        verify(orderRepository.insert(order));

        Mockito.when(orderRepository.insert(order)).thenReturn(order);

    }
}
