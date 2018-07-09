package com.spring.repository;


import com.spring.entity.Message;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface DataRepository extends MongoRepository<Message, String> {

}
