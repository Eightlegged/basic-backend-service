package com.eightlegged.smabackend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.eightlegged.smabackend.entity.Meeting;
import com.eightlegged.smabackend.repository.MeetingRepository;
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
	
	@Autowired
	MeetingRepository meetingrepository;
	
	@RequestMapping(
			value="/meeting/add", method=RequestMethod.POST,
			consumes= {MediaType.APPLICATION_JSON_VALUE},
			produces= {MediaType.APPLICATION_JSON_VALUE})
	public String createmeeting(@RequestBody Meeting meeting){
		return meetingservice.createMeeting(meeting);
	}
	
	@RequestMapping(
			value="/meeting/{id}", method=RequestMethod.GET,
			produces= {MediaType.APPLICATION_JSON_VALUE})
	public Meeting meetinginfo(@PathVariable Long id){
		return meetingrepository.findOne(id);
	}
	
	@RequestMapping(
			value="/meeting/delete", method=RequestMethod.POST,
			consumes= {MediaType.APPLICATION_JSON_VALUE},
			produces= {MediaType.APPLICATION_JSON_VALUE})
	public String deletemeeting(@RequestBody Long id) {
		return meetingservice.deleteMeetingById(id);
	}
	
	@RequestMapping(
			value="/meeting/start", method=RequestMethod.POST,
			consumes= {MediaType.APPLICATION_JSON_VALUE},
			produces= {MediaType.APPLICATION_JSON_VALUE})
	public String startmeeting(@RequestBody Long id) {
		return meetingservice.startMeeting(id);
	}
	
	@RequestMapping(
			value="/meeting/end", method=RequestMethod.POST,
			consumes= {MediaType.APPLICATION_JSON_VALUE},
			produces= {MediaType.APPLICATION_JSON_VALUE})
	public String completemeeting(@RequestBody Long id) {
		return meetingservice.completeMeeting(id);
	}

}
