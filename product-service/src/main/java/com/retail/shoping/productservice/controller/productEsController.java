package com.retail.shoping.productservice.controller;

import com.retail.shoping.productservice.model.ProductEs;
import com.retail.shoping.productservice.serviceimpl.ProductEsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/product-es")
public class productEsController {

    @Autowired
    private ProductEsServiceImpl productEsService;

    @GetMapping("/product-es-data-import")
    public List<ProductEs> bulkImportToProductEs() {
        List<ProductEs> list = productEsService.importDataIntoProductEs();
        return list;
    }

    @GetMapping("/list-productes")
    public List<ProductEs> getAllProductEs() {
        List<ProductEs> list = productEsService.getAllEsRecord();
        return list;
    }


}
