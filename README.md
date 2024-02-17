# Withdrawal Notice Project

[![Java Version](https://img.shields.io/badge/Java-17-blue)](#)
[![Spring Boot Version](https://img.shields.io/badge/Spring%20Boot-3.2.0-green)](#)
[![Maven Version](https://img.shields.io/badge/Maven-4.0.0-red)](#)
[![License](https://img.shields.io/badge/License-MIT-yellow)](LICENSE)

This project is a Spring Boot application for managing withdrawal notices.

## Table of Contents

- [Introduction](#introduction)
- [Technologies](#technologies)
- [Getting Started](#getting-started)
- [Email Configuration](#email-configuration)
- [H2 Database Configuration](#h2-database-configuration)
- [Building and Running](#building-and-running)

## Introduction

This project allows users to signup, signin add an investements product, view their details, investments and send a withdrawal notice.

## Technologies

- [Spring Boot](https://spring.io/projects/spring-boot)
- [Spring Data JPA](https://spring.io/projects/spring-data-jpa)
- [Thymeleaf](https://www.thymeleaf.org/)
- [Spring Web](https://spring.io/guides/gs/serving-web-content/)
- [Spring Mail](https://docs.spring.io/spring-boot/docs/current/reference/htmlsingle/#boot-features-email)
- [H2 Database](https://www.h2database.com/html/main.html)
- [Lombok](https://projectlombok.org/)
- [Spring Boot Test](https://spring.io/guides/gs/testing-web/)
- [Spring Validation](https://docs.spring.io/spring-framework/docs/current/reference/html/core.html#validation-beanvalidation-spring)
- [Spring Security](https://spring.io/guides/gs/securing-web/)
- [Java-jwt](https://github.com/auth0/java-jwt?tab=readme-ov-file#getting-started)

## Getting Started

To get started with this project, follow these steps:

1. Clone the repository: `git clone https://github.com/mzwili/WithDrawal-Notice.git`
2. Navigate to the project directory: `cd assessment.grad001.ThuthukaniMthiyane`
3. Build the project: `mvn clean install`
4. Run the application: `mvn spring-boot:run`

## Email Configuration

Step by step guide for sending emails Link by GeeksforGeeks
https://www.geeksforgeeks.org/spring-boot-sending-email-via-smtp/

## H2 Database Configuration

Step by step guide for H2 Configuration Link by GeeksforGeeks
https://www.geeksforgeeks.org/spring-boot-h2-database/

## Building and Running

To build the project, use Maven:

```bash
mvn clean install
mvn spring-boot:run
