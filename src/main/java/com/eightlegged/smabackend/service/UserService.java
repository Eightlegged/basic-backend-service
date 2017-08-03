package com.eightlegged.smabackend.service;

import com.eightlegged.smabackend.entity.User;

public interface UserService {
	User findById(Long userId);
	User findByEmail(String email);
	User findByUsername(String username);
	Boolean createUser(String username, String email, String password);
	Boolean login(String email, String password);
}
