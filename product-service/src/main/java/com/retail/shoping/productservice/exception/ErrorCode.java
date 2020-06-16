package com.retail.shoping.productservice.exception;

public enum ErrorCode {

    PRODUCT_NOT_FOUND("Product not found", 404),
    PRODUCT_ALREADY_EXIST("Product is exist", 402),
    CATEGORY_NOT_FOUND("Category not found", 404),
    CATEGORY_ALREADY_EXIST("Category is already exist", 402),
    USER_NOT_FOUND("User not found ", 404),
    USER_ALREADY_EXIST("User already exist", 400),
    USER_ID_ALREADY_EXIST("userId is already exist chose a different one ", 400),
    USER_NAME_ALREADY_EXIST("userName is already exist chose a different one ", 400);


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
