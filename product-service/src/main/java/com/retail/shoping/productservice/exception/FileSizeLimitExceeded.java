package com.retail.shoping.productservice.exception;

public class FileSizeLimitExceeded extends RuntimeException {
    String message;

    public FileSizeLimitExceeded(String message) {
        super(message);
    }
}