package com.retail.shoping.productservice.controller;

import com.retail.shoping.productservice.model.ProductEs;
import com.retail.shoping.productservice.serviceimpl.ProductEsServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/product-es")
public class ProductEsController {


    Logger log = LoggerFactory.getLogger(ProductEsController.class);

    @Autowired
    private ProductEsServiceImpl productEsService;

    @GetMapping("/import-products-to-ES")
    public List<ProductEs> bulkImportToProductEs() {
        List<ProductEs> list = productEsService.importDataIntoProductEs();
        log.debug("Responce {}", list);
        return list;
    }

    @GetMapping("/list-product-ES")
    public List<ProductEs> getAllProductEs() {
        List<ProductEs> list = productEsService.getAllEsRecord();
        log.debug("Responce {}", list);
        return list;
    }


}
