package com.eightlegged.smabackend.entity;

import java.sql.Date;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

import com.eightlegged.smabackend.JSON.JSONDeserializer;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

/**
 * @author Kim Sae-Young(heehouse1@gmail.com)
 *
 * @FileName Meeting.java
 * @Project smabackend
 * @Date 2017. 8. 5.
 */

@Entity
@Table(name = "meeting_serv")
public class Meeting {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "meeting_id", nullable = false)
	private Long id;

	@Column(name = "mt_name", nullable = false)
	private String title;

	@Column(name = "mt_comment")
	private String comment;

	@Column(name = "mt_content")
	private String content;

	@Column(name = "mt_date", nullable = false)
	private Date date;

	@JsonFormat(pattern = "HH:mm")
	@JsonDeserialize(using = JSONDeserializer.class)
	@Column(name = "mt_st_time", nullable = false)
	private Time startTime;

	@JsonFormat(pattern = "HH:mm")
	@JsonDeserialize(using = JSONDeserializer.class)
	@Column(name = "mt_fn_time")
	private Time endTime;

	@ManyToMany(cascade = CascadeType.REMOVE, mappedBy = "meetingList")
	private List<User> userList = new ArrayList<>();

	@Column(name = "mt_status", nullable = false)
	@Enumerated(EnumType.STRING)
	private Status status = Status.WAIT;

	@Column(name = "part")
	@Enumerated(EnumType.STRING)
	private Partname partname;
	
	@OneToMany
	@JoinColumn(name="cl_mt_id")
	private List<CheckList> checkList = new ArrayList<>();

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getComment() {
		return comment;
	}

	public void setSubTitle(String comment) {
		this.comment = comment;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Time getStartTime() {
		return startTime;
	}

	public void setStartTime(Time sartTime) {
		this.startTime = sartTime;
	}

	public Time getEndTime() {
		return endTime;
	}

	public void setEndTime(Time endTime) {
		this.endTime = endTime;
	}

	@JsonProperty(access = JsonProperty.Access.AUTO)
	public List<User> getUserList() {
		return userList;
	}

	public void setUserList(List<User> userList) {
		this.userList = userList;
	}

	public Partname getPartName() {
		return partname;
	}

	public void setPartName(Partname partname) {
		this.partname = partname;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	@JsonProperty(access = JsonProperty.Access.AUTO)
	public List<CheckList> getCheckList(){
		return checkList;
	}
	
	public void setCheck_List(List<CheckList> checklist) {
		this.checkList = checklist;
	}

}