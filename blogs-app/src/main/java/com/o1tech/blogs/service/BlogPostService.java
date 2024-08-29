package com.o1tech.blogs.service;

import com.o1tech.blogs.model.BlogPost;
import com.o1tech.blogs.repository.BlogPostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Service layer for handling blog post operations.
 */
@Service
public class BlogPostService {

    @Autowired
    private BlogPostRepository blogPostRepository;

    /**
     * Creates a new blog post.
     * @param blogPost The blog post to be created.
     * @return The created blog post.
     */
    public BlogPost createBlogPost(BlogPost blogPost) {
        return blogPostRepository.save(blogPost);
    }

    /**
     * Retrieves all blog posts.
     * @return A list of all blog posts.
     */
    public List<BlogPost> getAllBlogPosts() {
        return blogPostRepository.findAll();
    }
    
    /**
     * Retrieves a blog post by its ID.
     * @param id The ID of the blog post to retrieve.
     * @return An Optional containing the blog post if found.
     */
    public Optional<BlogPost> getBlogPostById(Long id) {
        return blogPostRepository.findById(id);
    }

    /**
     * Updates an existing blog post.
     * @param id The ID of the blog post to update.
     * @param blogPost The blog post details to update.
     * @return The updated blog post if found, otherwise null.
     */
    public BlogPost updateBlogPost(Long id, BlogPost blogPost) {
        if (blogPostRepository.existsById(id)) {
            blogPost.setId(id);
            return blogPostRepository.save(blogPost);
        }
        return null;
    }
    
    /**
     * Deletes a blog post by its ID if it exists.
     * @param id The ID of the blog post to delete.
     * @return true if the blog post was successfully deleted, false if the blog post was not found.
     */
    public boolean deleteBlogPost(Long id) {
        if (blogPostRepository.existsById(id)) {
            blogPostRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
