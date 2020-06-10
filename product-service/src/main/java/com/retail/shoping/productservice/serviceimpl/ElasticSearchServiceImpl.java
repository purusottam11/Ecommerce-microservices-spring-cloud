package com.retail.shoping.productservice.serviceimpl;

import com.retail.shoping.productservice.model.Product;
import com.retail.shoping.productservice.model.ProductElasticSearch;
import com.retail.shoping.productservice.repository.ElasticSearchRepository;
import com.retail.shoping.productservice.repository.ProductRepository;
import com.retail.shoping.productservice.service.ElasticSearchService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class ElasticSearchServiceImpl implements ElasticSearchService {

    @Autowired
    private ElasticSearchRepository productEsRepository;

    @Autowired
    private ProductRepository productRepository;

    List<ProductElasticSearch> list = new ArrayList<>();

    public List<ProductElasticSearch> importDataIntoProductEs() {
        for (Product product : productRepository.findAll()) {
            ProductElasticSearch productEs = new ProductElasticSearch();
            BeanUtils.copyProperties(product, productEs);
            productEsRepository.save(productEs);
            list.add(productEs);
        }
        return list;
    }

    public List<ProductElasticSearch> getAllEsRecord() {
        List<ProductElasticSearch> list = (List<ProductElasticSearch>) productEsRepository.findAll();
        return list;
    }

    @Override
    public ProductElasticSearch addProductEs(ProductElasticSearch productEs) {
        return productEsRepository.save(productEs);
    }

    @Override
    public List<ProductElasticSearch> getAllProductEs() {
        List<ProductElasticSearch> list = new ArrayList<>();
        productEsRepository.findAll().forEach(list::add);
        return list;
    }
}
