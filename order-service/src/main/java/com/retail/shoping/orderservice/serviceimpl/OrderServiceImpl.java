package com.retail.shoping.orderservice.serviceimpl;

import com.retail.shoping.orderservice.exception.BusinessException;
import com.retail.shoping.orderservice.exception.ErrorCode;
import com.retail.shoping.orderservice.model.Order;
import com.retail.shoping.orderservice.repository.OrderRepository;
import com.retail.shoping.orderservice.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private RestTemplate template;

    @Override
    public Order addOrder(Order order) {
        boolean result = checkProductOutOfStuck(order.getProductId());
        if (result) {
            throw new BusinessException(ErrorCode.PRODUCT_NOT_FOUND.getMessage());
        }
        Order order1 = orderRepository.save(order);
        return order1;
    }

    @Override
    public List<Order> getAllOrder() {
        return orderRepository.findAll();
    }

    @Override
    public boolean checkProductOutOfStuck(String productId) {
        String url = "http://localhost:8080/product/is-product-out-of-stuck";
        boolean result = template.postForObject(url, productId, Boolean.class);
        return result;
    }
}
