package com.example.library.service;

import com.example.library.entity.Book;
import com.example.library.entity.BorrowedBook;
import com.example.library.entity.Status;
import com.example.library.repository.BookRepository;
import com.example.library.repository.BorrowedBookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor

public class BookService {

    private final BookRepository bookRepository;
    private final BorrowedBookRepository borrowedBookRepository;

    public void addNewBook(Book book){
        bookRepository.save(book);
    }

    public Optional<Book> findByTitle(String title){
        return bookRepository.findByTitle(title);
    }

    public void updateBookById(Long id, Book updatedBook){
        bookRepository.findById(id).map(currentBook -> {
            currentBook.setTitle(updatedBook.getTitle());
            currentBook.setPublisher(updatedBook.getPublisher());
            currentBook.setAuthor(updatedBook.getAuthor());
            currentBook.setGenre(updatedBook.getGenre());
            currentBook.setLocation(updatedBook.getLocation());
            return bookRepository.save(currentBook);
        });

    }

    public void borrowBook(String title, String username){
        Optional<Book> optionalBook = bookRepository.findByTitle(title);
        if (optionalBook.isPresent()){
            Book book = optionalBook.get();

            BorrowedBook borrowedBook = new BorrowedBook();
            borrowedBook.setTitle(book.getTitle());
            borrowedBook.setAuthor(book.getAuthor());
            borrowedBook.setGenre(book.getGenre());
            borrowedBook.setYear(borrowedBook.getYear());
            borrowedBook.setUser(null);
            borrowedBookRepository.save(borrowedBook);
            book.setStatus(Status.Borrowed);

        }
    }


    public void deleteBookByTitle(String title){bookRepository.deleteByTitle(title);}


}
