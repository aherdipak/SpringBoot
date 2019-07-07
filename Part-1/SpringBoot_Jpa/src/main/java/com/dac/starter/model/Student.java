package com.dac.starter.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Student {

	@Id
	private int stdId;
	private String stdName;
	private String stdTech;

	public String getStdTech() {
		return stdTech;
	}

	public void setStdTech(String stdTech) {
		this.stdTech = stdTech;
	}

	public int getStdId() {
		return stdId;
	}

	public void setStdId(int stdId) {
		this.stdId = stdId;
	}

	public String getStdName() {
		return stdName;
	}

	public void setStdName(String stdName) {
		this.stdName = stdName;
	}

	@Override
	public String toString() {
		return "Student [stdId=" + stdId + ", stdName=" + stdName + ", stdTech=" + stdTech + "]";
	}


}
