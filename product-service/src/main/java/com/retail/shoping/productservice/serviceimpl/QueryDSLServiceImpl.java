package com.retail.shoping.productservice.serviceimpl;

import com.retail.shoping.productservice.model.ProductEs;
import com.retail.shoping.productservice.repository.ProductEsRepository;
import com.retail.shoping.productservice.service.QueryDSLService;
import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.index.query.MatchPhrasePrefixQueryBuilder;
import org.elasticsearch.index.query.MultiMatchQueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.data.elasticsearch.core.query.SearchQuery;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class QueryDSLServiceImpl implements QueryDSLService {

    @Autowired
    private ProductEsRepository productEsRepository;

    @Override
    public List<ProductEs> searchByProductNameAndBrand(String text) {
        MatchPhrasePrefixQueryBuilder searchByTextProduct = QueryBuilders.matchPhrasePrefixQuery("productName", text);
        MatchPhrasePrefixQueryBuilder searchByTextBrand = QueryBuilders.matchPhrasePrefixQuery("brand", text);
        List<ProductEs> productElasticsearchList = new ArrayList<>();
        productEsRepository.search(searchByTextProduct).forEach(productElasticsearchList::add);
        productEsRepository.search(searchByTextBrand).forEach(productElasticsearchList::add);
        return productElasticsearchList;
    }

    @Override
    public List<ProductEs> searchByPriceRange(int startPrice, int endPrice) {
        BoolQueryBuilder queryBuilder = QueryBuilders.boolQuery();
        queryBuilder.must(QueryBuilders.rangeQuery("retailPrice").gte(startPrice).lte(endPrice));
        List<ProductEs> productElasticsearchList = new ArrayList<>();
        productEsRepository.search(queryBuilder).forEach(productElasticsearchList::add);
        return productElasticsearchList;
    }



}
