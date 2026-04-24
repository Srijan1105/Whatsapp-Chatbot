package com.whatsapp.chatbot.model;

public class WhatsAppMessage {

    private String from;
    private String message;
    private Long timestamp;

    public WhatsAppMessage() {}

    public WhatsAppMessage(String from, String message, Long timestamp) {
        this.from = from;
        this.message = message;
        this.timestamp = timestamp;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Long timestamp) {
        this.timestamp = timestamp;
    }

    @Override
    public String toString() {
        return "WhatsAppMessage{from='" + from + "', message='" + message + "', timestamp=" + timestamp + "}";
    }
}
