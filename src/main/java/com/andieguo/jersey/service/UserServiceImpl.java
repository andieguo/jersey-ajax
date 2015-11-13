package com.andieguo.jersey.service;

import java.util.List;
import com.andieguo.jersey.bean.User;
import com.andieguo.jersey.util.ObjectPersistence;

@SuppressWarnings("unchecked")
public class UserServiceImpl implements UserService {

	public List<User> findUsers() {
		// TODO Auto-generated method stub
		
		List<User> users = (List<User>) ObjectPersistence.readObjectFromFile();
		return users;
	}

	public User findUser(String uname) {
		// TODO Auto-generated method stub
		List<User> users = (List<User>) ObjectPersistence.readObjectFromFile();
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
		List<User> users = (List<User>) ObjectPersistence.readObjectFromFile();
		if(users.add(user)){
			return ObjectPersistence.writeObjectToFile(users);
		}else{
			return false;
		}
	}

	public boolean deleteUser(User user) {
		// TODO Auto-generated method stub
		List<User> users = (List<User>) ObjectPersistence.readObjectFromFile();
		if(users.remove(user)){
			return ObjectPersistence.writeObjectToFile(users);
		}else{
			return false;
		}
	}

}
