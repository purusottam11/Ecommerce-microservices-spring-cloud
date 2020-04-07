package com.retail.shoping.orderservice.service;

import com.retail.shoping.orderservice.model.OrderTb;

import java.util.List;

public interface OrderService {

    public OrderTb addOrder(OrderTb order);

    public List<OrderTb> getAllOrder();

    boolean checkProductOutOfStuck(String productId);
}
