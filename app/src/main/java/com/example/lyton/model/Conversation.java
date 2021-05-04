package com.example.lyton.model;

import java.util.ArrayList;
import java.util.List;

public class Conversation {

    private String senderId;
    private String senderName;
    private String receiverName;
    private String receiverId;
    private String message;

    public Conversation(){}

    public Conversation(String senderName, String senderId, String receiverName,
                        String receiverId, String message) {
        this.senderName = senderName;
        this.senderId = senderId;
        this.receiverName = receiverName;
        this.receiverId = receiverId;
        this.message = message;
    }

    public String getSenderId() {
        return senderId;
    }

    public void setSenderId(String senderId) {
        this.senderId = senderId;
    }

    public String getReceiverId() {
        return receiverId;
    }

    public void setReceiverId(String receiverId) {
        this.receiverId = receiverId;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getSenderName() {
        return senderName;
    }

    public void setSenderName(String senderName) {
        this.senderName = senderName;
    }

    public String getReceiverName() {
        return receiverName;
    }

    public void setReceiverName(String receiverName) {
        this.receiverName = receiverName;
    }
}
