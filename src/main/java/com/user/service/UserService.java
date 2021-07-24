package com.user.service;

import java.util.List;

import com.user.entity.User;

public interface UserService {
	
	public User  getUser(Long id);
	
	List getAllEmployee();

	User addnewUser(User user);

	void updateUser(User user) throws Exception;

	void deleteUser(Long userid) throws Exception;

	

}
