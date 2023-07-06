package com.example.spring_begin_07_06.exception;

public class UserNotFoundException extends RuntimeException{
    public UserNotFoundException(String exception){
        super(exception);
    }
}
