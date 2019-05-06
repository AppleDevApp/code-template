package com.codebox.codetemplate.controller;

import com.codebox.codetemplate.base.MockEnvironment;
import com.codebox.codetemplate.domain.Order;
import com.codebox.codetemplate.domain.enums.OrderStatus;
import com.codebox.codetemplate.service.order.OrderService;
import org.hamcrest.Matchers;
import org.junit.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.Collections;
import java.util.Date;

public class OrderControllerWebLayerTest extends MockEnvironment {

    @MockBean
    private OrderService orderService;

    @Test
    public void query() throws Exception {

        OrderStatus orderStatus = OrderStatus.PAYING;

        Order order = new Order();
        order.setId(1L);
        order.setNo("Test001");
        order.setTitle("From Test Mock");
        order.setStatus(orderStatus);
        order.setTotalAmount(12.34f);
        order.setCreateTime(new Date());

        Mockito.when(orderService.findByStatus(orderStatus)).thenReturn(Collections.singletonList(order));

        mockMvc.perform(MockMvcRequestBuilders.get("/api/order/query?pageNum=1&pageSize=10&status=" + orderStatus.getValue()))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.content().string(Matchers.containsString("Test001")));
    }
}
