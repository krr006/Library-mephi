package com.example.library.service;


import com.example.library.entity.BorrowedBook;
import com.example.library.repository.BorrowedBookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BorrowedBookService {
    private final BorrowedBookRepository borrowedBookRepository;

    public Optional<BorrowedBook> findByTitle(String title){
        return borrowedBookRepository.findByTitle(title);
    }

}
