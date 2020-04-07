package com.retail.shoping.productservice.repository;

import com.retail.shoping.productservice.model.ProductEs;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductEsRepository extends ElasticsearchRepository<ProductEs, String> {

}
