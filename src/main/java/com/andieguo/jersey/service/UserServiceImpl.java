package com.andieguo.jersey.service;

import java.util.ArrayList;
import java.util.List;

import com.andieguo.jersey.bean.User;

public class UserServiceImpl implements UserService {

	private static List<User> users = new ArrayList<User>();
	static{
		users.add(new User("andy",29));
		users.add(new User("jack",39));
		users.add(new User("blue",19));
	}
	
	public List<User> findUsers() {
		// TODO Auto-generated method stub
		return users;
	}

	public User findUser(String uname) {
		// TODO Auto-generated method stub
		for(User user:users){
			if(user.getName().equals(uname)) return user;
		}
		return null;
	}

	public void updateUser(User user) {
		// TODO Auto-generated method stub
		
	}

	public boolean addUser(User user) {
		// TODO Auto-generated method stub
		return users.add(user);
	}

	public boolean deleteUser(User user) {
		// TODO Auto-generated method stub
		return users.remove(user);
	}

}
