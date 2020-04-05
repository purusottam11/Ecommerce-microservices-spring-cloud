package com.retail.shoping.productservice.exception;

public enum ErrorCode {

    PRODUCT_NOT_FOUND("Product not found", 404),
    PRODUCT_ALREADY_EXIST("Product is exist", 402);

    private String message;
    private int errorCode;

    private ErrorCode(String message) {
        this.message = message;
    }

    private ErrorCode(String message, int errorCode) {
        this.message = message;
        this.errorCode = errorCode;
    }

    public String getMessage() {
        return message;
    }

    public int getErrorCode() {
        return errorCode;
    }

}
