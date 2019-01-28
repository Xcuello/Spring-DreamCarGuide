package com.DreamCarGuideApp.DreamCarGuideApp.controllers;

import com.DreamCarGuideApp.DreamCarGuideApp.models.User;
import com.DreamCarGuideApp.DreamCarGuideApp.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class UserController {

    @Autowired
    UserService userService;

   @PostMapping("/user")
    public ResponseEntity<User> createUser(@RequestBody User user) {

        return new ResponseEntity<>(userService.save(user), HttpStatus.CREATED);
    }

    @GetMapping("/user/{id}")
    public ResponseEntity<User> getUser(@PathVariable Integer id) {

        Optional<User> user = userService.findById(id);

        if (!user.isPresent()) {

            return new ResponseEntity<>(user.get(), HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(user.get(), HttpStatus.OK);
    }

    @GetMapping("/user")
    public ResponseEntity<Iterable<User>> getUserList() {

        return new ResponseEntity<>(userService.findAll(), HttpStatus.OK);
    }

    @PutMapping("/user/{id}")
    public ResponseEntity<User> updateUser(@PathVariable Integer id, @RequestBody User updatedUser) {

        Optional<User> user = userService.findById(id);

        if (!user.isPresent()) {

            return new ResponseEntity<>(updatedUser, HttpStatus.OK);
        }

        updatedUser.setId(id);

       userService.save(updatedUser);

        return new ResponseEntity<>(updatedUser, HttpStatus.CREATED);
    }

   @DeleteMapping("/user/{id}")
    public ResponseEntity<?> deleteUser(@RequestBody User user) {

        userService.delete(user);

        return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
    }
}
