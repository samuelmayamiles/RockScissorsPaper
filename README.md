# Rock Scissors Paper API

Write a program that plays 100 iterations of Rock, Paper, Scissors (https://en.wikipedia.org/wiki/Rock-paper-scissors).
Requirements:

- One player should always play randomly, the other should always choose rock.
- It should show at the end how many games each player has won and how many were a draw.
- The code should have high test coverage.
- Keep it simple.

Technical requirements:

- Language: Java, tests in a JVM language of your choice
- Approach: ideally "test-driven"

## Getting Started

- Source Code can be downloaded from this repository.
- An executable jar is also provided.

### Executing the jar

- Download the jar file.
- Execute using java jar command:
```
java -jar rockscissorspaper-1.1.2-SNAPSHOT.jar
```
- By default, jar file runs on port 8080. To change this, just add "--server.port=[PORT_NUMBER]"
```
java -jar rockscissorspaper-1.1.2-SNAPSHOT.jar --server.port=8090
```
- Once running, API documentation should be available from any browser:
```
http://localhost:8080/swagger-ui.html
```

## Built With

* [Eclipse](https://eclipse.org/) - The IDE used
* [Java](https://www.java.com/) - JDK 1.8.0.20
* [Maven](https://maven.apache.org/) - Dependency Management
* [Spring Boot](https://projects.spring.io/spring-boot/)

## Authors

* **Samuel Maya Miles** - [Github](https://github.com/samuelmayamiles/)
