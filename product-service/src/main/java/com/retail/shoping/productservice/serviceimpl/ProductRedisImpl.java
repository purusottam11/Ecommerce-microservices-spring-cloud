package com.retail.shoping.productservice.serviceimpl;

import com.retail.shoping.productservice.model.Product;
import com.retail.shoping.productservice.repository.ProductRedisRepository;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;

import java.util.Map;

//@Repository
public class ProductRedisImpl implements ProductRedisRepository {
    @Override
    public void addProductToRedis(Product product) {

    }

    @Override
    public void updateProductToRedis(Product product) {

    }

    @Override
    public void delateProductToRedis(Product product) {

    }

    @Override
    public Map<String, Product> getAllProductFromRedis() {
        return null;
    }

//
//    private RedisTemplate<String, Product> redisTemplate;
//
//    private HashOperations hashOperations;
//
//    public ProductRedisImpl(RedisTemplate<String, Product> redisTemplate) {
//        this.redisTemplate = redisTemplate;
//
//        hashOperations = redisTemplate.opsForHash();
//    }
//
//
//    @Override
//    public void addProductToRedis(Product product) {
//        hashOperations.put("PRODUCT", product.getUniqId(), product);
//    }
//
//    @Override
//    public void updateProductToRedis(Product product) {
//        addProductToRedis(product);
//    }
//
//    @Override
//    public void delateProductToRedis(Product product) {
//        hashOperations.delete("PRODUCT", product.getUniqId());
//    }
//
//    @Override
//    public Map<String, Product> getAllProductFromRedis() {
//        return hashOperations.entries("PRODUCT");
//    }
}
