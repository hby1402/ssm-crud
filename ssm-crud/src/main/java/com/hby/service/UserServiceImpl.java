package com.hby.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hby.dao.UserMapper;
import com.hby.pojo.User;
@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserMapper userMapper;
	
	@Override
	public User queryUserById(Integer id) {
		return userMapper.queryUserById(id);
	}

	@Override
	public List<User> queryUserByName(String name) {
		List<User> list = userMapper.queryUserByName(name);
		return list;
	}

	@Override
	public List<User> queryAllUsers() {
		return userMapper.queryAllUsers();
	}

	@Override
	public int addUser(User user) {
		return userMapper.addUser(user);
	}

	@Override
	public int deleteUser(Integer id) {
		return userMapper.deleteUser(id);
	}

	@Override
	public int updateUser(User user) {
		return userMapper.updateUser(user);
	}

}
