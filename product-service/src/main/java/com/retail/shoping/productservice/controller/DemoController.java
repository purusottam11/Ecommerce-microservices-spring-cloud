package com.retail.shoping.productservice.controller;

import com.retail.shoping.productservice.model.Demo;
import com.retail.shoping.productservice.model.Product;
import com.retail.shoping.productservice.service.DemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/demo")
public class DemoController {

    @Autowired
    private DemoService demoService;

    @GetMapping("/list-demo-dta")
    public List<Demo> listOfAllDemoData() {
        return demoService.getAllDemoData();
    }

    @GetMapping("/list-category")
    public List<String> listAllCategory() {
        return demoService.getAllCategoryTree();
    }

    @GetMapping("/bulk-import-into-product")
    public List<Product> getBulkImportProduct() {
        return demoService.addBulkDataIntoProduct();
    }

}
