# Backend Repository for The Everytone Store

This repository contains the Spring Boot backend application for The Everytone Store.

## System Requirements

Before you install and run the backend application, ensure your system meets the following requirements:

- **Java**: JDK 17 or newer.
- **Maven**: Maven 3.6 or higher.
- **Database**: MySQL 8 or higher. Make sure you have MySQL installed and running on your system, recommended to download MySQL Workbench.
- **IDE**: Any preferred IDE that supports Java, Maven, and Spring Boot (e.g., IntelliJ IDEA, Eclipse).
- **Git**: For cloning and version control.

## Environment Setup

Before running the application, you will need the `.env` file which contains necessary environment variables:

- Obtain the `.env` file from the project's Google Drive folder. Access may require permissions which can be requested from the project administrator.
- Place the `.env` file in the root directory of your project.

## Installation Instructions

Follow these steps to get the backend up and running on your local machine:

### 1. Clone the Repository

To clone the repository, use the following command in your terminal:

    git clone https://github.com/The-Everytone-Store/Backend.git

### 2. Install Dependencies

Navigate to the cloned directory and install the necessary dependencies:

    cd Backend
    mvn clean install

### Troubleshooting

If you encounter the error "Module JDK is not defined" in `Main.java`, follow these steps:

- Right-click on `pom.xml` in your IDE.
- Select **Add as Maven Project** to ensure Maven properly manages your project dependencies and settings.

## Running the Application

After installation, you can run the application by executing:

    mvn spring-boot:run

This command will start the Spring Boot application using the embedded server. By default, the application will be available at `http://localhost:8080`.
