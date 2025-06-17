# Stage 1: Build the application
FROM maven:3.8.1-openjdk-17 AS builder
 
# Set the working directory inside the container
WORKDIR /app
 
# Copy the pom.xml and download dependencies
COPY pom.xml .
RUN mvn dependency:go-offline -B
 
# Copy the rest of the application source code and build the application
COPY src ./src
RUN mvn clean package -DskipTests
 
# Stage 2: Create the runtime image
FROM openjdk:17
 
# Set the working directory inside the container
WORKDIR /app
 
# Copy the built jar file from the build stage
<<<<<<< HEAD
COPY --from=builder /app/target/*.war demo.war
=======
COPY --from=builder /app/target/*.jar demo.jar
>>>>>>> b5ba2ffc27777d2c115ee99d8d44a3daf8076b8d
 
# Expose the application port
EXPOSE 9093:8080
 
# Define the entrypoint to run the application
<<<<<<< HEAD
ENTRYPOINT ["java", "-jar", "demo.war"] 
=======
ENTRYPOINT ["java", "-jar", "demo.jar"]
>>>>>>> b5ba2ffc27777d2c115ee99d8d44a3daf8076b8d
