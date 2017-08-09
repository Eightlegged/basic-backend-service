package com.eightlegged.smabackend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eightlegged.smabackend.entity.Meeting;
import com.eightlegged.smabackend.entity.Status;
import com.eightlegged.smabackend.repository.MeetingRepository;

@Service
public class MeetingServiceImpl implements MeetingService{
	
	@Autowired
    private MeetingRepository MeetingRepository;

	@Override
	public void createMeeting(Meeting meeting) {
		MeetingRepository.save(meeting);
	}

	@Override
	public void deleteMeetingById(long id) {
		MeetingRepository.delete(id);
	}

	@Override
	public void startMeeting(long id) {
		// TODO Auto-generated method stub
		Meeting meeting = MeetingRepository.findOne(id);
		meeting.setStatus(Status.START);
		MeetingRepository.save(meeting);
	}

	@Override
	public void completeMeeting(long id) {
		// TODO Auto-generated method stub
		Meeting meeting = MeetingRepository.findOne(id);
		meeting.setStatus(Status.COMPLETE);
		MeetingRepository.save(meeting);
	}
	
	@Override
	public Meeting findOne(long id) {
		Meeting meeting = MeetingRepository.findOne(id);
		return meeting;
	}

}