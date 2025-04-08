# MFN Manager

## Table of Contents
- [Introduction](#Introduction)
- [Project Structure](#Project-structure)
- [Toolset](#Toolset)
- [Build Status](#Build-Status)

### Introduction

A helper application for the MyFootballNow (https://www,myfootballnow.com) online game.  MyFootballNow allows the players
to join leagues, gameplan, manage rosters and watch played games.  

All of this involves a lot of data; the aim of this project is to provide tools for the player to use.

### Project structure

The project consists of a top level pom file, a parent pom.  This defines common dependencies within
the and is to be used as the parent of any modules developed.

### Toolset

The toolset used is divided into three sections, project tools, development tools and 
software libraries / frameworks.  Transitive dependencies are not listed.

#### Project Tools

The following project tools are used.

| Project Tool   | Link                                                                                                              |
|----------------|-------------------------------------------------------------------------------------------------------------------|
| Jira           | [MFN Manager Project JIRA](https://warnett.atlassian.net/jira/software/projects/MFNM/boards/1)                    |
| CircleCI       | [MFN Manager CircleCI](https://app.circleci.com/projects/circleci/M82cTqCgc1EX12ST37HaQ6/VZfCWLSZnumxrNJDU5tCcp)  |

#### Development Tools

The following development tools are used in this project.

| Development Tool       | Version  | Link                                                      |
|------------------------|----------|-----------------------------------------------------------|
| Intellij CE            |          | [IntelliJ CE](https://www.jetbrains.com/idea/)            |
| Jacoco                 | 0.8.12   | [Jacooco](https://www.jacoco.org/jacoco/)                 |
| Spotbugs               | 4.9.3.0  | [Spotbugs](https://spotbugs.github.io/)                   |
| OWASP dependency check | 12.1.0   | [OWASP](https://owasp.org/www-project-dependency-check/)  |

#### Software Libraries / Frameworks

The following languages, libraries and frameworks are used in this project.

| Language/Library/Framework  | Version | Link                                                                      |
|-----------------------------|---------|---------------------------------------------------------------------------|
| Java                        | 23      | [Adoptium Temurin 23.0.1](https://adoptium.net/en-GB/download/)           |
| Spring Boot                 | 3.4.4   | [Spring Boot 3.4.4](https://spring.io/projects/spring-boot)               |
| Lombok                      | 1.18.36 | [Lombok 1.18.36](https://projectlombok.org/)                              |

#### Test scope Libraries / Frameworks

The following libraries / frameworks are used in this project with test scope only. 

| Library/Framework | Version  | Link                                                         |
|-------------------|----------|--------------------------------------------------------------|
| Spring Boot Test  | 3.4.4    | [Spring Boot 3.4.4](https://spring.io/projects/spring-boot)  |
| Mockito           | 5.16.1   | [Mocki to](https://site.mockito.org/)                        |
| AssertJ           | 4.0.0-M1 | [AssertJ](https://assertj.github.io/doc/)                    |


### Build Status

The following are a list of the build statuses.

| Build    | Status                                                                                                                                                                                                                                                 |
|----------|--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| CircleCI | [![CircleCI](https://dl.circleci.com/status-badge/img/circleci/M82cTqCgc1EX12ST37HaQ6/VZfCWLSZnumxrNJDU5tCcp/tree/main.svg?style=svg)](https://dl.circleci.com/status-badge/redirect/circleci/M82cTqCgc1EX12ST37HaQ6/VZfCWLSZnumxrNJDU5tCcp/tree/main) |

### VERSION HISTORY

| Version | Description           | Release |
|---------|-----------------------|---------|
| 0.0.1   | Initial Project setup |         |