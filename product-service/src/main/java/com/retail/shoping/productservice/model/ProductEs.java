package com.retail.shoping.productservice.model;


import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

@Document(indexName = "productes", type = "product")
public class ProductEs {

    @Id
    private String uniqId;
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

    public ProductEs() {
    }

    public ProductEs(String uniqId, String crawlTimestamp, String productUrl, String productName, Long category, String pid, Integer retailPrice, Integer discountedPrice, String image, String isFKAdvantageProduct, String description, String productRating, String overallRating, String brand) {
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
        return "ProductEs{" +
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
