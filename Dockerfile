FROM maven:3.9.9-eclipse-temurin-17
WORKDIR /app
COPY pom.xml .
COPY src ./src
RUN mvn clean package -DskipTests
EXPOSE 8080
CMD ["sh", "-c", "java -Xms64m -Xmx256m -jar target/chatbot-1.0.0.jar --server.port=${PORT:-8080}"]
