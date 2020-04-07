package com.retail.shoping.productservice.serviceimpl;

import com.retail.shoping.productservice.model.ProductEs;
import com.retail.shoping.productservice.repository.ProductEsRepository;
import org.elasticsearch.index.query.MultiMatchQueryBuilder;
import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.elasticsearch.core.query.NativeSearchQuery;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.data.elasticsearch.core.query.SearchQuery;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class QueryDSLService {

    @Autowired
    private ProductEsRepository productEsRepository;


    public List<ProductEs> multiMatchQuery(String text) {
        SearchQuery searchQuery = new NativeSearchQueryBuilder().withQuery(QueryBuilders.multiMatchQuery(text)
                .field("productName").field("brand").type(MultiMatchQueryBuilder.Type.BEST_FIELDS)).build();
        //List<ProductEs> productes = template.queryForList(searchQuery, ProductEs.class);
        List<ProductEs> productes = new ArrayList<>();
        productEsRepository.search(searchQuery).forEach(productes::add);
        return productes;
    }

    public List<ProductEs> searchByPriceField(int startPrice, int endPrice) {
        QueryBuilder searchQuery = QueryBuilders.rangeQuery("retailPrice").from(startPrice).to(endPrice);
        NativeSearchQuery nativeSearchQuery = new NativeSearchQueryBuilder().withQuery(searchQuery).build();
        //List<ProductEs> productEs = template.queryForList(nativeSearchQuery, ProductEs.class);
        List<ProductEs> productEs = new ArrayList<>();
        productEsRepository.search(searchQuery).forEach(productEs::add);
        return productEs;

    }

}
