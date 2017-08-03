package com.eightlegged.smabackend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eightlegged.smabackend.entity.Meeting;
import com.eightlegged.smabackend.entity.User;
import com.eightlegged.smabackend.repository.MeetingRepository;

@Service
public class MeetingServiceImpl implements MeetingService{
	
	@Autowired
    private MeetingRepository MeetingRepository;
	
	@Override
	public Iterable<Meeting> list(User user) {
		return MeetingRepository.findAllByUser(user);
	}

	@Override
	public void createMeeting(Meeting meeting) {
		MeetingRepository.save(meeting);
	}

	@Override
	public void deleteMeetingById(long id) {
		MeetingRepository.delete(id);
	}

	@Override
	public Meeting findOne(long id) {
		Meeting meeting = MeetingRepository.findOne(id);
		return meeting;
	}

}