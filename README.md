#Library Managment System

 We'll create a simple version of the Library Management System with basic functionalities: 
Create a new User
Fetch all the Users
Add new book
Fetch all the books
Fetch specific book
Delete a book 
Borrow a book 
Return a book

1. Set up a Spring Boot project
Let's launch Spring Initializr and fill up the following project details: 

## Project: Maven Project (or Gradle) 

* Language: Java 

* Packaging: Jar 

* Java version: 17

Dependencies: Spring Web, Spring Data JPA, MySQL Driver, and Lombok

Download, extract the project, and import to your favorite IDE.

2. Configure the MySQL database 
Let's open the src/main/resources/application.properties file and add the MySQL configuration properties:
 
 
* Tested on:
 
* JDK 1.8.0_161
* MySQL - 8.0.23
* swagger 
* postman
## tools 
* intellJ IDE


 
## to run and connect database  in application.yml write
server:
  port: 8080
spring:
  datasource:
    username: root
    password: root_531999
    url: jdbc:mysql://localhost:3306/library_system?useSSL=false&serverTimezone=UTC
    driver-class-name: com.mysql.cj.jdbc.Driver
  jpa:
    hibernate:
      ddl-auto: none
  
 

**4. Build and run the app using Maven**
   
+ The REST service is running at <http://localhost:8080/api>.


## How to use the API

+ The current version of the API is v1.0.

### Create (Add)

1. Creating a new Person using POST /books API
+ localhost:8080/api/books
![GitHub Logo](/images/saveBook.png) 

### Read (View)
2. Retrieving all books using GET /api/books API
+ localhost:8080/products/{productId}
![GitHub Logo](/images/getAllBook.png)

 

### Read all patrons
4. get all patrons  API
+ localhost:8080/patrons
![GitHub Logo](/images/getAllBook.png)

## IDE

This project was developed using IntelliJ IDEA 2020. 

 

## Database Schema

If applicable, the project uses the following database schema for CRUD operations on products:

 library_system is the schema of myDataBase

 
## Contact Information

For questions or collaboration opportunities, feel free to reach out:

- Name : Abdullah hamada Abd ElSalam
- email : Abdullahhamada100@gmail.com
-  phone : +20 0106-734-3329
 
 
 
