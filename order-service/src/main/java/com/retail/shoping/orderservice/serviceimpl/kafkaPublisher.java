package com.retail.shoping.orderservice.serviceimpl;

import com.retail.shoping.orderservice.exception.BusinessException;
import com.retail.shoping.orderservice.exception.ErrorCode;
import com.retail.shoping.orderservice.model.Order;
import com.retail.shoping.orderservice.repository.OrderRepository;
import com.retail.shoping.orderservice.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class kafkaPublisher implements OrderService {

    @Autowired
    private KafkaTemplate<String, Object> kafkaTemplate;

    private String topic = "purusottam";

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private RestTemplate template;

    @PostMapping("/add-product-to-kafka")
    public Order addProductToKafkaTopic(@RequestBody Order order) {
        boolean result = checkProductOutOfStuck(order.getProductId());
        if (result) {
            throw new BusinessException(ErrorCode.PRODUCT_NOT_FOUND.getMessage());
        }
        kafkaTemplate.send(topic, order);
        return order;
    }

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
