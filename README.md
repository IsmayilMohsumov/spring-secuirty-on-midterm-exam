# Ismayil-Mid-Term-Assignment

Mid-Term Assignment

Build a resume upload portal using spring boot and thymeleaf framework


User Access:
Create User Registration form
User data should be stored into mysql table with name user
Create User login Form
After Login User should be able to access resume upload page
Resume uploaded should be stored in local directory(static) and save the file link in the user table
Maintain user login status with http session


Admin Access:
Create new controller for admin will have a view page where all the resumes will be visible in the table along with a link to the uploaded resume.

## General info

This backend-service developed to practice my knowledge on Java Spring. I have successfully managed to create the backend-service


### Requirements

For building and running the application you need:

- [JDK 1.8](http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html)
- [Docker](https://www.docker.com/products/docker-desktop/)
- [Gradle](https://gradle.org/install/)


### Running the application locally

There are several ways to run a Spring Boot application on your local machine. One way is to execute the `main` method in the `com.midterm.exam.ExamApplication` class from your IDE.

But first of all you need to configure `application.yml` with your database and then run :
```shell
cd project-folder
docker-compose up
```

In case you don't have `docker` you can change `application.yml` and just run the project

### Contribution
This project isn't open for contributions

### Authors
* **Ismayil Mohsumov**