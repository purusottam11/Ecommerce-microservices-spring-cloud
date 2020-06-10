package com.retail.shoping.productservice.controller;

import com.retail.shoping.productservice.model.ProductElasticSearch;

import com.retail.shoping.productservice.service.ElasticSearchService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product-es")
public class ElasticSearchController {

    Logger log = LoggerFactory.getLogger(ElasticSearchController.class);

    @Autowired
    ElasticSearchService productEsService;

    @GetMapping("/list-product-ES")
    public List<ProductElasticSearch> getAllProductEs() {
        return null;
    }

    @PostMapping("/add-productEs")
    public ProductElasticSearch addProductEs(@RequestBody ProductElasticSearch productEs) {
        return productEsService.addProductEs(productEs);
    }
}
