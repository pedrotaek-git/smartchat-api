package com.smartchat.dto;

public class ChatMessageRequest {
    private String sender;
    private String message;

    public ChatMessageRequest() {
    }

    public ChatMessageRequest(String sender, String message) {
        this.sender = sender;
        this.message = message;
    }

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
