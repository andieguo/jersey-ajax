package com.andieguo.jersey.service;

import java.util.List;

import com.andieguo.jersey.bean.User;

public interface UserService {

	public List<User> findUsers();
	
	public User findUser(String uname);
	
	public void updateUser(User user);
	
	public boolean addUser(User user);
	
	public boolean deleteUser(User user);
	
}
