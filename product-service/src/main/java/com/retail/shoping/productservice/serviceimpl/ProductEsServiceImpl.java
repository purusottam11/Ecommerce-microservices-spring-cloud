package com.retail.shoping.productservice.serviceimpl;

import com.retail.shoping.productservice.model.Product;
import com.retail.shoping.productservice.model.ProductEs;
import com.retail.shoping.productservice.repository.ProductEsRepository;
import com.retail.shoping.productservice.repository.ProductRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class ProductEsServiceImpl {

    @Autowired
    private ProductEsRepository productEsRepository;

    @Autowired
    ProductRepository productRepository;

    List<ProductEs> list = new ArrayList<>();

    public List<ProductEs> importDataIntoProductEs() {
        for (Product product : productRepository.findAll()) {
            ProductEs productEs = new ProductEs();
            BeanUtils.copyProperties(product, productEs);
            productEsRepository.save(productEs);
            list.add(productEs);
        }
        return list;
    }

    public List<ProductEs> getAllEsRecord() {
        List<ProductEs> list = (List<ProductEs>) productEsRepository.findAll();
        return list;
    }

}
