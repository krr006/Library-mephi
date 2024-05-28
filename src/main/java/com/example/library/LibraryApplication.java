package com.example.library;

import com.example.library.entity.Book;
import com.example.library.service.BookService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Locale;
import java.util.Optional;

@SpringBootApplication
public class LibraryApplication {

	public static void main(String[] args) {
		var app = SpringApplication.run(LibraryApplication.class, args);
		var bookSer = app.getBean(BookService.class);
		Book book = Book.builder()
				.title("Just a book")
				.year(1999)
				.genre("РОМАН")
				.annotation("Я не знаю что тут писать")
				.author("Vasya")
				.publisher("Mephi")
				.location("2, 3")
				.build();

		bookSer.addNewBook(book);

//		Book bean1 = bookSer.findBookById(900L).orElse(null);
//		System.out.println(bean1);


	}
}