package com.retail.shoping.productservice.service;

import com.retail.shoping.productservice.model.ProductElasticSearch;
import com.retail.shoping.productservice.model.RawProducts;
import com.retail.shoping.productservice.model.Product;

import java.util.List;

public interface DataImportService {

    List<String> importDataToCategoryTable();

    List<Product> importDataIntoProductTable();

    public List<ProductElasticSearch> importDataIntoProductEs();


}
