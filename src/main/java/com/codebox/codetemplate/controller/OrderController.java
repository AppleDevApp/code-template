package com.codebox.codetemplate.controller;

import com.codebox.codetemplate.api.common.ApiResponse;
import com.codebox.codetemplate.api.common.PageVo;
import com.codebox.codetemplate.api.dto.OrderDto;
import com.codebox.codetemplate.api.vo.OrderVo;
import com.codebox.codetemplate.core.exception.CommonException;
import com.codebox.codetemplate.domain.Order;
import com.codebox.codetemplate.domain.enums.OrderStatus;
import com.codebox.codetemplate.service.order.OrderService;
import com.codebox.codetemplate.util.CodeEnumUtil;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api/order")
public class OrderController {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    OrderService orderService;

    @PostMapping("add")
    public ApiResponse<String> create(@Valid @RequestBody OrderDto orderDto) throws CommonException {
        Order order = new Order();
        order.setNo(orderDto.getNo());
        order.setTitle(orderDto.getTitle());
        order.setTotalAmount(orderDto.getTotalAmount());
        order.setStatus(OrderStatus.CREATE);
        order.setCreateTime(new Date());
        orderService.addOrder(order);

        return ApiResponse.sucess(String.valueOf(order.getId()));
    }

    //查询order
    @GetMapping("query")
    public ApiResponse<PageVo<OrderVo>> query(Integer pageNum, Integer pageSize, Integer status) {
        Page pageinfo = PageHelper.startPage(pageNum, pageSize);
        List<Order> orders;
        if (status == null) {
            orders = orderService.findAll();
        } else {
            orders = orderService.findByStatus(CodeEnumUtil.codeOf(OrderStatus.class, status));
        }
        List<OrderVo> orderVos = new ArrayList<>();
        for (Order order : orders) {
            OrderVo vo = new OrderVo();
            vo.setNo(order.getNo());
            vo.setTitle(order.getTitle());
            vo.setId(order.getId());
            vo.setStatus(order.getStatus() != null ? order.getStatus().getDesc() : null);
            vo.setTotalAmount(order.getTotalAmount());
            orderVos.add(vo);
        }

        return ApiResponse.sucess(new PageVo<>(pageinfo.getPageNum(), pageinfo.getPageSize(), pageinfo.getTotal(), pageinfo.getPages(), orderVos));
    }

}
