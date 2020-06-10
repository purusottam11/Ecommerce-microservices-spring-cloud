package com.retail.shoping.productservice.serviceimpl;

import com.retail.shoping.productservice.model.ProductEs;
import com.retail.shoping.productservice.repository.ProductEsRepository;
import com.retail.shoping.productservice.service.QueryDSLService;
import org.elasticsearch.index.query.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.data.elasticsearch.core.query.SearchQuery;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.From;
import javax.persistence.criteria.Predicate;
import java.util.ArrayList;
import java.util.List;

@Service
public class QueryDSLServiceImpl implements QueryDSLService {

    @Autowired
    private ProductEsRepository productEsRepository;

    @Override
    public List<ProductEs> searchByProductNameAndBrand(String text) {
        QueryBuilder searchByTextProduct = QueryBuilders.matchPhrasePrefixQuery("productName", text);
        QueryBuilder searchByTextBrand = QueryBuilders.matchPhrasePrefixQuery("brand", text);
        QueryBuilder queryBuilder = QueryBuilders.matchPhrasePrefixQuery("description", text);
        List<ProductEs> productElasticsearchList = new ArrayList<>();
        productEsRepository.search(searchByTextProduct).forEach(productElasticsearchList::add);
        productEsRepository.search(searchByTextBrand).forEach(productElasticsearchList::add);
        productEsRepository.search(queryBuilder).forEach(productElasticsearchList::add);

        return productElasticsearchList;
    }

    @Override
    public List<ProductEs> searchByPriceRange(int startPrice, int endPrice) {
        BoolQueryBuilder queryBuilder = QueryBuilders.boolQuery()
                .must(QueryBuilders.rangeQuery("retailPrice")
                        .gte(startPrice)
                        .lte(endPrice));

        List<ProductEs> productElasticsearchList = new ArrayList<>();
        productEsRepository.search(queryBuilder).forEach(productElasticsearchList::add);
        // List<ProductEs> list= (List<ProductEs>) productEsRepository.search(queryBuilder);
        return productElasticsearchList;
    }

    @Override
    public List<ProductEs> demoSearch(String text) {
        //FIXME to search in multiiple colummn
        QueryBuilder queryBuilder = QueryBuilders.multiMatchQuery(text, "brand", "productName", "description");
        //FIXME to search in single column
        QueryBuilder queryBuilder1 = QueryBuilders.matchQuery("productName", text);

        QueryBuilder queryBuilder2 = QueryBuilders.boolQuery()
                .must(QueryBuilders.matchQuery("productName", text))
                .must(QueryBuilders.matchQuery("brand", text));

        QueryBuilder queryBuilder3 = QueryBuilders.matchQuery("productName", text);

        List<ProductEs> list = new ArrayList<>();
        productEsRepository.search(queryBuilder).forEach(i -> list.add(i));
        return list;
    }

    @Override
    public List<ProductEs> boolQueryDemoSearch(String text, Integer price) {
        QueryBuilder queryBuilder1 = QueryBuilders.boolQuery().must(QueryBuilders.matchQuery("productName", text)).filter(QueryBuilders.rangeQuery("retailPrice").gte(price)).filter(QueryBuilders.rangeQuery("retailPrice").lte(1000));
        List<ProductEs> list = new ArrayList<>();
        productEsRepository.search(queryBuilder1).forEach(list::add);
        return list;
    }

    public List<ProductEs> allFilter(String text, int startPrice, int endPrice) {
        QueryBuilder queryBuilder = QueryBuilders.boolQuery()
                .must(QueryBuilders.matchQuery("productName", text))
                .must(QueryBuilders.matchQuery("brand", text))
                .must(QueryBuilders.rangeQuery("retailPrice").gte(startPrice).lte(endPrice));

        List<ProductEs> productEsList = new ArrayList<>();
        productEsRepository.search(queryBuilder).forEach(productEsList::add);
        return productEsList;
    }


}
