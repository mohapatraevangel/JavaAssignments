package com.bookapp.controller;

import com.bookapp.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
    public class UserController {

        private UserService userService;

        @Autowired
        private UserController(UserService userService){
            this.userService=userService;

        }

        @GetMapping("/users")
        public ResponseEntity<List<User>> getAllUser()
        {
            return ResponseEntity.status(HttpStatus.OK).body(userService.getAll());
        }

        @GetMapping("/users/{id}")
        public ResponseEntity<User> getUserById(@PathVariable String id) {
            return ResponseEntity.status(HttpStatus.OK).body(userService.getById(id));
        }
    }
