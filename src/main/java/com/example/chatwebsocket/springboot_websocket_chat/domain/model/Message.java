package com.example.chatwebsocket.springboot_websocket_chat.domain.model;

public class Message {

    private String text;
    private Long date;

    public String getText() {
        return text;
    }

    public void setText(String from) {
        this.text = from;
    }

    public Long getDate() {
        return date;
    }

    public void setDate(Long date) {
        this.date = date;
    }
}
