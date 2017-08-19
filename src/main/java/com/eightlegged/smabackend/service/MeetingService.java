package com.eightlegged.smabackend.service;

import java.util.List;

import com.eightlegged.smabackend.entity.Meeting;
import com.eightlegged.smabackend.entity.Partname;
import com.eightlegged.smabackend.entity.Status;
import com.eightlegged.smabackend.entity.User;

public interface MeetingService {
	String createMeeting(Meeting Meeting);

	String deleteMeetingById(Long id);

	String startMeeting(Long id);

	String completeMeeting(Long id, Meeting meeting);
	
	void setUser(String email, Long id);

	List<User> userList(User user);

	Meeting findOne(Long id);
	
	List<Meeting> findByStatus(Status status);
	
	List<Meeting> findByPart(Partname partname);
}
