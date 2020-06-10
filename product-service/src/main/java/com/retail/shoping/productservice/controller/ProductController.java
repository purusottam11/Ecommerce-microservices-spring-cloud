package com.retail.shoping.productservice.controller;

import com.retail.shoping.productservice.exception.BusinessException;
import com.retail.shoping.productservice.model.Product;
import com.retail.shoping.productservice.service.ProductService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/products")
public class ProductController {

    Logger log = LoggerFactory.getLogger(ProductController.class);

    @Autowired
    private ProductService productService;

    @GetMapping("/listProducts")
    public List<Product> getAllProduct() {
        List<Product> products = productService.getAllProduct();
        log.debug("Response {}", products);
        return products;
    }

    @PostMapping("/addProduct")
    public Product addProduct(@RequestBody Product product) {
        log.info("Request {}", product);
        Product product1 = new Product();
        try {
            product1 = productService.addProduct(product);
        } catch (Exception e) {
            throw new BusinessException(e.getMessage());
        }
        log.info("Response {}", product1);
        return product1;
    }

    @PostMapping("/isProductExist")
    public boolean isProductExist(@RequestBody String productName) {
        return productService.isProductExist(productName);
    }

    @PostMapping("/isProductOutOfStuck")
    public boolean isProductOutOfStuck(@RequestBody String productPid) {
        return productService.isProductOutOfStuck(productPid);
    }
}
