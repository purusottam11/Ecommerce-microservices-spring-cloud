package com.retail.shoping.orderservice.serviceimpl;

import com.retail.shoping.orderservice.model.OrderEs;
import com.retail.shoping.orderservice.service.ElasticSearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Service;

@Service
public class ElasticSearchServiceImpl implements ElasticSearchService {

    @Autowired
    ElasticsearchRepository elasticsearchRepository;

    @Override
    public void addOrderEs(OrderEs orderEs) {
        elasticsearchRepository.save(orderEs);
    }
}
