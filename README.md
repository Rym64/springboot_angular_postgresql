## MiniBlogSpringBoot
Simple implementation of  mini blog using Java Spring Boot v2.4.3 and java 8.

# Installation 
The project is created with Maven, so you just need to import it to your IDE and build the project to resolve the dependencies

# Database configuration 
Create a MariaDB database with the name `miniblogdb` and add the credentials to `/resources/application.properties`.  
The default ones are :

```
spring.datasource.url=jdbc:mariadb://localhost:3306/miniblogdb
spring.datasource.username=root
spring.datasource.password=
spring.jpa.hibernate.ddl-auto=update
```

# Usage 
Run the project through the IDE and head out to [http://localhost:8080](http://localhost:8080)

or 

fellow these steps:

```
1. Build the project using `mvn clean install`
2. Run using `mvn spring-boot:run`
3. The web application is accessible via localhost:8080
```