package com.o1tech.blogs;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * The entry point for the Spring Boot application.
 */
@SpringBootApplication
public class BlogsApplication {

	/**
     * The main method to launch the Spring Boot application.
     * @param args Command-line arguments passed to the application.
     */
	public static void main(String[] args) {
		SpringApplication.run(BlogsApplication.class, args);
	}

}
