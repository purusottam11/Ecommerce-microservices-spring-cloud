package com.retail.shoping.orderservice.model;

import org.springframework.data.elasticsearch.annotations.Document;

@Document(indexName = "orderes", type = "order")
public class OrderEs {

    private Long id;

    private String productId;

    private String userId;

    public OrderEs() {
    }

    public OrderEs(Long id, String productId, String userId) {
        this.id = id;
        this.productId = productId;
        this.userId = userId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "OrderEs{" +
                "id=" + id +
                ", productId='" + productId + '\'' +
                ", userId='" + userId + '\'' +
                '}';
    }
}
