package com.mephi.library;
import com.mephi.library.entity.Book;
import com.mephi.library.service.BookService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Optional;

@SpringBootApplication
public class LibraryApplication {

	public static void main(String[] args) {
		var app = SpringApplication.run(LibraryApplication.class, args);
		var bookSer = app.getBean(BookService.class);
//		bookSer.borrowBook(1L, "johndoe");
		bookSer.returnBook(1L);


	}
}