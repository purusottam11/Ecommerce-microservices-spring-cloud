package com.retail.shoping.productservice.bean;


import lombok.*;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ProductBean {

    private String crawlTimestamp;

    private String productUrl;

    private String productName;

    private Long category;

    private String pid;

    private Integer retailPrice;

    private Integer discountedPrice;

    private String image;

    private String isFKAdvantageProduct;

    private String description;

    private String productRating;

    private String overallRating;

    private String brand;


}
