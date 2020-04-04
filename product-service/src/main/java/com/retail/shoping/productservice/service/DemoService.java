package com.retail.shoping.productservice.service;

import com.retail.shoping.productservice.model.Demo;
import com.retail.shoping.productservice.model.Product;

import java.util.List;

public interface DemoService {

    List<String> getAllCategoryTree();

    List<Demo> getAllDemoData();

    List<Product> addBulkDataIntoProduct();

}
