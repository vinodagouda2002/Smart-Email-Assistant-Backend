# Stage 1: Build the Spring Boot application using Maven Wrapper
FROM maven:3.9.4-eclipse-temurin-17 AS builder

# Set working directory inside container
WORKDIR /app

# Copy project files to container
COPY . .

# Build the application (skip tests for faster build)
RUN ./mvnw clean package -DskipTests

# Stage 2: Run the Spring Boot app
FROM eclipse-temurin:17-jdk-alpine

# Set working directory
WORKDIR /app

# Copy the JAR file from the builder stage
COPY --from=builder /app/target/smart_Email_Assistance-1.jar app.jar

# Expose the default Spring Boot port
EXPOSE 8080

# Run the JAR file
ENTRYPOINT ["java", "-jar", "app.jar"]
