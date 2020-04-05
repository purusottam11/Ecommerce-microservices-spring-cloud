package com.retail.shoping.orderservice.exception;

public enum ErrorCode {

    PRODUCT_NOT_FOUND("Product not found", 404),
    PRODUCT_ALREADY_EXIST("Product is exist", 402),
    ODDER_NOTfOUND("Order not found", 404),
    ORDER_IS_EXIST("Order is exist", 402);

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
