package com.mephi.library.repository;

import com.mephi.library.entity.BorrowedBook;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


@Repository
public interface BorrowedBookRepository extends JpaRepository<BorrowedBook, Long> {
    @Transactional
    @Modifying
    @Query("DELETE FROM BorrowedBook b WHERE b.book.id = :bookId")
    void deleteByBookId(@Param("bookId") Long id);

//        void deleteByTitle(String title);
//    Optional<BorrowedBook> findByTitle(String title);
}