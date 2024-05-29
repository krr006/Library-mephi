package com.mephi.library.service.exception;

import lombok.RequiredArgsConstructor;

public class BookNotFoundException extends RuntimeException{

    public BookNotFoundException(){
        super("Book not found");
    }
}
