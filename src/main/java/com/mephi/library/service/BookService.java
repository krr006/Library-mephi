package com.mephi.library.service;

import com.mephi.library.entity.Book;
import com.mephi.library.entity.BorrowedBook;
import com.mephi.library.entity.Status;
import com.mephi.library.entity.User;
import com.mephi.library.service.exception.BookNotFoundException;
import com.mephi.library.service.exception.UserNotFoundException;
import com.mephi.library.repository.BookRepository;
import com.mephi.library.repository.BorrowedBookRepository;
import com.mephi.library.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.hibernate.dialect.function.LpadRpadPadEmulation;
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

    public Book findByTitle(String title){
        return bookRepository.findByTitle(title).orElseThrow(BookNotFoundException::new);
    }


    public Book findById(Long id){
        return bookRepository.findById(id).orElseThrow(BookNotFoundException::new);
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



    public void borrowBook(Long id, String username) {
        Book book = findById(id);

        User user = userRepository.findByUsername(username).orElseThrow(UserNotFoundException::new);

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


    public void returnBook(Long id){
        Book book = findById(id);
        book.setStatus(Status.AVAILABLE);
        borrowedBookRepository.deleteByBookId(id);
        borrowedBookRepository.flush();
        bookRepository.save(book);
    }

    public void deleteBookById(Long id){bookRepository.deleteById(id);}


}
