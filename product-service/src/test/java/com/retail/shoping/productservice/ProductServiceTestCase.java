package com.retail.shoping.productservice;

import com.retail.shoping.productservice.model.ProductEs;
import com.retail.shoping.productservice.repository.ProductEsRepository;
import com.retail.shoping.productservice.service.QueryDSLService;
import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

public class ProductServiceTestCase {


    @InjectMocks
    QueryDSLService queryDSLService;
    @Mock
    ProductEsRepository productEsRepository;

    @BeforeEach
    public void inti() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void getProductByName() {
        List<ProductEs> productEsList = new ArrayList<>();
        ProductEs productEs = new ProductEs();
        productEs.setBrand("Alisha");
        productEs.setDiscountedPrice(479);
        productEs.setImage("http://img6a.flixcart.com/image/short/p/j/z/altght4p-26-alisha-38-original-imaeh2d5cqtxe5gt.jpeg");
        productEs.setIsFKAdvantageProduct("false");
        productEs.setPid("SRTEH2FVVKRBAXHB");
        productEs.setProductName("Alisha Solid Women's Cycling Shorts");
        productEs.setProductUrl("http://www.flipkart.com/alisha-solid-women-s-cycling-shorts/p/itmeh2ftwkzykhcg?pid=SRTEH2FVVKRBAXHB");
        productEs.setRetailPrice(1199);
        productEs.setUniqId("ce5a6818f7707e2cb61fdcdbba61f5ad");
        productEsList.add(productEs);
        Mockito.when(queryDSLService.searchByProductNameAndBrand("Shorts")).thenReturn(productEsList);
        List<ProductEs> prodElastic = queryDSLService.searchByProductNameAndBrand("Shorts");
        Mockito.verify(queryDSLService.searchByProductNameAndBrand("Shorts"));
        MatcherAssert.assertThat(prodElastic.size(), Matchers.is(Matchers.greaterThanOrEqualTo(1)));
        MatcherAssert.assertThat(prodElastic.get(0).getProductName(), Matchers.containsStringIgnoringCase("Shorts"));
    }


    @Test
    void getProductByPriceRange() {
        List<ProductEs> productElasticList = new ArrayList<>();
        ProductEs productEs = new ProductEs();
        productEs.setBrand("Alisha");
        productEs.setDiscountedPrice(479);
        productEs.setImage("http://img6a.flixcart.com/image/short/p/j/z/altght4p-26-alisha-38-original-imaeh2d5cqtxe5gt.jpeg");
        productEs.setIsFKAdvantageProduct("false");
        productEs.setPid("SRTEH2FVVKRBAXHB");
        productEs.setProductName("Alisha Solid Women's Cycling Shorts");
        productEs.setProductUrl("http://www.flipkart.com/alisha-solid-women-s-cycling-shorts/p/itmeh2ftwkzykhcg?pid=SRTEH2FVVKRBAXHB");
        productEs.setRetailPrice(1199);
        productEs.setUniqId("ce5a6818f7707e2cb61fdcdbba61f5ad");
        productElasticList.add(productEs);
        QueryBuilder query = QueryBuilders.rangeQuery("retailPrice").from(1100.0).to(1200.0);
        Mockito.when(queryDSLService.searchByProductNameAndBrand("alisa")).thenReturn(productElasticList);
        List<ProductEs> prodElastic = queryDSLService.searchByPriceRange(1100, 1200);
         Mockito.verify(queryDSLService).searchByProductNameAndBrand("alisa");
        MatcherAssert.assertThat(prodElastic.size(), Matchers.is(Matchers.greaterThanOrEqualTo(1)));
        MatcherAssert.assertThat(prodElastic.get(0).getRetailPrice(), Matchers.is(Matchers.greaterThanOrEqualTo(1100)));
        MatcherAssert.assertThat(prodElastic.get(0).getRetailPrice(), Matchers.is(Matchers.lessThanOrEqualTo(1200)));
    }


}
