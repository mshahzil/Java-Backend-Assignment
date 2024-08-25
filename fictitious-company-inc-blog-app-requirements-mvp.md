# MVP User Summary for Fictitious Company, Inc
We want to create our own blog software to use for Fictitious Company, Inc because WordPress and all of the other CMS systems are just too cumbersome to set up and use. As with any other blog, our users will need to be able to create, read, update, and delete blog posts. Assume all users have the same role and permission levels.

# Technical Summary
- All communication with the backend should be via REST API endpoints with JSON payloads in the response
- User/blog data will need to be persisted to fulfill the requirement (Up to the developer to decide: in-memory or RDBMS)
- Code should be appropriately documented
- At least a basic set of tests for the happy path scenarios
- If using RDBMS, it would be nice to have a script to generate additional test data

# User Stories
| **Title** | **User Story** | Importance | Notes |
| --- | --- | --- | --- |
| Create Blog Post | A user should be able to create a new blog post | High | |
| Edit Blog Post | A user should be able to edit an existing blog post | High | This is the minimum for MVP, but preference would be to further extend this to inlcude “Edit Blog Post author” story in this list.|
| Delete Blog Post | A user should be able to delete an existing blog post | High | |
| Read Blog Posts List | A user should be able to pull all blog posts | High | |


