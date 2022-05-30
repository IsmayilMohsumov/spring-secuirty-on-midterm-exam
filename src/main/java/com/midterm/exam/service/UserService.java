package com.midterm.exam.service;

import com.midterm.exam.entity.File;
import com.midterm.exam.entity.User;
import com.midterm.exam.repository.FileRepository;
import com.midterm.exam.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final FileRepository fileRepository;

    private final PasswordEncoder passwordEncoder;

    public List<User> getAll() {
        return userRepository.findAll();
    }

    public void addUser(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepository.save(user);
    }

    public Optional<User> checkUser(String email, String password) throws Exception {
        User user =userRepository.getByEmailAndPassword(email, password);
        if(user!=null){
            return Optional.of(user);
        }
        return Optional.empty();
    }

    public boolean checkEmailIfExists(String email) {
        User user = userRepository.findByEmail(email);
        return user!=null;
    }

    public List<File> getAllFiles() {
        return fileRepository.findAll();
    }
}
