# SAMPLE-REST

SAMPLE-REST is a basic Spring-Boot project with Spring Rest, Spring Security, Spring Data JPA and Swagger API Interface.

## Get Started
To download the repository:

```bash
git clone https://bitbucket.org/VittorioValent/sample-rest.git
```

Then open the project and execute

```bash
mvn clean install
```

to build the project and

```bash
mvn spring-boot:run
```

to run the application.

## Usage
When the application is running, open [localhost](http://localhost:8081/swagger-ui.html) to open API full documentation.
You can also access the h2 console [here](http://localhost:8081/h2-console).

## Code Generation
When the application is running, you can dynamically generate an entire dataflow for a new entity: open swagger in Workshop Endpoint (secured by JWT) and call:

- GET method needs the Entity name (first capital letter)
- POST method allow you to define all fields you need (including field's type among your existing entities!)

You can decide if to secure or not your new entity (to secure put "auditable" TRUE). Have fun!

## Test
To test th application import the postman collection from src/test/postman/ and run it. For details see [Import Collection with Postman](https://kb.datamotion.com/?ht_kb=postman-instructions-for-exporting-and-importing)

## Built with
- [Maven](https://maven.apache.org/)

## Tools and Libraries
Here the list of libraries implemented/yet-to-implement in the project

- [Swagger](https://swagger.io)
- [Lombok](https://projectlombok.org)
- [MapStruct](https://mapstruct.org)
- [H2 DataBase](https://www.h2database.com/html/main.html)
- [Hibernate](https://hibernate.org/)
- [QueryDsl](http://www.querydsl.com/)
- [JUnit](https://junit.org/junit5/)
- [Postman](https://www.getpostman.com/)
- [JavaPoet](https://github.com/square/javapoet)

## Documentation
To see Javadoc documentation go to doc folder and open index.html

## TODOs
Something we still have to do...

- Write automatic tests with JUnit;
- Write full Javadoc documentation;
- Do some refactoring: there's always something to refactor!

## Authors
- Vittorio Valent
