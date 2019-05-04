package com.codebox.codetemplate.service.order;

import com.codebox.codetemplate.domain.Order;
import com.codebox.codetemplate.domain.enums.OrderStatus;
import com.codebox.codetemplate.mapper.OrderMapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    @Resource
    OrderMapper orderMapper;

    @Override
    public int addOrder(Order order) {
        return orderMapper.insert(order);
    }

    @Override
    public Order findById(Long id) {
        return orderMapper.findById(id);
    }

    @Override
    public List<Order> findAll() {
        return orderMapper.findAll();
    }

    @Override
    public int delete(Long id) {
        return orderMapper.delete(id);
    }

    @Override
    public List<Order> findByStatus(OrderStatus status) {
        return orderMapper.selectOrders(status);
    }

    @Override
    public PageInfo<Order> findAllOrder(int pageNum, int pageSize) {
        //将参数传给这个方法就可以实现物理分页了，非常简单。
        PageHelper.startPage(pageNum, pageSize);
        List<Order> orderList = orderMapper.findAll();
        PageInfo result = new PageInfo(orderList);
        return result;
    }

    @Override
    public PageInfo<Order> findOrderByStatus(int pageNum, int pageSize, OrderStatus status) {
        PageHelper.startPage(pageNum, pageSize);
        List<Order> orderList = orderMapper.selectOrders(status);
        PageInfo result = new PageInfo(orderList);
        return result;
    }

    @Override
    public int addOrderOther(Order order) {
        return orderMapper.insertOther(order);
    }
}
