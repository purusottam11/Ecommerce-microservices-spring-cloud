package com.retail.shoping.productservice.controller;

import com.retail.shoping.productservice.exception.BusinessException;
import com.retail.shoping.productservice.model.Product;
import com.retail.shoping.productservice.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("/list-products")
    public List<Product> getAllProduct() {
        return productService.getAllProduct();
    }

    @PostMapping("/add-product")
    public Product addProduct(@RequestBody Product product) {
        Product product1 = new Product();
        try {
            product1 = productService.addProduct(product);
        } catch (Exception e) {
            throw new BusinessException(e.getMessage());
        }
        return product1;
    }

    @PostMapping("/is-product-exist")
    public boolean isProductExist(@RequestBody String productName) {
        return productService.isProductExist(productName);
    }

}
