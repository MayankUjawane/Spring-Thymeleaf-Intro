package com.mayank.SpringThymeleafIntro.service;

import com.mayank.SpringThymeleafIntro.model.User;
import com.mayank.SpringThymeleafIntro.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public List<User> findAll() {
        return userRepository.findAll();
    }

    public Optional findById(Long id) {
        return userRepository.findById(id);
    }

    public void deleteById(Long id) {
        userRepository.deleteById(id);
    }

    public void save(User user) {
        userRepository.save(user);
    }

    public void update(User user, Long id) {
        userRepository.save(user);
    }

}
