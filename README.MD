# TaskFlow - Your Personal Task Manager
A clean, modern, and fully functional **Task Management Web App** built with **Spring Boot**, **Thymeleaf**, **Hibernate**, and **Tailwind CSS**.
Get started in minutes with a robust and persistent PostgreSQL database.
## Table of Contents

- [Features](#features)
- [Tech Stack](#tech-stack)
- [Screenshots](#screenshots)
- [Setup Guide](#setup-guide)
- [Project Structure](#project-structure)
- [How to Use TaskFlow](#how-to-use-taskflow)
- [Future Improvements](#future-improvements)
- [Troubleshooting](#troubleshooting)

## Features

- **User Authentication**: Secure registration and session-based login.
- **Task Management**: Create, view, edit, and delete tasks.
- **Task Statuses**: Track progress with `To Do`, `In Progress`, and `Done` statuses.
- **Modern UI**: A beautiful, fully responsive interface built with Tailwind CSS.
- **Zero Client-Side JS**: A fast, secure, and pure server-side rendered application.
- **Persistent Storage**: Your tasks are stored safely in a PostgreSQL database.

## Tech Stack

- **Backend**: Spring Boot 3, Spring MVC, Spring Data JPA
- **Database**: PostgreSQL
- **Templating**: Thymeleaf
- **Styling**: Tailwind CSS (via CDN)
- **Persistence**: Hibernate (JPA implementation)
- **Authentication**: Manual session-based (simple & educational)

## Screenshots
### | Login Page |
|---|---|---|
| ![Login](/TaskManagement/img/login.png)

###  Register Page |
 ![Register](/TaskManagement/img/register.png)
  
### Home Dashboard |
![Home](/TaskManagement/img/home.png)
## Setup Guide

Follow these steps to get TaskFlow running on your local machine.

### 1. Prerequisites
Before you begin, ensure you have the following installed:
- **Java 17+**: [Download JDK](https://www.oracle.com/java/technologies/javase/jdk17-archive-downloads.html)
- **Maven 3.6+**: [Download Maven](https://maven.apache.org/download.cgi)
- **PostgreSQL**: [Download PostgreSQL](https://www.postgresql.org/download/)


### 2. Clone the Repository

```bash
git clone https://github.com/imrajeevnayan/Task-Management.git
cd Task-Management
```

### 3. Set Up PostgreSQL Database

You need to create a database and a user for the application.
1. Open the PostgreSQL shell (`psql`) or a GUI tool like pgAdmin.
2. Run the following SQL commands to create a database and a user. **Remember to replace `your_secure_password` with a strong password.**

```sql
-- Create a new database for the application
CREATE DATABASE taskflow_db;
-- Create a new user with a password
CREATE USER taskflow_user WITH PASSWORD 'your_secure_password';
-- Grant all privileges on the new database to the new user
GRANT ALL PRIVILEGES ON DATABASE taskflow_db TO taskflow_user;
```

### 4. Configure the Application

Now, you need to tell your Spring Boot application how to connect to the database you just created.
1. **Update `pom.xml`**:

    Open the `pom.xml` file and add dependency with the PostgreSQL driver.
    
    ```xml
    <dependency>
        <groupId>org.postgresql</groupId>
        <artifactId>postgresql</artifactId>
        <scope>runtime</scope>
    </dependency>
    ```
    
2. **Configure `application.properties`**:

    Open the `src/main/resources/application.properties` file and replace its entire content with the following configuration. **Make sure to use the password you set in the previous step.**
    
    ```properties
    # ===================================================================
    # PostgreSQL DATABASE CONFIGURATION
    # ===================================================================
    # Set your PostgreSQL connection URL
    spring.datasource.url=jdbc:postgresql://localhost:5432/taskflow_db
    # Set the database username and password you created
    spring.datasource.username=taskflow_user
    spring.datasource.password=your_secure_password
    # The JDBC driver class for PostgreSQL
    spring.datasource.driver-class-name=org.postgresql.Driver
    # ===================================================================
    # JPA / HIBERNATE CONFIGURATION
    # ===================================================================
    # The SQL dialect makes Hibernate generate better SQL for the chosen database
    spring.jpa.database-platform=org.hibernate.dialect.PostgreSQLDialect
    # "update" will update the schema if the model changes.
    # "validate" will validate the schema on startup, making no changes to the database.
    # Recommended to use "validate" in production after the first run.
    spring.jpa.hibernate.ddl-auto=update
    # This is useful during development to see the SQL queries being executed.
    spring.jpa.show-sql=true
    ```
    
### 5. Run the Application
You are now ready to run the app!

```bash
# Using the Maven Wrapper (Recommended)
./mvnw spring-boot:run
# Or using your system's Maven installation
mvn spring-boot:run
```

The application will start on `http://localhost:8080`.

### 6. Get Started!
1. Open your browser and go to **[http://localhost:8080/register](http://localhost:8080/register)**.
2. Create a new account.
3. Once registered, you will be redirected to the login page. Log in with your new credentials.
4. You're all set! Start managing your tasks from the dashboard.

## Project Structure

This is the exact structure of the project.

```
Task-Management/
├── pom.xml # Maven project configuration
├── mvnw # Maven wrapper script for Unix/Linux/macOS
├── mvnw.cmd # Maven wrapper script for Windows
├── README.md # This file
├── .gitignore # Git ignore file
│
├── src/
│ └── main/
│ ├── java/
│ │ └── com/
│ │ └── taskmanagement/
│ │ ├── TaskManagementApplication.java # Main application class
│ │ │
│ │ ├── controller/ # Web controllers
│ │ │ ├── AuthController.java # Handles login/register
│ │ │ └── TaskController.java # Handles task operations
│ │ │
│ │ ├── model/ # JPA entities (database tables)
│ │ │ ├── User.java # User entity
│ │ │ └── Task.java # Task entity
│ │ │
│ │ ├── repository/ # JPA repositories (data access layer)
│ │ │ ├── UserRepository.java # Handles User data operations
│ │ │ └── TaskRepository.java # Handles Task data operations
│ │ │
│ │ └── service/ # Business logic layer
│ │ ├── UserService.java # User-related business logic
│ │ └── TaskService.java # Task-related business logic
│ │
│ └── resources/
│ ├── templates/ # Thymeleaf HTML templates
│ │ ├── login.html # Login page
│ │ ├── register.html # Registration page
│ │ ├── home.html # Main task dashboard
│ │ └── edit-task.html # Form to edit a task
│ │
│ └── application.properties # Application configuration file
│
└── target/ # Compiled output (auto-generated)
```

## How to Use TaskFlow

- **Register**: Create a new user account at `/register`.
- **Login**: Access your personal dashboard by logging in at `/`.
- **Create Task**: On the dashboard, click "Add New Task" to create one.
- **Edit Task**: Click the "Edit" button on any task card to modify its title, description, or status.
- **Change Status**: Click the status button (e.g., "To Do") on a task to cycle through the available statuses.
- **Delete Task**: Click the "Delete" button on a task to permanently remove it.
- **Logout**: Click the "Logout" link to end your session.

## Future Improvements
- [ ] Implement password hashing with BCrypt for better security.
- [ ] Integrate Spring Security for robust authentication and authorization.
- [ ] Add task due dates and reminders.
- [ ] Implement task categories or tags.
- [ ] Add a dark mode toggle.
- [ ] Allow users to export their tasks to CSV or PDF.
- [ ] Deploy the application to a cloud service like Render, Railway, or Heroku.

## Troubleshooting

**Application fails to start:**
- Ensure Java 17+ and Maven are installed correctly (`java -version`, `mvn -version`).
- Check that port 8080 is not being used by another application.
**Database Connection Error:**
- Verify that your PostgreSQL server is running.
- Double-check the database name, username, and password in `application.properties`.
- Make sure you have granted the correct privileges to the `taskflow_user`.
**"Access denied for user" error:**
- This means the credentials in `application.properties` do not match the user you created in PostgreSQL. Re-check the username and password.
---

Made with passion by Rajeev • 2025
**Star this repo if you like it!** ⭐
