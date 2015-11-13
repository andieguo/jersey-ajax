package com.andieguo.jersey.util;

import java.util.ArrayList;
import java.util.List;

import com.andieguo.jersey.bean.User;

import junit.framework.TestCase;

public class ObjectPersistenceTest extends TestCase{
	
	public void testSave(){
		List<User> users = new ArrayList<User>();
		users.add(new User("andy",22));
		users.add(new User("jack",12));
		ObjectPersistence.writeObjectToFile(users);
	}

	public void testRead(){
		List<User> users = (List<User>) ObjectPersistence.readObjectFromFile();
		System.out.println(users);
	}
	
	public void testAdd(){
		List<User> users = (List<User>) ObjectPersistence.readObjectFromFile();
		users.add(new User("posly",23));
		ObjectPersistence.writeObjectToFile(users);
	}
	
	public void testRemove(){
		List<User> users = (List<User>) ObjectPersistence.readObjectFromFile();
		users.remove(new User("posly",23));
		ObjectPersistence.writeObjectToFile(users);
	}
}
