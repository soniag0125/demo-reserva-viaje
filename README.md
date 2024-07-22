# demo-reserva-viaje

 Proyecto para reserva de vuelos


# Reserva de viajes

Proyecto para reserva de viajes

- Crear vuelos
- Listar vuelos
- Crear reserva
- Actualizar reserva
- Listar reservas
- Pagar reserva
- Enviar notificación

# Autorización

Demo individual para probar autorización de acceso a APIs de reserva.

- Generación de token por aplicación registrada

# Cliente Autorización

Proyecto demo para pruebas de funcionamiento de servicio de autorización

- Servicio autenticado de reserva de vuelo

# Tecnologías
- Clean Architecture
- SpringBoot 3.3.2
- Maven
- Postgres
- JUnit
- Docker
- OAuth2.0

## Autor

- [@soniag0125](https://github.com/soniag0125)

## Configuration
Spring Boot 3.3.2 (https://start.spring.io/), maven y Java 17.

Para levantar la aplicación de reserva de viajes:

- Descargar la rama main del proyecto completo.
- Para empaquetar, abrir una consola con la ubicación de los proyecto book-trip y otra con auth-server y ejecutar el comando`mvn clean package -DskipTests`
- Para Ejecutar el proyecto  desde una consola en la raiz del proyecto global  `docker compose build` y luego `docker-compose up`

Para levantar la aplicación demo de reserva de viajes con autorización:

- Descargar la rama main del proyecto completo.
- Para empaquetar, abrir una consola con la ubicación de los proyecto book-trip y otra con auth-server y ejecutar el comando`mvn clean package -DskipTests`
- Para Ejecutar el proyecto  desde una consola en la raiz del proyecto global `docker compose build` y luego `docker-compose up`
- Para levantar la aplicación demo en una consola con la ubicación del proyecto client-app y ejecutar  mvn clean install y luego mvn spring-boot:run


