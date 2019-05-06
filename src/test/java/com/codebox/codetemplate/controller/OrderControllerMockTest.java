package com.codebox.codetemplate.controller;

import com.codebox.codetemplate.base.MockEnvironment;
import org.hamcrest.Matchers;
import org.junit.Test;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

public class OrderControllerMockTest extends MockEnvironment {

    @Test
    public void query() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/api/order/query?pageNum=1&pageSize=10&status=1"))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string(Matchers.containsString("10000")));
    }

}
