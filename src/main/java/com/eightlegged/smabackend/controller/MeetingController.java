package com.eightlegged.smabackend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.eightlegged.smabackend.entity.Meeting;
import com.eightlegged.smabackend.service.MeetingService;


/**
 * @author Kim Sae-Young(heehouse1@gmail.com)
 *
 * @FileName MeetingController.java
 * @Project smabackend
 * @Date 2017. 8. 5.
 */

@RestController
public class MeetingController {
	
	@Autowired
	MeetingService meetingservice;
	
	@RequestMapping(
			value="/meeting/add", method=RequestMethod.POST,
			consumes= {MediaType.APPLICATION_JSON_VALUE},
			produces= {MediaType.APPLICATION_JSON_VALUE})
	public void createmeeting(@RequestBody Meeting meeting) {
		meetingservice.createMeeting(meeting);
	}
	
	@RequestMapping(
			value="/meeting/delete", method=RequestMethod.POST,
			consumes= {MediaType.APPLICATION_JSON_VALUE},
			produces= {MediaType.APPLICATION_JSON_VALUE})
	public void deletemeeting(@RequestBody Meeting meeting) {
		meetingservice.deleteMeetingById(meeting.getId());
	}
	
	@RequestMapping(
			value="/meeting/start", method=RequestMethod.POST,
			consumes= {MediaType.APPLICATION_JSON_VALUE},
			produces= {MediaType.APPLICATION_JSON_VALUE})
	public void startmeeting(@RequestBody Meeting meeting) {
		meetingservice.startMeeting(meeting.getId());
	}
	
	@RequestMapping(
			value="/meeting/end", method=RequestMethod.POST,
			consumes= {MediaType.APPLICATION_JSON_VALUE},
			produces= {MediaType.APPLICATION_JSON_VALUE})
	public void completemeeting(@RequestBody Meeting meeting) {
		meetingservice.completeMeeting(meeting.getId());
	}

}
