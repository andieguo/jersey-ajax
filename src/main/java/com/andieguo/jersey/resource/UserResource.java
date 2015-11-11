package com.andieguo.jersey.resource;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;

import com.andieguo.jersey.bean.Message;
import com.andieguo.jersey.bean.User;
import com.andieguo.jersey.service.UserService;
import com.andieguo.jersey.service.UserServiceImpl;

@Path("/user")
public class UserResource {

	private UserService userService = new UserServiceImpl();

	@GET
	@Path("/print")
	@Produces(MediaType.TEXT_PLAIN)
	public String toString() {
		return new User("banana", 10).toString();
	}
	
	@GET
	@Path("/findUsers")
	@Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	public List<User> findUsers(){
		return userService.findUsers();
	}

	@GET
	@Path("/findUser/{name}/")
	@Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	public User findUser(@PathParam("name") String name){
		return userService.findUser(name);
	}

	@POST
	@Path("/add")
	@Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	public Message add(@FormParam(value = "name") String name, @FormParam(value = "age") Integer age) {
		System.out.println("name:" + name);
		System.out.println("age:" + age);
		boolean status = userService.addUser(new User(name, age));
		if(status){
			return new Message(true, "add successfully");
		}else{
			return new Message(false, "add failly");
		}
	}

	@GET
	@Path("/delete")
	@Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	public Message delete(@Context HttpServletRequest request) {
		String name = request.getParameter("name");
		Integer age = Integer.valueOf(request.getParameter("age"));
		System.out.println("name:" + name);
		System.out.println("age:" + age);
		System.out.println("request:" + request.getQueryString());
		boolean status = userService.deleteUser(new User(name, age));
		if(status){
			return new Message(true, "delete successfully");
		}else{
			return new Message(false, "delete failly");
		}
	}
}
