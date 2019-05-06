package com.codebox.codetemplate.mapper;

import com.codebox.codetemplate.domain.Order;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.boot.test.autoconfigure.MybatisTest;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.List;

//使用配置的数据库，而不是内存数据库
@RunWith(SpringRunner.class)
@MybatisTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class OrderMapperTest {

    @Resource
    private OrderMapper orderMapper;

    @Test
    public void findAll() {
        List<Order> orderList = orderMapper.findAll();
        Assertions.assertThat(orderList.size()).isEqualTo(1);
    }

}