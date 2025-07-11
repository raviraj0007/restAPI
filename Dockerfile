# Step 1: Build the application
FROM eclipse-temurin:17-jdk AS build

WORKDIR /app

COPY . .

RUN chmod +x ./gradlew

# ✅ Build without running tests
RUN ./gradlew build -x test

# Step 2: Package only the JAR
FROM eclipse-temurin:17-jdk

WORKDIR /app

COPY --from=build /app/build/libs/restAPI-0.0.1-SNAPSHOT.jar app.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "app.jar"]
