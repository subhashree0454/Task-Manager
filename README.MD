
# TaskFlow - Your Personal Task Manager

A clean, modern, and fully functional **Task Management Web App** built with **Spring Boot**, **Thymeleaf**, **Hibernate**, and **Tailwind CSS**.

Live in under 10 seconds — no configuration needed!

## Features

- Register & Login (session-based authentication)
- Create, Edit, Delete Tasks
- Task Status: `To Do` / `In Progress` / `Done` (with color coding)
- Beautiful UI with **Tailwind CSS** (fully responsive)
- Task creation timestamp
- Clean and minimal design
- Zero JavaScript — pure server-side rendering

## Tech Stack

- **Backend**: Spring Boot 3 + Spring MVC + Spring Data JPA
- **Database**: H2 (in-memory) or any SQL database
- **Templating**: Thymeleaf
- **Styling**: Tailwind CSS (via CDN — no build tools!)
- **Persistence**: Hibernate + JPA
- **Authentication**: Manual session-based (simple & educational)

## Screenshots

![TaskFlow Dashboard](https://via.placeholder.com/1200x600/6366f1/ffffff?text=TaskFlow+Dashboard+-+Beautiful+UI)
> *Modern dashboard with color-coded tasks and timestamps*

## Quick Start (Run in 10 seconds!)

### Prerequisites
- Java 17+
- Maven

### Run the app

```bash
git clone https://github.com/yourusername/taskflow.git
cd taskflow
./mvnw spring-boot:run
```

Open your browser: [http://localhost:8080](http://localhost:8080)

### Default Flow
1. Go to `/register` → Create an account
2. Login at `/`
3. Start managing your tasks!

## Project Structure

```
taskflow/
├── pom.xml
├── mvnw
├── mvnw.cmd
├── README.md
├── .gitignore
│
├── src/
│   └── main/
│       ├── java/
│       │   └── com/
│       │       └── taskmanagement/
│       │           ├── TaskManagementApplication.java
│       │           │
│       │           ├── controller/
│       │           │   └── TaskController.java
│       │           │
│       │           ├── model/
│       │           │   ├── User.java
│       │           │   └── Task.java
│       │           │
│       │           ├── repository/
│       │           │   ├── UserRepository.java
│       │           │   └── TaskRepository.java
│       │           │
│       │           └── service/
│       │               ├── UserService.java
│       │       
│       │               ├── TaskService.java
│       │              
│       │
│       └── resources/
│           ├── static/                   (optional: for images, css)
│           ├── templates/
│           │   ├── login.html
│           │   ├── register.html
│           │   ├── home.html
│           │   └── edit-task.html
│           │
│           ├── application.properties
│           └── data.sql                   (optional: for initial data)
│
└── target/                           (auto-generated when you run)
```

## Future Ideas (You can add!)

- [ ] Password hashing with BCrypt
- [ ] Spring Security
- [ ] Task due dates & reminders
- [ ] Dark mode toggle
- [ ] Export tasks to PDF
- [ ] Deploy to Render / Railway / Heroku

## Made With Love


Made with passion by Rajeev • 2025

**Star this repo if you like it!**
