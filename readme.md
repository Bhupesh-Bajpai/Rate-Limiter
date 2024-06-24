# Rate Limiter Service

## Overview

This project implements a rate limiter service using Spring Boot. The service initializes rate limiting rules from a database and applies them to various API endpoints. It utilizes a token bucket algorithm to manage and enforce the rate limits for each endpoint, ensuring controlled access and preventing abuse.

## Features

- **Rate Limiting:** Limits the number of requests to API endpoints based on configured limits.
- **Database Integration:** Initializes rate limiting rules from a database.
- **Token Bucket Algorithm:** Implements a token bucket algorithm for rate limiting.
- **Spring Boot:** Built with Spring Boot for easy setup and deployment.

## Getting Started

### Prerequisites

- Java 11 or higher
- Maven 3.6.0 or higher
- MySQL or any other relational database

### Setting Up the Project

1. **Clone the repository:**

    ```bash
    git clone https://github.com/your-username/rate-limiter-service.git
    cd rate-limiter-service
    ```

2. **Configure the Database:**

    Update the `application.properties` file with your database configuration:

    ```properties
    spring.datasource.url=jdbc:mysql://localhost:3306/your_database
    spring.datasource.username=your_username
    spring.datasource.password=your_password
    spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
    spring.jpa.hibernate.ddl-auto=update
    spring.jpa.show-sql=true
    ```

3. **Build and Run the Project:**

    Use Maven to build and run the project:

    ```bash
    mvn clean install
    mvn spring-boot:run
    ```

### Usage

To check the rate limit for a specific API endpoint, send a GET request to:

