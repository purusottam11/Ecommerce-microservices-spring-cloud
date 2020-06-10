package com.retail.shoping.productservice.service;

import com.retail.shoping.productservice.model.ProductElasticSearch;

import java.util.List;

public interface SearchService {

    List<ProductElasticSearch> searchByProductNameAndBrand(String text);

    List<ProductElasticSearch> searchByPriceRange(int startPrice, int endPrice);

    List<ProductElasticSearch> demoSearch(String text);

    List<ProductElasticSearch> boolQueryDemoSearch(String text, Integer price);

}
