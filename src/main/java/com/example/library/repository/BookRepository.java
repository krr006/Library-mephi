package com.example.library.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.library.entity.Book;

import java.util.Optional;

public interface BookRepository extends JpaRepository<Book, Long> {

    void deleteByTitle(String title);

    Optional<Book> findByTitle(String title);


}


