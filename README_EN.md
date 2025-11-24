# PFE Management System (Final Year Project)

## Description

JavaFX application for managing Final Year Projects (PFE - Projet de Fin d'Études) allowing administrators, teachers, and students to manage the entire final year project process.

## Features

### For Administrators
- Teacher management (add, edit, delete)
- Student management (add, edit, delete)
- PFE management (create, track, validate)

### For Students
- Submit PFE topics
- Submit reports
- Check PFE status
- Browse available PFEs

## Technologies Used

- **Java 11**
- **JavaFX 13** - Graphical User Interface
- **Maven** - Project management and dependencies
- **JDBC** - Database connectivity (DM JDBC 8)
- **FXML** - Interface design

## Prerequisites

- Java JDK 11 or higher
- Apache Maven 3.6+
- Compatible database (DaMeng Database)

## Installation

1. Clone the repository:
```bash
git clone https://github.com/ZiliOussema/Systeme-de-Gestion-des-PFE.git
cd javaproject-main
```

2. Build the project:
```bash
mvn clean install
```

3. Run the application:
```bash
mvn javafx:run
```

## Project Structure

```
src/main/java/com/mycompany/testmaven/
├── App.java                          # Application entry point
├── ConnectionDB.java                 # Database connection management
├── enseignant.java                   # Teacher model
├── etudiant.java                     # Student model
└── [Controllers and FXML]            # Interfaces and business logic
```

## Configuration

Configure database connection in `ConnectionDB.java`:
- Database URL
- Username
- Password

## Application Modules

### Login Module
- Secure login interface
- User authentication

### Administrator Module
- Administrator dashboard
- Full CRUD for teachers and students
- Centralized PFE management

### Student Module
- Student homepage
- Project submission and tracking
- Information consultation

## Contributing

Contributions are welcome! Feel free to:
1. Fork the project
2. Create a feature branch
3. Commit your changes
4. Push to the branch
5. Open a Pull Request

## License

This project is licensed under [to be defined].

## Contact

For any questions or suggestions, feel free to contact us.
