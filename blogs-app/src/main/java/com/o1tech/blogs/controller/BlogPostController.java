package com.o1tech.blogs.controller;

import com.o1tech.blogs.exception.BlogPostNotFoundException;
import com.o1tech.blogs.exception.UnauthorizedAccessException;
import com.o1tech.blogs.exception.UserNotFoundException;
import com.o1tech.blogs.model.BlogPost;
import com.o1tech.blogs.service.BlogPostService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * REST controller for handling HTTP requests related to blog posts.
 */
@RestController
@RequestMapping("/api/blogpost")
public class BlogPostController {

    @Autowired
    private BlogPostService blogPostService;
    
    /**
     * Creates a new blog post and associates it with the specified username.
     * Checks if the user exists before creating the blog post.
     * @param blogPost The blog post to create.
     * @param username The username of the user creating the blog post.
     * @return ResponseEntity with the created blog post and HTTP status 201 (Created) if successful,
     *         or HTTP status 404 (Not Found) if the user is not found, or HTTP status 500 (Internal Server Error) if an error occurs.
     */
    @PostMapping("/create")
    public ResponseEntity<?> createBlogPost(@RequestBody BlogPost blogPost, @RequestParam String username) {
        try {
            BlogPost createdBlogPost = blogPostService.createBlogPost(blogPost, username);
            return ResponseEntity.status(HttpStatus.CREATED).body(createdBlogPost);
        } catch (UserNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An error occurred");
        }
    }

    /**
     * Retrieves all blog posts.
     * @return ResponseEntity with a list of blog posts and HTTP status 200 (OK).
     */
    @GetMapping("/get")
    public ResponseEntity<List<BlogPost>> getAllBlogPosts() {
        List<BlogPost> blogPosts = blogPostService.getAllBlogPosts();
        return ResponseEntity.status(HttpStatus.OK).body(blogPosts);
    }

    /**
     * Retrieves a blog post by its ID.
     * @param id The ID of the blog post to retrieve.
     * @return ResponseEntity with the blog post details and HTTP status 200 (OK) if found,
     *         or HTTP status 404 (Not Found) if the blog post is not found, or HTTP status 500 (Internal Server Error) if an error occurs.
     */
    @GetMapping("/get/{id}")
    public ResponseEntity<?> getBlogPostById(@PathVariable Long id) {
        try {
            BlogPost blogPost = blogPostService.getBlogPostById(id);
            return ResponseEntity.status(HttpStatus.OK).body(blogPost);
        } catch (BlogPostNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());            
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An error occurred");
        }
    }


    /**
     * Updates an existing blog post.
     * Checks if the user and blog post exist before updating.
     * @param id The ID of the blog post to update.
     * @param blogPost The updated blog post details.
     * @param username The username of the user updating the blog post.
	 * @return ResponseEntity with the updated blog post and HTTP status 200 (OK) if found and updated,
	 *         or HTTP status 404 (Not Found) if the blog post or user is not found,
	 *         or HTTP status 403 (Forbidden) if the user is not authorized, or HTTP status 500 (Internal Server Error) if an error occurs.
	 */
    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateBlogPost(@PathVariable Long id, @RequestBody BlogPost blogPost, @RequestParam String username) {
        try {
            BlogPost updatedBlogPost = blogPostService.updateBlogPost(id, blogPost, username);
            return ResponseEntity.status(HttpStatus.OK).body(updatedBlogPost);
        } catch (BlogPostNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        } catch (UnauthorizedAccessException e) {
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body(e.getMessage());
        } catch (UserNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An error occurred");
        }
    }

    /**
     * Deletes a blog post by ID.
     * Checks if the user and blog post exist before deleting.
     * @param id The ID of the blog post to delete.
     * @param username The username of the user deleting the blog post.
	 * @return ResponseEntity with HTTP status 200 (OK) and a success message if successfully deleted,
	 *         or HTTP status 404 (Not Found) if the blog post or user is not found,
	 *         or HTTP status 403 (Forbidden) if the user is not authorized, or HTTP status 500 (Internal Server Error) if an error occurs.
	 */
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteBlogPost(@PathVariable Long id, @RequestParam String username) {
        try {
            blogPostService.deleteBlogPost(id, username);
            return ResponseEntity.status(HttpStatus.OK).body("Blog post successfully deleted");
        } catch (BlogPostNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        } catch (UnauthorizedAccessException e) {
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body(e.getMessage());
        } catch (UserNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An error occurred");
        }
    }

}
