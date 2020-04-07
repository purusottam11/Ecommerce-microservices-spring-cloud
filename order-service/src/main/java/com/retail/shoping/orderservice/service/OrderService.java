package com.retail.shoping.orderservice.service;

import com.retail.shoping.orderservice.model.Order;

import java.util.List;

public interface OrderService {

    public Order addOrder(Order order);

    public List<Order> getAllOrder();

    boolean checkProductOutOfStuck(String productId);
}
