package com.retail.shoping.productservice.service;

import com.retail.shoping.productservice.model.FlipkartProducts;
import com.retail.shoping.productservice.model.Product;

import java.util.List;

public interface FlipkartProductsService {

    List<String> importDataToCategoryTable();

    List<FlipkartProducts> getAllFlipkartProducts();

    List<Product> importDataIntoProductTable();

}
