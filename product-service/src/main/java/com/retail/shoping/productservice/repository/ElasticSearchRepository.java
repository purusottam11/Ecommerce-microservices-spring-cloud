package com.retail.shoping.productservice.repository;

import com.retail.shoping.productservice.model.ProductElasticSearch;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ElasticSearchRepository extends ElasticsearchRepository<ProductElasticSearch, String> {

}
