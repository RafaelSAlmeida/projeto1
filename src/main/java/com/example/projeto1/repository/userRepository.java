package com.example.projeto1.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.example.projeto1.entity.User;

public interface userRepository extends MongoRepository<User, Long> {
	
	@Query("{'email': ?0}")
	User findByEmailQualquerCoisa(String email);
	
	User findByNameIgnoreCaseLike(String name);

}
