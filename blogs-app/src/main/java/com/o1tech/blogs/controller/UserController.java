package com.o1tech.blogs.controller;

import com.o1tech.blogs.model.User;
import com.o1tech.blogs.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    private UserService userService;
    
    /**
     * Creates a new user with the provided user details.
     * Checks if the username already exists.
     * @param user The details of the user to be created, including username and password.
     * @return A ResponseEntity containing the created user and HTTP status code 201 (Created) if successful,
     *         or HTTP status code 400 (Bad Request) if an error occurs, with a message indicating the error.
     */
    @PostMapping("/create")
    public ResponseEntity<?> createUser(@RequestBody User user) {
        try {
            User createdUser = userService.createUser(user);
            return ResponseEntity.status(HttpStatus.CREATED).body(createdUser);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error creating user: " + e.getMessage());
        }
    }
}
