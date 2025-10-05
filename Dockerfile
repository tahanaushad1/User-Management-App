# Step 1: Use OpenJDK image
FROM openjdk:17-jdk-slim

# Step 2: Set working directory
WORKDIR /app

# Step 3: Copy JAR file to container
COPY target/User-Management-App-0.0.1-SNAPSHOT.jar app.jar/User-Management-App

# Step 4: Expose port
EXPOSE 8080

# Step 5: Run the application
ENTRYPOINT ["java", "-jar", "User-Management-App"]

