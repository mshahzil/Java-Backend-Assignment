# Blog Posts CRUD Application

This is a Spring Boot application that performs CRUD operations (Create, Read, Update, Delete) for blog posts.

## Features

- Create a new user
- Create a new blog post
- Retrieve a list of all blog posts
- Retrieve a single blog post by ID
- Update an existing blog post
- Delete an existing blog post

## Technologies Used

- **Java 17**
- **Spring Boot 3.3.3**
- **Spring Data JPA**: For simplifying database interactions
- **H2 Database**: An in-memory database for testing purposes
- **Lombok**: For reducing boilerplate code (e.g. getters, setters, etc.)
- **Maven**: For project build and dependency management
- **Postman**: For API testing

## Getting Started

### Prerequisites

To build and run this application, you will need:

- **JDK 17** or higher
- **Maven 3.6.3** or higher
- **Git**

### Clone the Repository

```bash
git clone https://github.com/mshahzil/Java-Backend-Assignment.git
cd blogs-app
```

### Build and Run the Application

To build and run the application locally, use the following commands:

```bash
mvn clean install
mvn spring-boot:run
```

The application will start on `http://localhost:8080`.

## API Endpoints

| Method | Endpoint                                            | Description                    |
|--------|-----------------------------------------------------|--------------------------------|
| POST   | `/api/user/create`                                  | Create a new user              |
| POST   | `/api/blogpost/create?username=shahzil`             | Create a new blog post         |
| GET    | `/api/blogpost/get`                                 | Get a list of all blog posts   |
| GET    | `/api/blogpost/get/1`                               | Get a blog post by ID          |
| PUT    | `/api/blogpost/update/1?username=shahzil`           | Update a blog post by ID       |
| DELETE | `/api/blogpost/delete/1?username=shahzil`           | Delete a blog post by ID       |

## Postman Collection

A Postman collection has been provided to help test the API endpoints. You can find it in the repository at the following path:

/postman/BlogsApp.postman_collection

To use the collection, follow these steps:

1. Open Postman.
2. Go to File -> Import.
3. Select the BlogsApp.postman_collection file from the postman directory of the repository.
4. The collection will be added to your Postman workspace.
