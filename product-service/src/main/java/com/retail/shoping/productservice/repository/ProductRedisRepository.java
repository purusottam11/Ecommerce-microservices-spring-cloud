package com.retail.shoping.productservice.repository;

import com.retail.shoping.productservice.model.Product;

import java.util.Map;

public interface ProductRedisRepository {

    void addProductToRedis(Product product);

    void updateProductToRedis(Product product);

    void delateProductToRedis(Product product);

    Map<String, Product> getAllProductFromRedis();

}
