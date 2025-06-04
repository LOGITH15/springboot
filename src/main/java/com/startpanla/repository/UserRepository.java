package com.startpanla.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.startpanla.model.User;

public interface UserRepository extends MongoRepository<User, String>{

}
