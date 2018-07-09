package com.spring.entity;

import org.springframework.data.annotation.Id;

import java.io.Serializable;

public class Message implements Serializable{
    @Id
    private String id;

    private String body;

    public Message(String id, String body) {

        this.id = id;
        this.body = body;
    }

    public String getId() {
        return id;
    }

    public String getBody() {
        return body;
    }

    @Override
    public String toString() {
        return "Message{" +
                "id='" + id + '\'' +
                ", body='" + body + '\'' +
                '}';
    }
}
