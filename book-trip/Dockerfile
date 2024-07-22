
FROM openjdk:17-jdk-alpine

COPY target/book-trips-0.0.1-SNAPSHOT.jar book-trip.jar

# Comando para ejecutar la aplicación cuando se inicie el contenedor
ENTRYPOINT ["java", "-jar", "book-trip.jar"]
