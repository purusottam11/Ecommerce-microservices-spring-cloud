package com.retail.shoping.productservice.exception;

public class MinimumAllowedFileSize extends RuntimeException {

    String message;

    public MinimumAllowedFileSize(String message) {
        this.message = message;
    }
}
