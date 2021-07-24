package com.hby.service;

import java.util.List;

import com.hby.pojo.User;

public interface UserService {
	//增删改查用户
	User queryUserById(Integer id);
	List<User> queryUserByName(String name);
	List<User> queryAllUsers();

	int addUser(User user);
	
	int deleteUser(Integer id);
	
	int updateUser(User user);
}
