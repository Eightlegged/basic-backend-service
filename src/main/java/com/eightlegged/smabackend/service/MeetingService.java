package com.eightlegged.smabackend.service;

import java.util.List;

import com.eightlegged.smabackend.entity.Meeting;
import com.eightlegged.smabackend.entity.User;

public interface MeetingService {
	void createMeeting(Meeting Meeting);
	void deleteMeetingById(Long id);
	void startMeeting(Long id);
	void completeMeeting(Long id);
	void setUser(Long id) throws Exception;
	List<User> userList(User user);
	Meeting findOne(Long id);
}
