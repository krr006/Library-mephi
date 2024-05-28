package com.example.library.entity;

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
    @JoinColumn(name = "book_id")
    private Book book;
}
