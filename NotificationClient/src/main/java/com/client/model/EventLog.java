package com.client.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
/**
 * This class 
 * @author madhu
 *
 */
@Entity
public class EventLog {
	
	@Id
	@GeneratedValue
	private Long id;
	@Column(length=2500)
	private String log;

	public String getLog() {
		return log;
	}

	public void setLog(String log) {
		this.log = log;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

}
