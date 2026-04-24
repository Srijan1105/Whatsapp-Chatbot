package com.whatsapp.chatbot.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.whatsapp.chatbot.model.WhatsAppMessage;
import com.whatsapp.chatbot.model.WhatsAppResponse;
import com.whatsapp.chatbot.service.ChatbotService;

@RestController
@RequestMapping("/webhook")
public class WebhookController {

    private static final Logger logger = LoggerFactory.getLogger(WebhookController.class);

    @Autowired
    private ChatbotService chatbotService;

    /**
     * Webhook endpoint to receive WhatsApp messages
     * @param message The incoming WhatsApp message
     * @return Response with bot's reply
     */
    @PostMapping
    public ResponseEntity<WhatsAppResponse> receiveMessage(@RequestBody WhatsAppMessage message) {
        try {
            logger.info("Received webhook request from: {}", message.getFrom());

            // Log the incoming message
            chatbotService.logMessage(
                message.getFrom(),
                message.getMessage(),
                message.getTimestamp()
            );

            // Process the message and get response
            String reply = chatbotService.processMessage(message.getMessage());

            // Create response object
            WhatsAppResponse response = new WhatsAppResponse(
                message.getFrom(),
                reply,
                System.currentTimeMillis(),
                "sent"
            );

            logger.info("Sending response: {}", reply);
            return ResponseEntity.ok(response);

        } catch (Exception e) {
            logger.error("Error processing webhook request", e);
            
            WhatsAppResponse errorResponse = new WhatsAppResponse(
                message != null ? message.getFrom() : "unknown",
                "Sorry, an error occurred while processing your message.",
                System.currentTimeMillis(),
                "error"
            );
            
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(errorResponse);
        }
    }

    /**
     * Health check endpoint
     * @return Simple status message
     */
    @GetMapping("/health")
    public ResponseEntity<String> health() {
        return ResponseEntity.ok("WhatsApp Chatbot is running!");
    }
}
