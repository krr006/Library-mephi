package com.example.library.service;

import com.example.library.entity.Book;
import com.example.library.entity.BorrowedBook;
import com.example.library.entity.Status;
import com.example.library.entity.User;
import com.example.library.exception.BookNotFoundException;
import com.example.library.exception.UserNotFoundException;
import com.example.library.repository.BookRepository;
import com.example.library.repository.BorrowedBookRepository;
import com.example.library.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor

public class BookService {

    private final BookRepository bookRepository;
    private final BorrowedBookRepository borrowedBookRepository;
    private final UserRepository userRepository;

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



    public void borrowBook(String title, String username) {
        Book book = bookRepository.findByTitle(title)
                .orElseThrow(() -> new BookNotFoundException("The book " + title + " not found"));


        User user = userRepository.findByUsername(username)
                .orElseThrow(() -> new UserNotFoundException("The user " + username + " not found"));

        BorrowedBook borrowedBook = new BorrowedBook();
        borrowedBook.setTitle(book.getTitle());
        borrowedBook.setAuthor(book.getAuthor());
        borrowedBook.setGenre(book.getGenre());
        borrowedBook.setYear(book.getYear());
        borrowedBook.setUser(user);
        borrowedBook.setBook(book);
        borrowedBookRepository.save(borrowedBook);

        book.setStatus(Status.BORROWED);
        bookRepository.save(book);

    }
    public void deleteBookByTitle(String title){bookRepository.deleteByTitle(title);}


}
