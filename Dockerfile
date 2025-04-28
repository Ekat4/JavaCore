
FROM openjdk:21.0.5-jdk-slim-buster
ARG JAR_FILE=target/spring-boot-docker-example-0.0.1-SNAPSHOT.jar
WORKDIR /opt/app
COPY ${JAR_FILE} app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]

FROM openjdk:17.0.2-jdk-slim-buster


