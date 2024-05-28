package com.mephi.library.exception;

public class BookNotFoundException extends RuntimeException{
    public BookNotFoundException(String message){
        super(message);
    }
}
