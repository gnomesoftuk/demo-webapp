package com.spring.config;

import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import com.spring.DataReceiver;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer;
import org.springframework.amqp.rabbit.listener.adapter.MessageListenerAdapter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by roger on 09/07/18.
 */
@Configuration
public class MQ {

    private static final String queueName = "hello";

    @Bean
    public Queue hello() {
        return new Queue(queueName);
    }

    @Bean
    public SimpleMessageListenerContainer container(ConnectionFactory connectionFactory, MessageListenerAdapter listenerAdapter) {
        SimpleMessageListenerContainer container = new SimpleMessageListenerContainer();
        container.setConnectionFactory(connectionFactory);
        container.setQueueNames(queueName);
        container.setMessageListener(listenerAdapter);
        return container;
    }

    @Bean
    public MessageListenerAdapter listenerAdapter(DataReceiver receiver) {
        return new MessageListenerAdapter(receiver, "receiveMessage");
    }
}
