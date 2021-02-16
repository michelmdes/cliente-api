FROM openjdk:13

WORKDIR /app

COPY target/cliente-api-0.0.1-SNAPSHOT.jar /app/cliente-api.jar

ENTRYPOINT ["java", "-jar", "cliente-api.jar"]