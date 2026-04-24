# WhatsApp Chatbot Backend Simulation

A simple Spring Boot REST API that simulates a WhatsApp chatbot backend.

## Features

- REST API endpoint (`/webhook`) to receive POST requests
- Accepts JSON input simulating WhatsApp messages
- Predefined responses:
  - "Hi" → "Hello"
  - "Bye" → "Goodbye"
- Logs all incoming messages
- Health check endpoint

## Requirements

- Java 22
- Maven 3.9+
- Spring Boot 3.2.5

## Project Structure

```
whatsapp-chatbot/
├── src/
│   └── main/
│       ├── java/com/whatsapp/chatbot/
│       │   ├── WhatsAppChatbotApplication.java
│       │   ├── controller/
│       │   │   └── WebhookController.java
│       │   ├── service/
│       │   │   └── ChatbotService.java
│       │   └── model/
│       │       ├── WhatsAppMessage.java
│       │       └── WhatsAppResponse.java
│       └── resources/
│           └── application.properties
├── pom.xml
└── README.md
```

## Running the Application

1. Build the project:
```bash
mvn clean install
```

2. Run the application:
```bash
mvn spring-boot:run
```

The server will start on `http://localhost:8080`

## API Endpoints

### 1. Webhook Endpoint (POST)

**URL:** `http://localhost:8080/webhook`

**Method:** POST

**Request Body:**
```json
{
  "from": "+1234567890",
  "message": "Hi",
  "timestamp": 1714000000000
}
```

**Response:**
```json
{
  "to": "+1234567890",
  "reply": "Hello",
  "timestamp": 1714000000123,
  "status": "sent"
}
```

### 2. Health Check (GET)

**URL:** `http://localhost:8080/webhook/health`

**Method:** GET

**Response:** `WhatsApp Chatbot is running!`

## Testing with cURL

### Send "Hi" message:
```bash
curl -X POST http://localhost:8080/webhook \
  -H "Content-Type: application/json" \
  -d "{\"from\":\"+1234567890\",\"message\":\"Hi\",\"timestamp\":1714000000000}"
```

### Send "Bye" message:
```bash
curl -X POST http://localhost:8080/webhook \
  -H "Content-Type: application/json" \
  -d "{\"from\":\"+1234567890\",\"message\":\"Bye\",\"timestamp\":1714000000000}"
```

### Health check:
```bash
curl http://localhost:8080/webhook/health
```

## Testing with PowerShell

### Send "Hi" message:
```powershell
Invoke-RestMethod -Uri "http://localhost:8080/webhook" `
  -Method POST `
  -ContentType "application/json" `
  -Body '{"from":"+1234567890","message":"Hi","timestamp":1714000000000}'
```

### Send "Bye" message:
```powershell
Invoke-RestMethod -Uri "http://localhost:8080/webhook" `
  -Method POST `
  -ContentType "application/json" `
  -Body '{"from":"+1234567890","message":"Bye","timestamp":1714000000000}'
```

## Logs

All incoming messages are logged with details:
- Sender information
- Message content
- Timestamp
- Processing status

Check the console output to see the logs when messages are received.

## Extending the Bot

To add more predefined responses, edit the `ChatbotService` constructor:

```java
responses.put("your-message", "Your Response");
```

## License

MIT
