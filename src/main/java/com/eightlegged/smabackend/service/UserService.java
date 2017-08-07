package com.eightlegged.smabackend.service;

import org.springframework.http.ResponseEntity;

import com.eightlegged.smabackend.entity.User;

public interface UserService {
	User findById(Long userId);
	User findByEmail(String email);
	User findByUsername(String username);
	ResponseEntity<String> createUser(String username, String email, String password);
	ResponseEntity<String> login(String email, String password);
}
