package com.mephi.library.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@RequiredArgsConstructor
@Entity

@Table(name = "books")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String publisher;
    private String author;
    private Integer year;
    private String annotation;
    private String genre;
    private String location;
    @Enumerated(EnumType.STRING)
    @Builder.Default
    private Status status = Status.AVAILABLE;
    @OneToOne(mappedBy = "book", cascade = CascadeType.ALL)
    private BorrowedBook borrowedBook;

}
