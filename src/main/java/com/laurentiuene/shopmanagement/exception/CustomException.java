package com.laurentiuene.shopmanagement.exception;

public class CustomException extends RuntimeException{

    public CustomException(String message, Throwable throwable) {
        super(message, throwable);
    }
}
