FROM maven:3.9.9-eclipse-temurin-17
WORKDIR /app
COPY pom.xml .
COPY src ./src
RUN mvn clean package -DskipTests
CMD ["sh", "-c", "java -Xms64m -Xmx256m -jar /app/target/chatbot-1.0.0.jar --server.port=$PORT"]
