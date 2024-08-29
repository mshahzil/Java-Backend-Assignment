package com.o1tech.blogs.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;
import lombok.Data;
import jakarta.persistence.Column;
import java.time.LocalDateTime;

/**
 * Represents a blog post entity in the system.
 */
@Entity
@Data
@Table(name = "blog_post")
public class BlogPost {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false, length = 5000)
    private String content;

    /**
     * Each blog post is associated with a single user (author), but a user can have multiple blog posts.
     * The 'author_id' column in the blog_post table is the foreign key referencing the user table.
     */
    @ManyToOne
    @JoinColumn(name = "author_id", nullable = false)
    private User author;
    
    @Column(updatable = false)
    private LocalDateTime createdAt;
    
    private LocalDateTime updatedAt;
    
    /**
     * Sets creation and update timestamps before saving a new blog post.
     */
    @PrePersist
    protected void onCreate() {
        createdAt = LocalDateTime.now();
        updatedAt = LocalDateTime.now();
    }

    /**
     * Modifies the update timestamp before updating an existing blog post.
     */
    @PreUpdate
    protected void onUpdate() {
        updatedAt = LocalDateTime.now();
    }
    
}
