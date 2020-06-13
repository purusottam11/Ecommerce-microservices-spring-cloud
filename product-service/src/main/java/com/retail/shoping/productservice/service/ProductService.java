package com.retail.shoping.productservice.service;

import com.retail.shoping.productservice.bean.ProductBean;
import com.retail.shoping.productservice.model.Product;

import java.util.List;

public interface ProductService {

    ProductBean addProduct(ProductBean productBean);

    Product upDateProduct(Product product);

    Product getProduct(Long productId);

    List<Product> getAllProduct();

}
