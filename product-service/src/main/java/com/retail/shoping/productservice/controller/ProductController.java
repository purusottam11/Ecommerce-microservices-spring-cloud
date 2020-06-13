package com.retail.shoping.productservice.controller;

import com.retail.shoping.productservice.bean.ProductBean;
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
    public ProductBean addProduct(@RequestBody ProductBean productBean) {
        log.info("Request {}", productBean);
        try {
            productBean = productService.addProduct(productBean);
        } catch (Exception e) {
            throw new BusinessException(e.getMessage());
        }
        log.info("Response {}", productBean);
        return productBean;
    }

    @PutMapping("/updateProduct")
    public Product updateProduct(@RequestBody Product product) {
        return productService.upDateProduct(product);
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
