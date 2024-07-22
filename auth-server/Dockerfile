# Authorization Server Dockerfile
FROM openjdk:17-jdk-alpine

COPY target/auth-server-0.0.1-SNAPSHOT.jar auth-server.jar

ENTRYPOINT ["java","-jar","/auth-server.jar"]