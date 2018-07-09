package com.spring;

import com.spring.entity.Message;
import com.spring.repository.DataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DataReceiver {

    @Autowired
    private DataRepository dataRepository;

    public void receiveMessage(Message message) {
        System.out.println("Received message : " + message.getId());
        dataRepository.save(message);
        System.out.println("Written message " + message.getId() + " to mongo!");
    }

}
