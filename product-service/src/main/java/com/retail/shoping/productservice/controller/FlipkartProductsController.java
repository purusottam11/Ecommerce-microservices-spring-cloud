package com.retail.shoping.productservice.controller;

import com.retail.shoping.productservice.model.FlipkartProducts;
import com.retail.shoping.productservice.model.Product;
import com.retail.shoping.productservice.service.FlipkartProductsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/flipkart-products")
public class FlipkartProductsController {

    @Autowired
    private FlipkartProductsService flipkartProductsService;

    @GetMapping("/list-raw-flipkart-products")
    public List<FlipkartProducts> listOfAllDemoData() {
        return flipkartProductsService.getAllFlipkartProducts();
    }

    @GetMapping("/import-bulk-data-to-category")
    public List<String> importDataToCategoryTable() {
        return flipkartProductsService.importDataToCategoryTable();
    }

    @GetMapping("/import-bulk-data-into-product")
    public List<Product> getDataIntoProductTable() {
        return flipkartProductsService.importDataIntoProductTable();
    }

}
