package com.example.lyton.model;


public class Messages {

    private String messageText;
    private String myName;
    private String receiver;

    public Messages(String messageText, String myName, String receiver) {
        this.messageText = messageText;
        this.myName = myName;
        this.receiver = receiver;
    }

    public Messages(){

    }

    public String getMyName() {
        return myName;
    }

    public void setMyName(String myName) {
        this.myName = myName;
    }

    public String getReceiver() {
        return receiver;
    }

    public void setReceiver(String receiver) {
        this.receiver = receiver;
    }

    public String getMessageText() {
        return messageText;
    }

    public void setMessageText(String messageText) {
        this.messageText = messageText;
    }
}
