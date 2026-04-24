package com.whatsapp.chatbot.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class ChatbotService {

    private static final Logger logger = LoggerFactory.getLogger(ChatbotService.class);
    private final Map<String, String> responses;

    public ChatbotService() {
        // Initialize predefined responses
        responses = new HashMap<>();
        responses.put("hi", "Hello");
        responses.put("bye", "Goodbye");
        responses.put("hello", "Hello");
        responses.put("goodbye", "Goodbye");
    }

    /**
     * Process incoming message and generate appropriate response
     * @param message The incoming message text
     * @return The bot's response
     */
    public String processMessage(String message) {
        if (message == null || message.trim().isEmpty()) {
            return "I didn't receive any message. Please send something!";
        }

        String normalizedMessage = message.trim().toLowerCase();
        logger.info("Processing message: {}", message);

        // Check for predefined responses
        String response = responses.get(normalizedMessage);
        
        if (response != null) {
            logger.info("Found predefined response: {}", response);
            return response;
        }

        // Default response for unknown messages
        logger.info("No predefined response found, sending default reply");
        return "I don't understand that message. Try saying 'Hi' or 'Bye'!";
    }

    /**
     * Log incoming message details
     * @param from Sender identifier
     * @param message Message content
     * @param timestamp Message timestamp
     */
    public void logMessage(String from, String message, Long timestamp) {
        logger.info("=== Incoming Message ===");
        logger.info("From: {}", from);
        logger.info("Message: {}", message);
        logger.info("Timestamp: {}", timestamp);
        logger.info("========================");
    }
}
