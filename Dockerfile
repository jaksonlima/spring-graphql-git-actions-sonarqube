FROM openjdk:17-jdk-alpine as buildOne

WORKDIR /app

COPY /build/libs/*SNAPSHOT.jar app.jar

ENTRYPOINT [ "java", "-jar", "app.jar" ]