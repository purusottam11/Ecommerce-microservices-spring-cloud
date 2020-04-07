package com.retail.shoping.orderservice.controller;

import com.retail.shoping.orderservice.model.OrderTb;
import com.retail.shoping.orderservice.service.OrderService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/order")
public class OrderController {

    Logger log = LoggerFactory.getLogger(OrderController.class);

    @Autowired
    private OrderService orderService;


    @PostMapping("/add-order")
    public OrderTb isProductOutOfStuck(@RequestBody OrderTb order) {
        log.debug("Request {}", order);
        OrderTb order1 = new OrderTb();
        try {
            BeanUtils.copyProperties(orderService.addOrder(order), order1);
        } catch (Exception e) {
            e.printStackTrace();
        }
        log.debug("Response {}", order1);
        return order1;
    }

    @GetMapping("/all-orders")
    public List<OrderTb> getAllOrders() {
        log.debug("Request {}", "all orders ");
        List<OrderTb> list = orderService.getAllOrder();
        log.debug("Response {}", list);
        return list;
    }

}
