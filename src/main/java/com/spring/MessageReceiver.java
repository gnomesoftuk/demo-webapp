package com.spring;

import com.spring.entity.Message;
import com.spring.repository.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MessageReceiver {

    @Autowired
    private MessageRepository messageRepository;

    public void receiveMessage(Message message) {
        System.out.println("Received message : " + message.getId());
        messageRepository.save(message);
        System.out.println("Written message " + message.getId() + " to mongo!");
    }

}
