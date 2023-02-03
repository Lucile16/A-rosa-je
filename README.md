# A-Rosa-Je Project

## Introduction

This project is a full-stack web application that aims to provide a platform for managing and organizing gardening services. The front-end of the application is built using [Vue.js](https://vuejs.org/), a progressive JavaScript framework for building user interfaces. The back-end API is built using [Java JPA](https://en.wikipedia.org/wiki/Java_Persistence_API) and [MariaDB](https://mariadb.org/), an open-source relational database management system. The entire application is containerized using [Docker](https://www.docker.com/), allowing for easy deployment and scalability.

## Technologies Used

-   [Vue.js](https://vuejs.org/): A progressive JavaScript framework for building user interfaces.
-   [Java JPA](https://en.wikipedia.org/wiki/Java_Persistence_API): A Java API for object-relational mapping.
-   [MariaDB](https://mariadb.org/): An open-source relational database management system.
-   [Docker](https://www.docker.com/): A platform for building, shipping, and running applications in containers.

## Project Setup

To set up and run the A-Rosa-Je project, you will need to have [Docker](https://www.docker.com/) installed on your machine. Follow the steps below to get started:

1.  Clone the repository:


`https://github.com/Lucile16/A-rosa-je.git` 

2.  Navigate to the project directory:

`cd A-Rosa-Je` 

3.  Build the Docker containers:

`docker-compose build` 

4.  Start the Docker containers:

`docker-compose up` 

5.  Access the application in your browser at `http://localhost:8080`.

6. (Optional) Populate the database with test data by launching the populate_db.sh script

## Conclusion

The A-Rosa-Je project provides a platform for managing and organizing gardening services using a modern, full-stack technology stack. With the use of Vue.js, Java JPA, MariaDB, and Docker, the application is both scalable and easily deployable.