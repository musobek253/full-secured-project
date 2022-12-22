package com.xa.fullsecuredproject.exception.validator;

public class BadRequestException extends RuntimeException{
    public BadRequestException(String message) {
        super(message);
    }
}
