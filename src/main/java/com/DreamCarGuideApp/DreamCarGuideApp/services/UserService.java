package com.DreamCarGuideApp.DreamCarGuideApp.services;

import com.DreamCarGuideApp.DreamCarGuideApp.models.User;
import com.DreamCarGuideApp.DreamCarGuideApp.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public void saveUser(User user) {

        userRepository.save(user);
    }

    public Iterable<User> getAllUsers() {

        return userRepository.findAll();
    }
}
