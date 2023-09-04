FROM eclipse-temurin:17
LABEL authors="asanka"
WORKDIR /app
COPY build/libs/springboot-restful-webservices-1.0.0-SNAPSHOT.jar /app/springboot-restful-webservices.jar
ENTRYPOINT ["java", "-jar", "springboot-restful-webservices.jar"]