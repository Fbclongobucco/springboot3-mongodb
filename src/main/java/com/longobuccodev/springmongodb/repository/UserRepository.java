package com.longobuccodev.springmongodb.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.longobuccodev.springmongodb.domain.User;

@Repository
public interface UserRepository extends MongoRepository<User, String>{

}
