package com.example.chatwebsocket.springboot_websocket_chat.adapter.in;

import com.example.chatwebsocket.springboot_websocket_chat.domain.model.Message;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

import java.util.Date;

@Controller
public class ChatController {

    @MessageMapping("/message")
    @SendTo("/topic/message") //all users notified messages
    public Message receiveMessage(Message message) {
        message.setDate(new Date().getTime());
        message.setText("Mensaje recibido: " + message.getText());
        return message;
    }

}
