# Stage 1: Build the Spring Boot application using Maven Wrapper
FROM maven:3.9.4-eclipse-temurin-17 AS builder

WORKDIR /app
COPY . .

# Build the application (skip tests for faster build)
RUN ./mvnw clean package -DskipTests

# Stage 2: Run the Spring Boot app
FROM eclipse-temurin:17-jdk-alpine

WORKDIR /app

# ✅ Fixed line below
COPY --from=builder /app/target/smart_Email_Assistance-1.jar app.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "app.jar"]
