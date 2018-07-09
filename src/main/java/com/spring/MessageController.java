package com.spring;

import com.spring.entity.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class MessageController {

    @Autowired
    private MessageService messageService;

    @RequestMapping(value = "/message/{id}", method = RequestMethod.POST, consumes = MediaType.TEXT_PLAIN_VALUE)
    public ResponseEntity postMessage(@PathVariable String id, @RequestBody String payload) {
        System.out.println("POST Request received : " + id + " with payload : " + payload);
        messageService.save(new Message(id, payload));
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @RequestMapping(value = "/message/{id}", method = RequestMethod.GET, produces = MediaType.TEXT_PLAIN_VALUE)
    public ResponseEntity getMessage(@PathVariable String id) {
        System.out.println("GET Request received : " + id);

        return messageService.fetch(id)
                .map(message -> ResponseEntity.ok(message.getBody()))
                .orElse(ResponseEntity.notFound().build());
    }
}
