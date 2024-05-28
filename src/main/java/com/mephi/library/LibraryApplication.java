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
////		var bean1 =
//		var BookSer = app.getBean(BookService.class);
//		BookSer.addNewBook(
//				Book.builder()
//						.location("1, 1")
//						.publisher("xpxp")
//						.annotation("xpxp")
//						.year(1999)
//						.genre("SSSS")
//						.author("Xrt")
//						.title("Tiitle")
//						.build()
//		);

//		System.out.println(book.getStatus());
		var bookSer = app.getBean(BookService.class);
		Book book =  bookSer.findByTitle("Tiitle").get();
		System.out.println(book.getStatus());

	}
}