# Step 1: Build the application
FROM eclipse-temurin:17-jdk AS build

WORKDIR /app

# Copy everything to /app
COPY . .

# Give permission to gradlew
RUN chmod +x ./gradlew

# Build the app using Gradle
RUN ./gradlew build

# Step 2: Package only the jar
FROM eclipse-temurin:17-jdk

WORKDIR /app

# Copy the built JAR from the previous stage
COPY --from=build /app/build/libs/restAPI-0.0.1-SNAPSHOT.jar app.jar

EXPOSE 8080

# Start the app
ENTRYPOINT ["java", "-jar", "app.jar"]
