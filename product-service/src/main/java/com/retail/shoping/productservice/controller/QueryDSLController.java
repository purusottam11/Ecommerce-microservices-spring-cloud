package com.retail.shoping.productservice.controller;

import com.retail.shoping.productservice.model.ProductEs;
import com.retail.shoping.productservice.serviceimpl.QueryDSLServiceImpl;
import org.omg.PortableServer.LIFESPAN_POLICY_ID;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/elastic-search")
public class QueryDSLController {

    Logger log = LoggerFactory.getLogger(QueryDSLController.class);

    @Autowired
    private QueryDSLServiceImpl service;


    @GetMapping("/search/{text}")
    public List<ProductEs> doMultimatchQuery(@PathVariable String text) {
        log.info("Request {}", text);
        List<ProductEs> productEs = service.searchByProductNameAndBrand(text);
        log.info("Response {}", productEs);
        return productEs;
    }


    @GetMapping("/search-by-price/{start}/{end}")
    public List<ProductEs> getProductSearchByPrice(@PathVariable int start, @PathVariable int end) {
        log.info("Request {}{}", start, end);
        List<ProductEs> productEs = service.searchByPriceRange(start, end);
        log.info("Responce {}", productEs);
        return productEs;
    }

}
