package com.codebox.codetemplate.service.order;

import com.codebox.codetemplate.base.MockEnvironment;
import com.codebox.codetemplate.domain.Order;
import com.codebox.codetemplate.domain.enums.OrderStatus;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

//支持数据回滚，避免测试数据污染环境
@Transactional
@RunWith(SpringRunner.class)
@SpringBootTest
public class OrderServiceTest extends MockEnvironment {

    @Autowired
    public OrderService orderService;

    @Test
    public void addTest() {
        Order o = new Order();
        o.setNo("TEST003");
        o.setTitle("test");
        o.setTotalAmount(1F);
        o.setCreateTime(new Date());
        o.setStatus(OrderStatus.CREATE);
        orderService.addOrder(o);
        Assert.assertNotNull(o.getId());

        o.setId(null);
        orderService.addOrderOther(o);
        Assert.assertNotNull(o.getId());
    }
}