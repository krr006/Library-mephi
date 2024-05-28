package com.mephi.library.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
@Entity

@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String username;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    @Column(name = "surname")
    private String surName;
    @Column(name = "group_number")
    private String groupNumber;
    @Column(name = "phone_number")
    private String phoneNumber;
    @OneToOne(mappedBy = "user")
    private BorrowedBook borrowedBook;

}
