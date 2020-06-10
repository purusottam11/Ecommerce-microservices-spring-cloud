package com.retail.shoping.productservice.controller;

import com.retail.shoping.productservice.model.ProductEs;
import com.retail.shoping.productservice.serviceimpl.QueryDSLServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.ParametersAreNonnullByDefault;
import java.util.List;

@RestController
@RequestMapping("/api/v1/elastic-search")
public class QueryDSLController {

    Logger log = LoggerFactory.getLogger(QueryDSLController.class);

    @Autowired
    private QueryDSLServiceImpl queryDSLService;


    @GetMapping("/search/{text}")
    public List<ProductEs> doMultimatchQuery(@PathVariable String text) {
        log.info("Request {}", text);
        List<ProductEs> productEs = queryDSLService.searchByProductNameAndBrand(text);
        log.info("Response {}", productEs);
        return productEs;
    }


    @GetMapping("/search-by-price/{start}/{end}")
    public List<ProductEs> getProductSearchByPrice(@PathVariable int start, @PathVariable int end) {
        log.info("Request {}{}", start, end);
        List<ProductEs> productEs = queryDSLService.searchByPriceRange(start, end);
        log.info("Responce {}", productEs);
        return productEs;
    }

    @GetMapping("/demoSearch/{text}")
    public List<ProductEs> demoSearch(@PathVariable String text) {
        return queryDSLService.demoSearch(text);
    }

    @GetMapping("/boolQuerySearch/{text}/{price}")
    public List<ProductEs> boolQuerySearchFilter(@PathVariable String text, @PathVariable Integer price) {
        return queryDSLService.boolQueryDemoSearch(text, price);
    }

    @GetMapping("/all-filters/{text}/{startPrice}/{endPrice}")
    public List<ProductEs> addAllFilters(@PathVariable String text, @PathVariable int startPrice, @PathVariable int endPrice) {
        return queryDSLService.allFilter(text, startPrice, endPrice);
    }
}
