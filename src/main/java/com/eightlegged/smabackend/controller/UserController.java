package com.eightlegged.smabackend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.eightlegged.smabackend.entity.User;
import com.eightlegged.smabackend.service.UserService;


@RestController
public class UserController {

	@Autowired
	UserService userservice;
	
	@RequestMapping(
			value="/user/add", method=RequestMethod.POST, 
			consumes= {MediaType.APPLICATION_JSON_VALUE},
			produces= {MediaType.APPLICATION_JSON_VALUE})
	public Boolean createUser(@RequestBody User user){
		return userservice.createUser(user.getUserName(), user.getEmail(),user.getPassword());
	}
	
	@RequestMapping(
			value="/user/login",
			method=RequestMethod.POST,
			consumes={MediaType.APPLICATION_JSON_VALUE},
			produces={MediaType.APPLICATION_JSON_VALUE})
	public Boolean login(@RequestBody User user){
		return userservice.login(user.getEmail(), user.getPassword());
	}

}
