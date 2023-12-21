# Withdrawal Notice Project

This project is a Spring Boot application for managing withdrawal notices.

## Table of Contents

- [Introduction](#introduction)
- [Technologies](#technologies)
- [Getting Started](#getting-started)
- [Project Structure](#project-structure)
- [Building and Running](#building-and-running)
- [Testing](#testing)
- [Contributing](#contributing)
- [License](#license)

## Introduction

This Spring Boot project is designed for handling withdrawal notices. It leverages various technologies, including Spring Boot, Spring Data JPA, Thymeleaf, and more.

## Technologies

- [Spring Boot](https://spring.io/projects/spring-boot)
- [Spring Data JPA](https://spring.io/projects/spring-data-jpa)
- [Thymeleaf](https://www.thymeleaf.org/)
- [H2 Database](https://www.h2database.com/html/main.html)
- [Lombok](https://projectlombok.org/)

## Getting Started

To get started with this project, follow these steps:

1. Clone the repository: `git clone https://github.com/mzwili/WithDrawal-Notice.git`
2. Navigate to the project directory: `cd assessment.grad001.ThuthukaniMthiyane`
3. Build the project: `mvn clean install`
4. Run the application: `mvn spring-boot:run`

## Project Structure

The project follows a standard Maven project structure. Key packages include:

- `com.enviro.assessment.grad001.ThuthukaniMthiyane`: Main package
- `com.enviro.assessment.grad001.ThuthukaniMthiyane.controller`: Controllers
- `com.enviro.assessment.grad001.ThuthukaniMthiyane.service`: Services
- `com.enviro.assessment.grad001.ThuthukaniMthiyane.repository`: Repositories
- `com.enviro.assessment.grad001.ThuthukaniMthiyane.entity`: Entity classes

## Building and Running

To build the project, use Maven:

```bash
mvn clean install
mvn spring-boot:run