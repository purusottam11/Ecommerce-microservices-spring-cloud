package com.retail.shoping.productservice.controller;

import com.retail.shoping.productservice.model.ProductElasticSearch;
import com.retail.shoping.productservice.serviceimpl.SearchServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/elastic-search")
public class SearchController {

    Logger log = LoggerFactory.getLogger(SearchController.class);

    @Autowired
    private SearchServiceImpl queryDSLService;


    @GetMapping("/search/{text}")
    public List<ProductElasticSearch> doMultimatchQuery(@PathVariable String text) {
        log.info("Request {}", text);
        List<ProductElasticSearch> productEs = queryDSLService.searchByProductNameAndBrand(text);
        log.info("Response {}", productEs);
        return productEs;
    }


    @GetMapping("/search-by-price/{start}/{end}")
    public List<ProductElasticSearch> getProductSearchByPrice(@PathVariable int start, @PathVariable int end) {
        log.info("Request {}{}", start, end);
        List<ProductElasticSearch> productEs = queryDSLService.searchByPriceRange(start, end);
        log.info("Responce {}", productEs);
        return productEs;
    }

    @GetMapping("/demoSearch/{text}")
    public List<ProductElasticSearch> demoSearch(@PathVariable String text) {
        return queryDSLService.demoSearch(text);
    }

    @GetMapping("/boolQuerySearch/{text}/{price}")
    public List<ProductElasticSearch> boolQuerySearchFilter(@PathVariable String text, @PathVariable Integer price) {
        return queryDSLService.boolQueryDemoSearch(text, price);
    }

    @GetMapping("/all-filters/{text}/{startPrice}/{endPrice}")
    public List<ProductElasticSearch> addAllFilters(@PathVariable String text, @PathVariable int startPrice, @PathVariable int endPrice) {
        return queryDSLService.allFilter(text, startPrice, endPrice);
    }
}
