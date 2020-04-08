package com.retail.shoping.orderservice.repository;

import com.retail.shoping.orderservice.model.Order;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface OrderElasticSearchRpository extends ElasticsearchRepository<Order, Long> {
}
