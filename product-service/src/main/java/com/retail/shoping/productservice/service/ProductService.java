package com.retail.shoping.productservice.service;

import com.retail.shoping.productservice.model.Product;

import java.util.List;

public interface ProductService {

    Product addProduct(Product product);

    List<Product> getAllProduct();

    boolean isProductExist(String productName);

}