package com.retail.shoping.productservice.serviceimpl;

import com.retail.shoping.productservice.exception.BusinessException;
import com.retail.shoping.productservice.exception.ErrorCode;
import com.retail.shoping.productservice.model.Product;
import com.retail.shoping.productservice.repository.ProductRepository;
import com.retail.shoping.productservice.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Override
    public Product addProduct(Product product) {
        if (productRepository.findByProductName(product.getProductName()) != null) {
            throw new BusinessException(ErrorCode.PRODUCT_ALREADY_EXIST.getMessage());
        }
        Product product1 = productRepository.save(product);
        return product1;
    }

    @Override
    public Product upDateProduct(Product product) {
        return null;
    }


    @Override
    public List<Product> getAllProduct() {
        return productRepository.findAll();
    }

    @Override
    public boolean isProductExist(@RequestBody String productName) {
        Product product = productRepository.findByProductName(productName);
        if (product == null) {
            return false;
        }
        return true;
    }

    @Override
    public boolean isProductOutOfStuck(String pid) {
        if (productRepository.findByPid(pid) == null) {
            return true;
        }
        return false;
    }



}
