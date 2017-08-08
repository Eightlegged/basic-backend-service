package com.eightlegged.smabackend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eightlegged.smabackend.entity.Role;
import com.eightlegged.smabackend.entity.User;
import com.eightlegged.smabackend.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;

	@Override
	public User findByEmail(String email) {
		User user = userRepository.findByEmail(email);
		return user;
	}

	@Override
	public User findByUsername(String username) {
		User user = userRepository.findByUserName(username);
		return user;
	}

	@Override
	public String createUser(String userName, String email, String password) {
		// Role 입력 받을 경우 - (String userName, String email, String Password, Role Role)
		if (findByEmail(email) == null && findByUsername(userName) == null) {
			User user = new User();
			user.setEmail(email);
			user.setName(userName);
			user.setPassword(password);
			user.setRole(Role.USER); // Master?
			// Role 입력받을 경우 - user.setRole(Role);
			userRepository.save(user);
			return "{\"result\": \"SUCCESS\"}";
		}
		return "{\"result\":\"FAIL\"}";
	}

	@Override
	public String login(String email, String password) {
		// TODO Auto-generated method stub
		User user = userRepository.findByEmail(email);
		if(user.getPassword() == password)
			return "{\"result\": \"SUCCESS\"}";
		return "{\"result\":\"FAIL\"}";
	}

	@Override
	public User findById(Long userId) {
		return userRepository.findOne(userId);
	}

}
