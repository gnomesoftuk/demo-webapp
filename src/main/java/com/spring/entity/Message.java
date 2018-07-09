package com.spring.entity;

import org.springframework.data.annotation.Id;

import java.io.Serializable;

public class Message implements Serializable{
    @Id
    private String id;

    private String message;

    public Message(String id, String message) {

        this.id = id;
        this.message = message;
    }

    public String getId() {
        return id;
    }

    public String getMessage() {
        return message;
    }
}
