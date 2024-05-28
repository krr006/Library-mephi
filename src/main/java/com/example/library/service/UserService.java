package com.example.library.service;

import com.example.library.entity.User;
import com.example.library.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public Optional<User> findByUserName(String username){
        return userRepository.findByUsername(username);
    }

    public void deleteByUserName(String username){
        userRepository.deleteByUsername(username);
    }
}
