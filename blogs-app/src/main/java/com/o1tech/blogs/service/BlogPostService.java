package com.o1tech.blogs.service;

import com.o1tech.blogs.exception.BlogPostNotFoundException;
import com.o1tech.blogs.exception.UnauthorizedAccessException;
import com.o1tech.blogs.model.BlogPost;
import com.o1tech.blogs.model.User;
import com.o1tech.blogs.repository.BlogPostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Service layer for handling blog post operations.
 */
@Service
public class BlogPostService {

    @Autowired
    private BlogPostRepository blogPostRepository;
    
    @Autowired
    private UserService userService;

    /**
     * Creates a new blog post and associates it with the specified username.
     * Checks if the user exists and sets them as the author before saving the blog post.
     * @param blogPost The blog post to be created.
     * @param username The username of the user creating the blog post.
     * @return The created blog post.
     */
	public BlogPost createBlogPost(BlogPost blogPost, String username) {
        // Fetch the user, will throw UserNotFoundException if user is not found
	    User author = userService.findByUsername(username);
	    
	    // Set the fetched user as the author of the blog post, then save the blog post
	    blogPost.setAuthor(author);
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
     * @return The blog post if found, otherwise throws BlogPostNotFoundException.
     */
    public BlogPost getBlogPostById(Long id) {
        return blogPostRepository.findById(id).orElseThrow(() -> new BlogPostNotFoundException("Blog Post not found"));
    }

    /**
     * Updates an existing blog post with the provided details if the user is authorized.
     * Fetches the user and the blog post, checks authorization, and then updates the blog post.
     * @param id The ID of the blog post to update.
     * @param updatedBlogPost The blog post details to update.
     * @param username The username of the user performing the update.
     * @return The updated blog post if found and updated, otherwise throws BlogPostNotFoundException or UnauthorizedAccessException.
     */
    public BlogPost updateBlogPost(Long id, BlogPost updatedBlogPost, String username) {
        // Fetch the user, will throw UserNotFoundException if user is not found
        User user = userService.findByUsername(username);

        // Fetch the blog post, will throw BlogPostNotFoundException if blog post is not found
        BlogPost blogPost = blogPostRepository.findById(id)
                .orElseThrow(() -> new BlogPostNotFoundException("Blog Post not found"));

        // Check if the user is authorized to update the blog post
        if (!blogPost.getAuthor().equals(user)) {
            throw new UnauthorizedAccessException("User not authorized to update this blog post");
        }

        // Update the blog post
        updatedBlogPost.setId(id);
        updatedBlogPost.setAuthor(user);
        return blogPostRepository.save(updatedBlogPost);
    }

    
    /**
     * Deletes a blog post by its ID if it exists and the user is authorized.
     * Fetches the user and the blog post, checks authorization, and then deletes the blog post.
     * @param id The ID of the blog post to delete.
     * @param username The username of the user performing the deletion.
     * @throws BlogPostNotFoundException If the blog post is not found.
	 * @throws UnauthorizedAccessException If the user is not authorized to delete the blog post.
	 */    
    public void deleteBlogPost(Long id, String username) {
        // Fetch the user, will throw UserNotFoundException if user is not found
        User user = userService.findByUsername(username);

        // Fetch the blog post, will throw BlogPostNotFoundException if blog post is not found
        BlogPost blogPost = blogPostRepository.findById(id)
                .orElseThrow(() -> new BlogPostNotFoundException("Blog Post not found"));

        // Check if the user is authorized to delete the blog post
        if (!blogPost.getAuthor().equals(user)) {
            throw new UnauthorizedAccessException("User not authorized to delete this blog post");
        }

        // Delete the blog post
        blogPostRepository.deleteById(id);
    }

}
