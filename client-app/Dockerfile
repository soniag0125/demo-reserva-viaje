# Authorization Server Dockerfile
FROM openjdk:17-jdk-alpine

COPY target/client-app-0.0.1-SNAPSHOT.jar client-app.jar

ENTRYPOINT ["java","-jar","/client-app.jar"]