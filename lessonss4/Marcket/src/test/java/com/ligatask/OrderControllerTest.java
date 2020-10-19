package com.ligatask;

import com.ligatask.InvalidRequest;
import com.ligatask.Order;
import com.ligatask.OrderController;
import com.ligatask.OrderService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.opentest4j.AssertionFailedError;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;


public class OrderControllerTest{

    private OrderController orderController;

    @Mock
    OrderService orderService;

    @BeforeEach
    public void init(){
        MockitoAnnotations.initMocks(this);
        orderController = new OrderController(orderService);
    }


    @Test
    @DisplayName("Тестируем новый заказ")
    void createOrderTest() throws Exception {

        Order order1 = new Order(11, "blade", -1500);
        Mockito.when(orderService.createOrder(order1)).thenThrow(new InvalidRequest("Некорректный запрос"));

        Order order2 = new Order(-11, "blade", 1500);
        Mockito.when(orderService.createOrder(order2)).thenThrow(new InvalidRequest("Некорректный запрос"));

        Order order3 = new Order(11, null, 1500);
        Mockito.when(orderService.createOrder(order3)).thenThrow(new InvalidRequest("Некорректный запрос"));

        Order order = new Order(11, "blade", 1500);
        Mockito.when(orderService.createOrder(order)).thenReturn(order);


        //Проверяем что orderService.createOrder(order) был вызван один раз при вызове orderController.createOrder(order)
        orderController.createOrder(order);
        verify(orderService.createOrder(order));
    }
}
