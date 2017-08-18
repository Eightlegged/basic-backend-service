package com.eightlegged.smabackend.entity;

import java.io.Serializable;

import javax.persistence.*;

/**
 * @author Kim Sae-Young(heehouse1@gmail.com)
 *
 * @FileName Meeting.java
 * @Project smabackend
 * @Date 2017. 8. 19.
 */

@Entity
@Table(name = "check_list")
public class CheckList implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4769787516219905785L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "cl_id", nullable = false)
	private Long id;

	@Column(name = "cl_item")
	private String item;

	@Column(name = "cl_checked")
	private boolean checked;

	@Column(name = "cl_mt_id")
	private Long meeting_id;

	public CheckList() {

	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public boolean getChecked() {
		return checked;
	}

	public void setChecked(boolean check) {
		this.checked = check;
	}

	public String getItem() {
		return item;
	}

	public void setItem(String item) {
		this.item = item;
	}

	public Long getMeetingId() {
		return meeting_id;
	}

	public void setMeetingId(Long meeting_id) {
		this.meeting_id = meeting_id;
	}

}
