package com.retail.shoping.productservice.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Product {

    @Id
    @Column(name = "uniq_id")
    private String uniqId;

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

    public Product() {
    }

    public Product(String uniqId, String crawlTimestamp, String productUrl, String productName, Long category, String pid, Integer retailPrice, Integer discountedPrice, String image, String isFKAdvantageProduct, String description, String productRating, String overallRating, String brand) {
        this.uniqId = uniqId;
        this.crawlTimestamp = crawlTimestamp;
        this.productUrl = productUrl;
        this.productName = productName;
        this.category = category;
        this.pid = pid;
        this.retailPrice = retailPrice;
        this.discountedPrice = discountedPrice;
        this.image = image;
        this.isFKAdvantageProduct = isFKAdvantageProduct;
        this.description = description;
        this.productRating = productRating;
        this.overallRating = overallRating;
        this.brand = brand;
    }

    public String getUniqId() {
        return uniqId;
    }

    public void setUniqId(String uniqId) {
        this.uniqId = uniqId;
    }

    public String getCrawlTimestamp() {
        return crawlTimestamp;
    }

    public void setCrawlTimestamp(String crawlTimestamp) {
        this.crawlTimestamp = crawlTimestamp;
    }

    public String getProductUrl() {
        return productUrl;
    }

    public void setProductUrl(String productUrl) {
        this.productUrl = productUrl;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Long getCategory() {
        return category;
    }

    public void setCategory(Long category) {
        this.category = category;
    }

    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid;
    }

    public Integer getRetailPrice() {
        return retailPrice;
    }

    public void setRetailPrice(Integer retailPrice) {
        this.retailPrice = retailPrice;
    }

    public Integer getDiscountedPrice() {
        return discountedPrice;
    }

    public void setDiscountedPrice(Integer discountedPrice) {
        this.discountedPrice = discountedPrice;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getIsFKAdvantageProduct() {
        return isFKAdvantageProduct;
    }

    public void setIsFKAdvantageProduct(String isFKAdvantageProduct) {
        this.isFKAdvantageProduct = isFKAdvantageProduct;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getProductRating() {
        return productRating;
    }

    public void setProductRating(String productRating) {
        this.productRating = productRating;
    }

    public String getOverallRating() {
        return overallRating;
    }

    public void setOverallRating(String overallRating) {
        this.overallRating = overallRating;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    @Override
    public String toString() {
        return "Product{" +
                "uniqId='" + uniqId + '\'' +
                ", crawlTimestamp='" + crawlTimestamp + '\'' +
                ", productUrl='" + productUrl + '\'' +
                ", productName='" + productName + '\'' +
                ", category=" + category +
                ", pid='" + pid + '\'' +
                ", retailPrice=" + retailPrice +
                ", discountedPrice=" + discountedPrice +
                ", image='" + image + '\'' +
                ", isFKAdvantageProduct='" + isFKAdvantageProduct + '\'' +
                ", description='" + description + '\'' +
                ", productRating='" + productRating + '\'' +
                ", overallRating='" + overallRating + '\'' +
                ", brand='" + brand + '\'' +
                '}';
    }
}
