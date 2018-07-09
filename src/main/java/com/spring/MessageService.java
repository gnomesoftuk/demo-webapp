package com.spring;

import com.spring.entity.Message;
import com.spring.repository.MessageRepository;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class MessageService {

    @Autowired
    private RabbitTemplate template;

    @Autowired
    private MessageRepository messageRepository;

    @Autowired
    @Qualifier("messageQueue")
    private Queue queue;

    public void save(Message message) {
        this.template.convertAndSend(queue.getName(), message);
        System.out.println("Message sent!");
    }

    public Optional<Message> fetch(String id) {
        return this.messageRepository.findById(id);
    }
}
