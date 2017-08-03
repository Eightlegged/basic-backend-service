package com.eightlegged.smabackend.service;

import com.eightlegged.smabackend.entity.Meeting;
import com.eightlegged.smabackend.entity.User;

public interface MeetingService {
	Iterable<Meeting> list(User user);
	void createMeeting(Meeting Meeting);
	void deleteMeetingById(long id);
	void startMeeting(long id);
	void completeMeeting(long id);
	Meeting findOne(long id);
}
