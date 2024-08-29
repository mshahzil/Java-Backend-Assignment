package com.o1tech.blogs.controller;

import com.o1tech.blogs.model.BlogPost;
import com.o1tech.blogs.service.BlogPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

/**
 * REST controller for handling HTTP requests related to blog posts.
 */
@RestController
@RequestMapping("/api/blogpost")
public class BlogPostController {

    @Autowired
    private BlogPostService blogPostService;

    /**
     * Creates a new blog post.
     * @param blogPost The blog post to create.
     * @return ResponseEntity with the created blog post and HTTP status 201 (Created).
     */
    @PostMapping("/create")
    public ResponseEntity<BlogPost> createBlogPost(@RequestBody BlogPost blogPost) {
        BlogPost createdBlogPost = blogPostService.createBlogPost(blogPost);
        return new ResponseEntity<>(createdBlogPost, HttpStatus.CREATED);
    }

    /**
     * Retrieves all blog posts.
     * @return ResponseEntity with a list of blog posts and HTTP status 200 (OK).
     */
    @GetMapping("/get")
    public ResponseEntity<List<BlogPost>> getAllBlogPosts() {
        List<BlogPost> blogPosts = blogPostService.getAllBlogPosts();
        return new ResponseEntity<>(blogPosts, HttpStatus.OK);
    }

    /**
     * Retrieves a blog post by its ID.
     * @param id The ID of the blog post to retrieve.
     * @return ResponseEntity with the blog post details and HTTP status 200 (OK) if found, or HTTP status 404 (Not Found) if not found.
     */
    @GetMapping("/get/{id}")
    public ResponseEntity<BlogPost> getBlogPostById(@PathVariable Long id) {
        Optional<BlogPost> blogPost = blogPostService.getBlogPostById(id);
        return blogPost.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    /**
     * Updates an existing blog post.
     * @param id The ID of the blog post to update.
     * @param blogPost The updated blog post details.
     * @return ResponseEntity with the updated blog post and HTTP status 200 (OK) if found and updated, or HTTP status 404 (Not Found) if not found.
     */
    @PutMapping("/update/{id}")
    public ResponseEntity<BlogPost> updateBlogPost(@PathVariable Long id, @RequestBody BlogPost blogPost) {
        BlogPost updatedBlogPost = blogPostService.updateBlogPost(id, blogPost);
        return updatedBlogPost != null ? ResponseEntity.ok(updatedBlogPost) : ResponseEntity.notFound().build();
    }

    /**
     * Deletes a blog post by ID.
     * @param id The ID of the blog post to delete.
     * @return ResponseEntity with HTTP status 204 (No Content) if successfully deleted, or HTTP status 404 (Not Found) if the blog post was not found.
     */
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteBlogPost(@PathVariable Long id) {
        return blogPostService.deleteBlogPost(id) ? ResponseEntity.noContent().build() : ResponseEntity.notFound().build();
    }
}
