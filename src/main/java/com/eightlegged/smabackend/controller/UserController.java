package com.eightlegged.smabackend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.ResponseEntity;

import com.eightlegged.smabackend.service.UserService;

@RestController
public class UserController {

	@Autowired
	UserService userservice;
	
	@RequestMapping(
			value="/user/add", method=RequestMethod.POST, 
			consumes= {MediaType.APPLICATION_JSON_VALUE},
			produces= {MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<String> createUser(){
		return null;
	}
	
}
