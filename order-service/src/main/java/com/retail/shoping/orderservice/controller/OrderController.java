package com.retail.shoping.orderservice.controller;

import com.retail.shoping.orderservice.exception.BusinessException;
import com.retail.shoping.orderservice.model.Order;
import com.retail.shoping.orderservice.service.OrderService;
import org.aspectj.weaver.ast.Or;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/v1/orders")
public class OrderController {

    Logger log = LoggerFactory.getLogger(OrderController.class);

    @Autowired
    private OrderService orderService;

    @PostMapping("/placeOrder")
    public Order placeOrder(@RequestBody Order order) {
        Order order1 = new Order();
        log.info("Request {}", order);
        try {
            order1 = orderService.addOrder(order);
        } catch (Exception e) {
            throw new BusinessException(e.getMessage());
        }
        return order1;
    }

    @GetMapping("/orderList")
    public List<Order> getAllOrder() {
        return orderService.getAllOrder();
    }

}
