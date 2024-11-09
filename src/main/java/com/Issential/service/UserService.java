package com.Issential.service;

import com.Issential.data.entity.User;
import com.Issential.data.repository.UserRepository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;

    public User registerUser(User user) {
        if (userRepository.existsByEmail(user.getEmail())) {
            throw new RuntimeException("Email already exists");
        }

        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepository.save(user);
    }

    public User loginUser(String email, String password) {
        User user = userRepository.findByEmail(email).orElseThrow(()-> new RuntimeException("Login credentials incorrect."));
        if (!passwordEncoder.matches(password, user.getPassword())) {
            throw new RuntimeException("Login credentials incorrect.");
        }
        return user;
    }
}
