package com.mephi.library.repository;

import com.mephi.library.service.exception.BookNotFoundException;
import org.springframework.data.jpa.repository.JpaRepository;
import com.mephi.library.entity.Book;

import java.util.Optional;

public interface BookRepository extends JpaRepository<Book, Long> {

    void deleteByTitle(String title);

    Optional<Book> findByTitle(String title);


}


