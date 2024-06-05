package com.mephi.library.controller;

import com.mephi.library.entity.Book;
import com.mephi.library.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class BookController {
    private final BookService bookService;

    @GetMapping("/books")
    public List<Book> findAllBooks(){
        return bookService.findAllBooks();
    }

    @GetMapping("books/{id}")
    public ResponseEntity<Book> getBookById(@PathVariable("id") long id){
        var book = bookService.findById(id);

        return book != null ?
                ResponseEntity.ok(book) :
                new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

}
