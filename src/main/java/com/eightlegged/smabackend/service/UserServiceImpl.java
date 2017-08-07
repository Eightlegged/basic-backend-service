package com.eightlegged.smabackend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
	public ResponseEntity<String> createUser(String userName, String email, String password) {
		// Role 입력 받을 경우 - (String userName, String email, String Password, Role Role)
		if (findByEmail(email) == null && findByUsername(userName) == null) {
			User user = new User();
			user.setEmail(email);
			user.setName(userName);
			user.setPassword(password);
			user.setRole(Role.USER); // Master?
			// Role 입력받을 경우 - user.setRole(Role);
			userRepository.save(user);
			return new ResponseEntity<String>("{\"message\": \"SUCCESS\"}", HttpStatus.CREATED);
		}
		return new ResponseEntity<String>("{\"message\":\"FAIL\"}", HttpStatus.BAD_REQUEST);
	}

	@Override
	public ResponseEntity<String> login(String email, String password) {
		// TODO Auto-generated method stub
		User user = userRepository.findByEmail(email);
		if(user.getPassword() == password)
			return new ResponseEntity<String>("{\"message\": \"SUCCESS\"}", HttpStatus.OK);
		return new ResponseEntity<String>("{\"message\":\"FAIL\"}", HttpStatus.BAD_REQUEST);
	}

	@Override
	public User findById(Long userId) {
		return userRepository.findOne(userId);
	}

}
