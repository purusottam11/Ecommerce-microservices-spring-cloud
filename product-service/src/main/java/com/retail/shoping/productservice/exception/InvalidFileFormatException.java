package com.retail.shoping.productservice.exception;

public class InvalidFileFormatException extends RuntimeException {
    String message;

    public InvalidFileFormatException(String message) {
        this.message = message;
    }
}
