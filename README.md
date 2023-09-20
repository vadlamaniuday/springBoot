# Spring Boot Project


**This is a Spring Boot project for managing departments. It provides CRUD (Create, Read, Update, Delete) operations for departments, with validation and error handling.**

 This is a Spring Boot project for managing departments. It provides CRUD (Create, Read, Update, Delete) operations for departments, with validation and error handling.
 
 Technologies Used 
 1. **Development Environment**  : IntelliJ IDEA
 2. **API Testing** : PostMan 
 3. **Backend Technologies** : Spring ,SpringBoot , Spring Data JPA , Hibernate
 4. **Database** : MYSQL

## Project Structure

The project is organized into different layers:

-   **Controller Layer**: Handles incoming HTTP requests and interacts with the service layer.
-   **Entity Layer**: Contains the `Department` entity class.
-   **Repository Layer**: Provides data access and database operations.
-   **Service Layer**: Implements business logic and serves as an intermediary between the controller and repository.

## Controller Layer

The controller layer is responsible for handling HTTP requests and defining API endpoints. Key endpoints include:

-   `POST /departments`: Create a new department.
-   `GET /departments`: Fetch a list of all departments.
-   `GET /departments/{id}`: Fetch a department by its ID.
-   `DELETE /departments/{id}`: Delete a department by its ID.
-   `PUT /departments/{id}`: Update a department by its ID.
-   `GET /departments/name/{name}`: Fetch a department by its name.

## Entity Layer

The entity layer defines the `Department` class, which represents a department entity. It includes properties like `departmentId`, `departmentName`, `departmentAddress`, and `departmentCode`. Validation constraints are applied to ensure data integrity.

## Repository Layer

The repository layer uses Spring Data JPA to interact with the database. It provides methods for querying and managing `Department` entities in the database. Notable methods include finding a department by name and ignoring case.

## Service Layer

The service layer contains the `DepartmentService` interface and its implementation, `DepartmentServiceImpl`. It defines operations for creating, retrieving, updating, and deleting departments. Additionally, it handles exceptions like `DepartmentNotFoundException`.


