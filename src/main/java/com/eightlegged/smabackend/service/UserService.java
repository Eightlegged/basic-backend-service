package com.eightlegged.smabackend.service;

import java.util.List;

import com.eightlegged.smabackend.entity.Meeting;
import com.eightlegged.smabackend.entity.User;

/**
 * @author Kim Sae-Young(heehouse1@gmail.com)
 *
 * @FileName UserService.java
 * @Project smabackend
 * @Date 2017. 8. 10.
 */

public interface UserService {
	User findById(Long userId);
	User findByEmail(String email);
	User findByUsername(String username);
	String createUser(String username, String email, String password);
	String login(String email, String password);
	List<Meeting> meetingList_w(User user);
	List<Meeting> meetingList_c(User user);
}
