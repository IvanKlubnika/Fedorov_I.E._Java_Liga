package com.ligatask;


import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
@SpringBootTest
@AutoConfigureMockMvc
class ControllerTestIntegration {

    @Autowired
    private MockMvc mvc;

    @Autowired
    ObjectMapper objectMapper;

    @Test
    public void createOrder() throws Exception {
        Order order = new Order("blade", 11, 1500);

        mvc.perform(post("/api/v1/order").contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(order)))
                .andExpect(status().isOk())
                //НЕ ПОНИМАЮ, Я ДОЛЖЕН ОЖИДАТЬ 4 ПАРАМЕТРА, один из них это ID заказа. Но он же генерируется keyholder, что мне указывать в ожидании ниже?
                .andExpect(content().json("{\"customerID\" : 4,  \"name\" : \"blade\",  \"price\" : 1500, \"orderID\" : 1}" ));
    }

}



