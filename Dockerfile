# Stage 1: Build the application using Maven
FROM maven:3.9.6-eclipse-temurin-21 AS build

# Set working directory
WORKDIR /app

# Copy pom.xml and download dependencies
COPY smart_Email_Assistance/pom.xml smart_Email_Assistance/
RUN mvn -f smart_Email_Assistance/pom.xml dependency:go-offline

# Copy source code
COPY smart_Email_Assistance smart_Email_Assistance

# Build the Spring Boot application
RUN mvn -f smart_Email_Assistance/pom.xml clean package -DskipTests

# Stage 2: Run the application
FROM eclipse-temurin:21-jdk

# Set working directory
WORKDIR /app

# Copy the JAR file from the build stage
COPY --from=build /app/smart_Email_Assistance/target/smart_Email_Assistance-0.0.1-SNAPSHOT.jar app.jar

# Expose the port your Spring Boot app runs on
EXPOSE 8081

# Run the application
ENTRYPOINT ["java", "-jar", "app.jar"]
