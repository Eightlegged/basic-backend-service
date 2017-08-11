package com.eightlegged.smabackend.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author Kim Sae-Young(heehouse1@gmail.com)
 *
 * @FileName Part.java
 * @Project smabackend
 * @Date 2017. 8. 11.
 */

@Entity
@Table(name = "part_info")
public class Part implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -7341882592951630253L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "part_id", nullable = false)
	private Long id;
	
	@Column(name = "part_name")
	private String partName;
	
	public Part() {
		
	}
	
	public Part(Long id) {
		this.id = id;
	}
	
	public Part(String partName) {
		this.partName = partName;
	}
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getPartName() {
		return partName;
	}
	
	public void setPartName(String partName) {
		this.partName = partName;
	}

}
