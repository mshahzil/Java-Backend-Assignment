package com.o1tech.blogs.repository;

import com.o1tech.blogs.model.BlogPost;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repository interface for performing CRUD operations on {@link BlogPost} entities.
 * Extends JpaRepository to leverage built-in CRUD operations
 */
@Repository
public interface BlogPostRepository extends JpaRepository<BlogPost, Long> {
}