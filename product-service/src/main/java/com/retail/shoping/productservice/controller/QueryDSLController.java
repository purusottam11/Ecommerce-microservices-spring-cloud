package com.retail.shoping.productservice.controller;

import com.retail.shoping.productservice.model.ProductEs;
import com.retail.shoping.productservice.serviceimpl.QueryDSLService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/elastic-search")
public class QueryDSLController {

    Logger log = LoggerFactory.getLogger(QueryDSLController.class);

    @Autowired
    private QueryDSLService service;


    @GetMapping("/search/{text}")
    public List<ProductEs> doMultimatchQuery(@PathVariable String text) {
        log.debug("Request {}", text);
        List<ProductEs> productEs = service.multiMatchQuery(text);
        log.debug("Response {}", productEs);
        return productEs;
    }


    @GetMapping("/serch-by-prict/{start}/{end}")
    public List<ProductEs> getProductSearchByPrice(@PathVariable int start, @PathVariable int end) {
        log.debug("Request {}{}", start, end);
        List<ProductEs> productEs = service.searchByPriceField(start, end);
        log.debug("Responce {}", productEs);
        return productEs;
    }

}
