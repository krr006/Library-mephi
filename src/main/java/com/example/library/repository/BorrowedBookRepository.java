package com.example.library.repository;

import com.example.library.entity.BorrowedBook;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BorrowedBookRepository extends JpaRepository<BorrowedBook, Long> {
    void deleteByTitle(String title);
    Optional<BorrowedBook> findByTitle(String title);
}
