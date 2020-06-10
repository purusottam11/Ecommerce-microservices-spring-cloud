package com.retail.shoping.productservice.service;

import com.retail.shoping.productservice.model.ProductEs;

import java.util.List;

public interface ProductEsService {
    ProductEs addProductEs(ProductEs productEs);

    List<ProductEs> getAllProductEs();

}
