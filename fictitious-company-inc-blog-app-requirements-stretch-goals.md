# User Summary for Fictitious Company, Inc (Stretch Goal)
We want to enhance our blog software for Fictitious Company, Inc. Create/Edit/Delete capable users should be valid users in the system. Users that read the data don’t have to be registered with the system. Assume all users have the same role and permission levels (with the noted author exception below). Each blog post should be associated with an author that is a valid user of our blog system. We want only the original author being able to edit their own blog posts. 

# Technical Summary
- All communication with the backend should be via REST API endpoints with JSON payloads in the response
- Read endpoint should be open to all (No Auth required)
- Code should be appropriately documented
- At least a basic set of tests for the happy path scenarios
- If using RDBMS, it would be nice to have a script to generate additional test data
- It would be nice to have some test cases to test your solution throughly.

# Stretch Goals
These are additional requirements that are on the road map for our blog AFTER we have had a successful proof of concept of the above MVP requirements. You are in no way required to implement these items to complete the expectations for this assessment.

# User Stories
| **Title** | **User Story** | Importance | Notes |
| --- | --- | --- | --- |
| Create Blog Post Author | Each blog post should be associated with an author | Med | Stretch goal |
| Edit Blog Post author | Only the original author of the blog post should be able to edit it | Med | Stretch goal |
| Delete Blog Post author | Only the original author of the blog post should be able to delete it | Med | Stretch Goal |
| Login | A user should be able to login so they can be authenticated as a valid user | Low | Big stretch goal: (AuthN) - Developers choice although we are considering OAuth2 with passport.js |