package com.andieguo.jersey.service.test;

import com.andieguo.jersey.bean.User;
import com.andieguo.jersey.service.UserService;
import com.andieguo.jersey.service.UserServiceImpl;

import junit.framework.TestCase;

public class UserServiceTest extends TestCase
{

	private UserService userService ;
	@Override
	protected void setUp() throws Exception {
		// TODO Auto-generated method stub
		super.setUp();
		userService = new UserServiceImpl();
	}

	public void testAdd(){
		userService.addUser(new User("rose",20));
	}
	
	public void testDelete(){
		userService.deleteUser(new User("rose",20));
	}
	
	public void testFindUsers(){
		for(User user:userService.findUsers()){
			System.out.println(user);
		}
	}
	
	public void testFindUser(){
		System.out.println(userService.findUser("andy"));
	}
}
