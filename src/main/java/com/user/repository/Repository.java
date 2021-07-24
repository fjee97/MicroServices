package com.user.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.user.entity.User;

public interface Repository extends MongoRepository<User, Long>{
	
	public List<User> findByName(String name);
	public List<User> findBycontact(String contact);
	public List<User> findByUserId(Long userId);

}
