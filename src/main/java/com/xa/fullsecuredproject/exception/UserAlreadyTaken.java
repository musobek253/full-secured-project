package com.xa.fullsecuredproject.exception;

public class UserAlreadyTaken extends RuntimeException{

    public UserAlreadyTaken(String message) {
        super(message);
    }
}
