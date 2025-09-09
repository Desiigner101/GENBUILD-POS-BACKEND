# GENBUILD-POS-Backend

This is the backend of my GENBUILD-POS project — a student-built Retail Billing Software.
It is powered by Spring Boot and serves as the API & server-side logic for handling data, requests, and business rules of the system.

# Tech stack

- Backend framework: Spring Boot
- Language: Java
- Database: MySQL
- API style: RESTful
- Authentication: JWT (Bearer tokens)
- File storage: AWS S3 for item images

# Features

- Manage products / items (create with image upload, read, delete)
- Manage categories
- Billing / transaction handling (core logic in services)
- Secure endpoints (ROLE_USER, ROLE_ADMIN)
- File upload handling for product images (multipart/form-data)
  
# Purpose
The backend is responsible for:

- Managing billing operations
- Handling product & inventory data
- Processing customer transactions
- Serving secure endpoints to the frontend

# Notes

This is my first ever POS backend project, made for the sake of learning and growth. It’s not about perfection, but about exploring full-stack development and challenging myself step by step.
