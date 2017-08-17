package com.eightlegged.smabackend.service;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eightlegged.smabackend.entity.Meeting;
import com.eightlegged.smabackend.entity.Partname;
import com.eightlegged.smabackend.entity.Role;
import com.eightlegged.smabackend.entity.Status;
import com.eightlegged.smabackend.entity.User;
import com.eightlegged.smabackend.repository.UserRepository;

/**
 * @author Kim Sae-Young(heehouse1@gmail.com)
 *
 * @FileName UserServiceImpl.java
 * @Project smabackend
 * @Date 2017. 8. 10.
 */

@Service
public class UserServiceImpl implements UserService {

	private static final Logger logger = LoggerFactory.getLogger(MeetingServiceImpl.class);

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
	public String createUser(String userName, String email, String password, Partname partname) {
		// Role 입력 받을 경우 - (String userName, String email, String Password, Role Role)
		if (findByEmail(email) == null && findByUsername(userName) == null) {
			User user = new User();
			user.setEmail(email);
			user.setName(userName);
			user.setPassword(password);
			user.setRole(Role.USER); // Master?
			// Role 입력받을 경우 - user.setRole(Role);
			if(partname != null) {
			user.setPartName(partname);
			}else {
				user.setPartName(Partname.Communication);
			}
			userRepository.saveAndFlush(user);
			logger.info("User Created! User ID: " + user.getId());
			return "{\"result\": \"SUCCESS\", \"USER_ID\":\"" + user.getId() + "\"}";
		} else if (findByEmail(email) != null && findByUsername(userName) == null) {
			return "{\"result\":\"FAIL\", \"reason\":\"EMAIL Already Used\"}";
		} else if (findByUsername(userName) != null && findByEmail(email) == null) {
			return "{\"result\":\"FAIL\", \"reason\":\"Name Already Used\"}";
		}
		return "{\"result\":\"FAIL\", \"reason\":\"EMAIL & Name Already Used\"}";
	}

	@Override
	public String login(String email, String password) {
		// TODO Auto-generated method stub
		User user = userRepository.findByEmail(email);
		System.out.println(user.getMeetingList().size());
		for (int i = 0; i < user.getMeetingList().size(); i++) {
			System.out.println(user.getMeetingList().get(i).getTitle());
		}

		if (user.getPassword().equals(password))
			return "{\"result\": \"SUCCESS\",\"USER_ID\":\""+ user.getId() +"\"}";
		return "{\"result\":\"FAIL\"}";
	}

	@Override
	public User findById(Long userId) {
		return userRepository.findOne(userId);
	}

	@Override
	public List<Meeting> meetingList_w(User user) {
		// TODO Auto-generated method stub
		List<Meeting> meetinglist = user.getMeetingList();
		List<Meeting> meetinglist_w = new ArrayList<Meeting>();

		if (meetinglist != null) {
			for (int i = 0; i < meetinglist.size(); i++) {
				if (meetinglist.get(i).getStatus().equals(Status.WAIT)) {
					meetinglist_w.add(meetinglist.get(i));
				}
			}
		}
		return meetinglist_w;
	}

	@Override
	public List<Meeting> meetingList_c(User user) {
		// TODO Auto-generated method stub
		List<Meeting> meetinglist = user.getMeetingList();
		List<Meeting> meetinglist_w = new ArrayList<Meeting>();

		if (meetinglist != null) {
			for (int i = 0; i < meetinglist.size(); i++) {
				if (meetinglist.get(i).getStatus().equals(Status.COMPLETE)) {
					meetinglist_w.add(meetinglist.get(i));
				}
			}
		}
		return meetinglist_w;
	}

}