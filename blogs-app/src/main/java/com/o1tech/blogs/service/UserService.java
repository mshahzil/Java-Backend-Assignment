package com.o1tech.blogs.service;

import com.o1tech.blogs.exception.UserNotFoundException;
import com.o1tech.blogs.model.User;
import com.o1tech.blogs.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    /**
     * Creates a new user with the provided details if the username does not already exist.
     * Checks if the username already exists before saving the new user.
     * @param user The details of the user to be created.
     * @return The created user.
     * @throws RuntimeException If the username already exists.
     */
    public User createUser(User user) {
    	// Check if the username already exists
        if (userRepository.findByUsername(user.getUsername()).isPresent()) {
            throw new RuntimeException("Username already exists");
        }
    	
        return userRepository.save(user);
    }

    /**
     * Retrieves a user by their username.
     * @param username The username of the user to retrieve.
     * @return The user if found.
     * @throws UserNotFoundException If no user with the specified username is found.
     */
    public User findByUsername(String username) {
        return userRepository.findByUsername(username).orElseThrow(() -> new UserNotFoundException("User with username '" + username + "' not found"));
    }

}