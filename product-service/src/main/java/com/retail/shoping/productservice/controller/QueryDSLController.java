package com.retail.shoping.productservice.controller;

import com.retail.shoping.productservice.model.ProductEs;
import com.retail.shoping.productservice.serviceimpl.QueryDSLService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/elastic-search")
public class QueryDSLController {

    @Autowired
    private QueryDSLService service;


    @GetMapping("/product-search/{productName}")
    public List<ProductEs> getProductEsByField(@PathVariable String productName) {
        return service.getBrandNameSearchData(productName);
    }

    @GetMapping("/search/{text}")
    public List<ProductEs> doMultimatchQuery(@PathVariable String text) {
        return service.multiMatchQuery(text);
    }


    @GetMapping("/serch-by-prict/{start}/{end}")
    public List<ProductEs> getProductSearchByPrice(@PathVariable int start, @PathVariable int end) {
        return service.searchByPriceField(start, end);
    }

}
