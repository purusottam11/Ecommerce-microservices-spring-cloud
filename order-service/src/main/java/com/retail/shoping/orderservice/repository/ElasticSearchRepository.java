package com.retail.shoping.orderservice.repository;

import com.retail.shoping.orderservice.model.OrderEs;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ElasticSearchRepository extends ElasticsearchRepository<OrderEs, Long> {
}
