package com.retail.shoping.productservice.service;

import com.retail.shoping.productservice.model.ProductElasticSearch;

import java.util.List;

public interface ElasticSearchService {
    ProductElasticSearch addProductEs(ProductElasticSearch productEs);

    List<ProductElasticSearch> getAllProductEs();

}
