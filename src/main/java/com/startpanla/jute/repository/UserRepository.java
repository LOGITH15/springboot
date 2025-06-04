package com.startpanla.jute.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.startpanla.jute.model.User;
public interface UserRepository extends MongoRepository<User, String>{

}
