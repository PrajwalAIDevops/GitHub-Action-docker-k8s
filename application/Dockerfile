# Stage 1: Build the Application
FROM maven:3.9.6-eclipse-temurin-17-alpine AS builder
WORKDIR /app

COPY pom.xml .
COPY src ./src

RUN mvn clean package -DskipTests

# Stage 2: Minimal Runtime Environment
FROM eclipse-temurin:17-jre-alpine
WORKDIR /app

RUN addgroup -S javasys && adduser -S javauser -G javasys

# Copy only the executable fat-JAR (ignoring *.original files)
COPY --from=builder /app/target/school-website-1.0.0.jar app.jar

RUN chown -R javauser:javasys /app
USER javauser

EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]
