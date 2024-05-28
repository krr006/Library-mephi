package com.example.library.repository;

import com.example.library.entity.BorrowedBook;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface BorrowedBookRepository extends JpaRepository<BorrowedBook, Long> {
    void deleteByTitle(String title);
    Optional<BorrowedBook> findByTitle(String title);
}
