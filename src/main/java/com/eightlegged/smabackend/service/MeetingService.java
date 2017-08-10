package com.eightlegged.smabackend.service;

import java.util.List;

import com.eightlegged.smabackend.entity.Meeting;
import com.eightlegged.smabackend.entity.User;

public interface MeetingService {
	void createMeeting(Meeting Meeting);
	void deleteMeetingById(long id);
	void startMeeting(long id);
	void completeMeeting(long id);
	void setUser(long id) throws Exception;
	List<User> userList(User user);
	Meeting findOne(long id);
}
