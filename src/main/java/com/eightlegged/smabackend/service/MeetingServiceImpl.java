package com.eightlegged.smabackend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.eightlegged.smabackend.entity.Meeting;
import com.eightlegged.smabackend.entity.Status;
import com.eightlegged.smabackend.repository.MeetingRepository;

@Service
public class MeetingServiceImpl implements MeetingService{
	
	private static final Logger logger = LoggerFactory.getLogger(MeetingServiceImpl.class);
	
	@Autowired
    private MeetingRepository MeetingRepository;

	@Override
	public void createMeeting(Meeting meeting) {
		MeetingRepository.save(meeting);
		logger.info("Meeting Created! Meeting ID: " + meeting.getId());
	}

	@Override
	public void deleteMeetingById(long id) {
		MeetingRepository.delete(id);
		logger.info("Meeting Deleted! Meeting ID: " + MeetingRepository.findOne(id).getId());
	}

	@Override
	public void startMeeting(long id) {
		// TODO Auto-generated method stub
		Meeting meeting = MeetingRepository.findOne(id);
		meeting.setStatus(Status.START);
		MeetingRepository.save(meeting);
		logger.info("Meeting Started! Meeting ID: " + MeetingRepository.findOne(id).getId());
	}

	@Override
	public void completeMeeting(long id) {
		// TODO Auto-generated method stub
		Meeting meeting = MeetingRepository.findOne(id);
		meeting.setStatus(Status.COMPLETE);
		MeetingRepository.save(meeting);
		logger.info("Meeting Finished! Meeting ID: " + MeetingRepository.findOne(id).getId());
	}
	
	@Override
	public Meeting findOne(long id) {
		Meeting meeting = MeetingRepository.findOne(id);
		return meeting;
	}

}