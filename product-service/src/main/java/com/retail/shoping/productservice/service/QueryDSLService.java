package com.retail.shoping.productservice.service;

import com.retail.shoping.productservice.model.ProductEs;

import java.util.List;

public interface QueryDSLService {

    List<ProductEs> searchByProductNameAndBrand(String text);

    List<ProductEs> searchByPriceRange(int startPrice, int endPrice);

}
