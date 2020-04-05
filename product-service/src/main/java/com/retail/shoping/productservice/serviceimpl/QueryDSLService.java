package com.retail.shoping.productservice.serviceimpl;

import com.retail.shoping.productservice.model.Product;
import com.retail.shoping.productservice.model.ProductEs;
import org.elasticsearch.index.query.MultiMatchQueryBuilder;
import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.data.elasticsearch.core.query.NativeSearchQuery;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.data.elasticsearch.core.query.SearchQuery;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QueryDSLService {
    @Autowired
    private ElasticsearchTemplate template;

    public List<ProductEs> getBrandNameSearchData(String input) {
        String search = ".*" + input + ".*";
        SearchQuery searchQuery = new NativeSearchQueryBuilder()
                .withFilter(QueryBuilders.regexpQuery("productName", search)).build();
        List<ProductEs> productes = template.queryForList(searchQuery, ProductEs.class);
        return productes;
    }

    public List<ProductEs> multiMatchQuery(String text) {
        SearchQuery searchQuery = new NativeSearchQueryBuilder().withQuery(QueryBuilders.multiMatchQuery(text)
                .field("productName").field("brand").type(MultiMatchQueryBuilder.Type.BEST_FIELDS)).build();
        List<ProductEs> productes = template.queryForList(searchQuery, ProductEs.class);
        return productes;
    }

    public List<ProductEs> searchByPriceField(int startPrice, int endPrice) {
        QueryBuilder query = QueryBuilders.rangeQuery("retailPrice").from(startPrice).to(endPrice);
        NativeSearchQuery nativeSearchQuery = new NativeSearchQueryBuilder().withQuery(query).build();
        List<ProductEs> customers = template.queryForList(nativeSearchQuery, ProductEs.class);
        return customers;

    }

}
