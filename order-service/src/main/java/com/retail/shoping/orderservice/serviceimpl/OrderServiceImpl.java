package com.retail.shoping.orderservice.serviceimpl;

import com.retail.shoping.orderservice.exception.BusinessException;
import com.retail.shoping.orderservice.exception.ErrorCode;
import com.retail.shoping.orderservice.model.Order;
import com.retail.shoping.orderservice.model.OrderEs;
import com.retail.shoping.orderservice.repository.OrderRepository;
import com.retail.shoping.orderservice.service.ElasticSearchService;
import com.retail.shoping.orderservice.service.OrderService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;
import java.util.List;

@Service
public class OrderServiceImpl extends JdbcDaoSupport implements OrderService {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    DataSource dataSource;

    @PostConstruct
    private void initialize() {
        setDataSource(dataSource);
    }

    @Autowired
    protected OrderRepository orderRepository;

    @Autowired
    private ElasticSearchService elasticSearchService;


    @Override
    @Transactional
    public Order addOrder(Order order) {
        if (orderRepository.existsById(order.getId())) {
            throw new BusinessException(ErrorCode.ORDER_IS_EXIST);
        }
        String sql = "INSERT INTO ordertb (id, product_id,user_id) VALUES (?, ?, ?)";
        getJdbcTemplate().update(sql, new Object[]{order.getId(), order.getProductId(), order.getUserId()});
        OrderEs orderEs = new OrderEs();
        BeanUtils.copyProperties(order, orderEs);
        elasticSearchService.addOrderEs(orderEs);
        return order;
    }

    @Override
    public List<Order> getAllOrder() {
        return orderRepository.findAll();
    }

    @Override
    public boolean checkProductOutOfStuck(String productId) {
        String url = "http://PRODUCT-SERVICE/api/v1/products/is-product-exist" + productId;
        return restTemplate.getForObject(url, Boolean.class);
    }
}
