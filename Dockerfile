# Use an official OpenJDK image
FROM eclipse-temurin:17-jdk

# Set working directory
WORKDIR /app

# Copy the JAR built by Gradle
COPY build/libs/restAPI-0.0.1-SNAPSHOT.jar app.jar

# Expose port (optional)
EXPOSE 8082

# Run the app
ENTRYPOINT ["java", "-jar", "app.jar"]
