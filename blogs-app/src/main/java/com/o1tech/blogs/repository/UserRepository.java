package com.o1tech.blogs.repository;

import com.o1tech.blogs.model.User;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repository interface for performing CRUD operations on {@link User} entities.
 * Extends JpaRepository to leverage built-in CRUD operations
 */
@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUsername(String username);
}
