package com.retail.shoping.productservice.model;


import lombok.*;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long uniqId;

    @Column(name = "crawl_timestamp")
    private String crawlTimestamp;

    @Column(name = "product_url")
    private String productUrl;

    @Column(name = "product_name")
    private String productName;

    @Column(name = "category")
    private Long category;

    @Column(name = "pid")
    private String pid;

    @Column(name = "retail_price")
    private Integer retailPrice;

    @Column(name = "discounted_price")
    private Integer discountedPrice;

    @Column(name = "image")
    private String image;

    @Column(name = "is_FK_Advantage_product")
    private String isFKAdvantageProduct;

    @Column(name = "description")
    private String description;

    @Column(name = "product_rating")
    private String productRating;

    @Column(name = "overall_rating")
    private String overallRating;

    @Column(name = "brand")
    private String brand;


}
