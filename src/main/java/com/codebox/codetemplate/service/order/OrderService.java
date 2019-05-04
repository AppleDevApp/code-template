package com.codebox.codetemplate.service.order;

import com.codebox.codetemplate.domain.Order;
import com.codebox.codetemplate.domain.enums.OrderStatus;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface OrderService {

    int addOrder(Order order);

    Order findById(Long id);

    List<Order> findAll();

    int delete(Long id);

    List<Order> findByStatus(OrderStatus status);

    PageInfo<Order> findAllOrder(int pageNum, int pageSize);

    PageInfo<Order> findOrderByStatus(int pageNum, int pageSize, OrderStatus status);

    int addOrderOther(Order order);

}
