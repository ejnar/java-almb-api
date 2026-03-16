# java-almb-api

Test project for SPring Booot app(Docker, OpenApi)

## Start application

How to Run

Enable annotation processing in IntelliJ:
Preferences → Build, Execution, Deployment → Compiler → Annotation Processors → Enable

Generate OpenAPI classes:
mvn clean compile

Generate OpenAPI code + compile:
mvn clean install

Run Spring Boot locally:
mvn spring-boot:run

Run Docker:
docker compose up --build

Swagger UI:
http://localhost:8080/swagger-ui/index.html

H2 Console:
http://localhost:8080/h2-console

Health check:
http://localhost:8080/actuator/health

Metrics:
http://localhost:8080/actuator/metrics

Info:
http://localhost:8080/actuator/info

Improvment:
Add mockito lib for unit testing








