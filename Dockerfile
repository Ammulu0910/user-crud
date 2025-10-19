# Step 1: Use official OpenJDK image
FROM openjdk:17-jdk-slim

# Step 2: Set working directory inside the container
WORKDIR /app

# Step 3: Copy the built JAR file into the container
COPY target/user-crud-1.0.0.jar app.jar

# Step 4: Expose the port Spring Boot uses
EXPOSE 8080

# Step 5: Run the app
ENTRYPOINT ["java", "-jar", "app.jar"]
