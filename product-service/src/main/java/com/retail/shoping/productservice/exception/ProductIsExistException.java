package com.retail.shoping.productservice.exception;

public class ProductIsExistException extends RuntimeException {
    public ProductIsExistException(String message) {
        super(ErrorCode.PRODUCT_ALREADY_EXIST.getMessage());
    }
}
