package com.eightlegged.smabackend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.eightlegged.smabackend.entity.Meeting;
import com.eightlegged.smabackend.entity.Status;
import com.eightlegged.smabackend.entity.User;
import com.eightlegged.smabackend.repository.MeetingRepository;
import com.eightlegged.smabackend.repository.UserRepository;

@Service
public class MeetingServiceImpl implements MeetingService {

	private static final Logger logger = LoggerFactory.getLogger(MeetingServiceImpl.class);

	@Autowired
	private MeetingRepository MeetingRepository;

	@Autowired
	private UserRepository userRepository;

	@Override
	public void createMeeting(Meeting meeting) {
		MeetingRepository.save(meeting);
		try {
			setUser(meeting.getId());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
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
		MeetingRepository.delete(meeting);
		meeting.setStatus(Status.START);
		MeetingRepository.save(meeting);
		logger.info("Meeting Started! Meeting ID: " + MeetingRepository.findOne(id).getId());
	}

	@Override
	public void completeMeeting(long id) {
		// TODO Auto-generated method stub
		Meeting meeting = MeetingRepository.findOne(id);
		MeetingRepository.delete(meeting);
		meeting.setStatus(Status.COMPLETE);
		MeetingRepository.save(meeting);
		logger.info("Meeting Finished! Meeting ID: " + MeetingRepository.findOne(id).getId());
	}

	@Override
	public Meeting findOne(long id) {
		Meeting meeting = MeetingRepository.findOne(id);
		return meeting;
	}

	@Override
	public List<User> userList(User user) {
		// TODO Auto-generated method stub
		List<User> userList = new ArrayList<User>();
		userList.add(user);
		return null;
	}

	@Override
	public void setUser(long id) throws Exception{
		// TODO Auto-generated method stub
		Meeting meeting = MeetingRepository.findOne(id);
		for (int i = 0; i < meeting.getUserList().size(); i++) {
			User user = userRepository.findByEmail(meeting.getUserList().get(i).getEmail());
			List<Meeting> existList = user.getMeetingList();

			

			boolean save = true;
			for (int j = 0; j < existList.size(); j++) {
				if (id == existList.get(j).getId()) {
					save = false;
					break;
				}
			}

			existList.add(meeting);
			user.setMeetingList(existList);
			
			if (save == true) {
				System.out.println(i);
				userRepository.save(user);
			}

			logger.info("User(ID: " + user.getId() + ") Participate in Meeting(ID: "
					+ MeetingRepository.findOne(id).getId() + ")");

		}
	}
}