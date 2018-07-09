package com.spring;

import com.spring.entity.Message;
import com.spring.repository.DataRepository;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class DataController {

    @Autowired
    private RabbitTemplate template;

    @Autowired
    @Qualifier("hello")
    private Queue queue;

    @RequestMapping(value = "/message/{id}", method = RequestMethod.POST, consumes = MediaType.TEXT_PLAIN_VALUE)
    public ResponseEntity postData(@PathVariable String id, @RequestBody String payload) {
        System.out.println("POST Request received : " + id + " with payload : " + payload);
        this.template.convertAndSend(queue.getName(), new Message(id, payload));
        System.out.println("Message sent!");
        return ResponseEntity.status(HttpStatus.OK).build();
    }
}
