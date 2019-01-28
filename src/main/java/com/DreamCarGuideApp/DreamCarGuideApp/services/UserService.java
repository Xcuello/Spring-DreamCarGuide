package com.DreamCarGuideApp.DreamCarGuideApp.services;

import com.DreamCarGuideApp.DreamCarGuideApp.models.User;
import com.DreamCarGuideApp.DreamCarGuideApp.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;


    public User save(User user) {

        return userRepository.save(user);
    }

    public Optional<User> findById(Integer id) {

        return userRepository.findById(id);
    }

    public Iterable<User> findAll() {

        return userRepository.findAll();
    }

    public void delete(User user) {

        userRepository.delete(user);
    }
}
