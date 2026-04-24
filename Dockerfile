# Stage 1: Build
FROM maven:3.9.9-eclipse-temurin-17 AS build
WORKDIR /app
COPY pom.xml .
COPY src ./src
RUN mvn clean package -DskipTests

# Stage 2: Run
FROM eclipse-temurin:17-jre
WORKDIR /app
COPY --from=build /app/target/chatbot-1.0.0.jar app.jar
CMD ["sh", "-c", "java -Xms64m -Xmx256m -XX:TieredStopAtLevel=1 -jar app.jar --server.port=${PORT:-8080}"]
