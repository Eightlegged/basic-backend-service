package com.eightlegged.smabackend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.eightlegged.smabackend.entity.Meeting;
import com.eightlegged.smabackend.entity.Partname;
import com.eightlegged.smabackend.entity.Status;
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

	@CrossOrigin
	@RequestMapping(value = "/meeting/add", method = RequestMethod.POST, consumes = {
			MediaType.APPLICATION_JSON_VALUE }, produces = { MediaType.APPLICATION_JSON_VALUE })
	public String createmeeting(@RequestBody Meeting meeting) {
		return meetingservice.createMeeting(meeting);
	}

	@CrossOrigin
	@RequestMapping(value = "/meeting/info/{id}", method = RequestMethod.GET, produces = {
			MediaType.APPLICATION_JSON_VALUE })
	public Meeting meetinginfo(@PathVariable Long id) {

		return meetingrepository.findOne(id);
	}

	@CrossOrigin
	@RequestMapping(value = "/meeting/complete", method = RequestMethod.GET, produces = {
			MediaType.APPLICATION_JSON_VALUE })
	public List<Meeting> meetinginfo_c() {

		return meetingrepository.findByStatus(Status.COMPLETE);
	}

	@CrossOrigin
	@RequestMapping(value = "/meeting", method = RequestMethod.GET, produces = { MediaType.APPLICATION_JSON_VALUE })
	public List<Meeting> meetinginfo_w() {

		return meetingrepository.findByStatus(Status.WAIT);
	}

	@CrossOrigin
	@RequestMapping(value = "/meeting/1", method = RequestMethod.GET, produces = { MediaType.APPLICATION_JSON_VALUE })
	public List<Meeting> meeting_part1() {

		return meetingrepository.findByPartname(Partname.Architecture);
	}

	@CrossOrigin
	@RequestMapping(value = "/meeting/2", method = RequestMethod.GET, produces = { MediaType.APPLICATION_JSON_VALUE })
	public List<Meeting> meeting_part2() {

		return meetingrepository.findByPartname(Partname.Engineering);
	}

	@CrossOrigin
	@RequestMapping(value = "/meeting/3", method = RequestMethod.GET, produces = { MediaType.APPLICATION_JSON_VALUE })
	public List<Meeting> meeting_part3() {

		return meetingrepository.findByPartname(Partname.RnD);
	}

	@CrossOrigin
	@RequestMapping(value = "/meeting/4", method = RequestMethod.GET, produces = { MediaType.APPLICATION_JSON_VALUE })
	public List<Meeting> meeting_part4() {

		return meetingrepository.findByPartname(Partname.QA);
	}

	@CrossOrigin
	@RequestMapping(value = "/meeting/delete/{id}", method = RequestMethod.POST)
	public String deletemeeting(@PathVariable Long id) {
		return meetingservice.deleteMeetingById(id);
	}

	@CrossOrigin
	@RequestMapping(value = "/meeting/start/{id}", method = RequestMethod.POST)
	public String startmeeting(@PathVariable Long id) {
		return meetingservice.startMeeting(id);
	}

	@CrossOrigin
	@RequestMapping(value = "/meeting/end/{id}", method = RequestMethod.POST)
	public String completemeeting(@PathVariable Long id) {
		return meetingservice.completeMeeting(id);
	}

}
