package com.mephi.library.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "borrowed_books")
public class BorrowedBook {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String author;
    private String genre;
    private Integer year;

    @OneToOne
    @JoinColumn(name = "user_name", referencedColumnName = "username")
    private User user;

    @OneToOne
    @JoinColumn(name = "book_id", referencedColumnName = "id", unique = true)
    private Book book;
}
