package com.whatsapp.chatbot.model;

public class WhatsAppResponse {

    private String to;
    private String reply;
    private Long timestamp;
    private String status;

    public WhatsAppResponse() {}

    public WhatsAppResponse(String to, String reply, Long timestamp, String status) {
        this.to = to;
        this.reply = reply;
        this.timestamp = timestamp;
        this.status = status;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public String getReply() {
        return reply;
    }

    public void setReply(String reply) {
        this.reply = reply;
    }

    public Long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Long timestamp) {
        this.timestamp = timestamp;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "WhatsAppResponse{to='" + to + "', reply='" + reply + "', timestamp=" + timestamp + ", status='" + status + "'}";
    }
}
