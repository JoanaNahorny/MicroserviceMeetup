package com.bootcamp.microservicesmeetup.exception;

public class BusinessException extends RuntimeException {

    public BusinessException(String s) {
        super(s);
    }
}
