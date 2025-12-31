## What this application does

* Create a bank account
* Store customer details (name, mobile, gender)
* Store opening balance
* View balance using account number
* Write logs to a file

## Technologies Used 
* Java
* Spring Boot
* JDBC (JdbcTemplate)
* MySQL Database
* JUnit 5 and Mockito
* SLF4J Logging

## Database Setup

Create database and table:

sql
CREATE DATABASE bankdb;

USE bankdb;

CREATE TABLE account (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    account_number VARCHAR(20) UNIQUE,
    name VARCHAR(100),
    mobile VARCHAR(15),
    gender VARCHAR(10),
    balance DOUBLE
);

## Application Configuration

Update application.properties:

properties
spring.datasource.url=jdbc:mysql://localhost:3306/bankdb
spring.datasource.username=root
spring.datasource.password=yourpassword

logging.file.name=logs/bank-app.log
logging.level.root=INFO

## How to Run the Application

bash
mvn spring-boot:run

Open browser and go to:

http://localhost:8080/index.html

## Application URLs

* Create Account:
  POST /bank/create

* View Balance:
  GET /bank/balance?accNo=ACCOUNT_NUMBER

## Project Structure

bank-app
 ├── src/main/java
 │   ├── controller
 │   ├── service
 │   └── dao
 ├── src/main/resources
 │   ├── static/index.html
 │   └── application.properties
 └── src/test/java
     └── BankServiceTest.java

## Author
Purushothaman D.
