package com.longobuccodev.springmongodb.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.longobuccodev.springmongodb.domain.User;


public interface UserRepository extends MongoRepository<User, String>{

}
