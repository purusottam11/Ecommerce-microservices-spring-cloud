package com.retail.shoping.orderservice.controller;

import com.retail.shoping.orderservice.model.Order;
import com.retail.shoping.orderservice.service.OrderService;
import org.apache.tomcat.jni.OS;
import org.aspectj.weaver.ast.Or;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private OrderService orderService;


    @PostMapping("/add-order")
    public Order isProductOutOfStuck(@RequestBody Order order) {
        Order order1 = new Order();
        try {
            BeanUtils.copyProperties(orderService.addOrder(order), order1);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return order1;
    }

    @GetMapping("/all-orders")
    public List<Order> getAllOrders() {
        return orderService.getAllOrder();
    }

}
