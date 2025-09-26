# Cangqiong Takeaway Project

##  About The Project

This is the backend for an online takeaway platform, built with a Spring Boot + MyBatis technology stack. The project follows a classic layered architecture for backend development and implements the core functional modules for an admin management system.

This is a learning project developed by following video tutorials and API documentation to master enterprise-level development workflows and standards. Currently, it includes core modules for the management backend, such as **Employee Management**, **Category Management**, and **Dish Management**.

##  Features Implemented

Based on the current progress, the following API endpoints have been developed:

### Employee Management
- **POST** /employee/login - Employee Login
- **POST** /employee/logout - Employee Logout
- **POST** /employee - Add New Employee
- **GET** /employee/page - Employee Pagination Query
- **POST** /employee/status/{status} - Enable/Disable Employee Account
- **GET** /employee/{id} - Get Employee by ID
- **PUT** /employee - Modify Employee Information

### Category Management
- **POST** /category - Add New Category
- **GET** /category/page - Category Pagination Query
- **DELETE** /category - Delete Category
- **PUT** /category - Modify Category
- **POST** /category/status/{status} - Enable/Disable Category
- **GET** /category/list - Get Categories by Type

### Dish Management
- **POST** /dish - Add New Dish
- **GET** /dish/page - Dish Pagination Query
- **DELETE** /dish - Delete Dish(es) in Batch
- **GET** /dish/{id} - Get Dish by ID
- **PUT** /dish - Modify Dish Information

##  Tech Stack

- **Core Framework**: Spring Boot
- **Persistence Framework**: MyBatis
- **Database**: MySQL
- **API Documentation**: Swagger (OpenAPI 3)
- **Others**: SLF4J

##  Project Architecture

The project uses a classic three-tier architecture, which is clear and easy to maintain:

- **Controller (API Layer)**: Receives front-end requests, validates parameters, and calls the Service layer to handle business logic before returning a response.
- **Service (Business Logic Layer)**: Implements the core business logic, processes specific business requirements, and interacts with the database via the Mapper layer.
- **Mapper (Data Access Layer)**: Also known as the DAO layer. It executes SQL statements defined in MyBatis XML mapping files to perform CRUD operations on the database.

The data flow is as follows:
```
Request -> Controller -> Service (Interface) -> ServiceImpl (Implementation) -> Mapper (Interface + simpleSQL) -> Mapper.xml (SQL) -> Database
```
