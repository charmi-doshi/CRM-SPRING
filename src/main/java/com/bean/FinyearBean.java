	package com.bean;

import java.sql.Date;

public class FinyearBean {

	private int id;
	private String yearName;
	private Date startDate;
	private Date endDate;
	private boolean currentFlag;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getYearName() {
		return yearName;
	}
	public void setYearName(String yearName) {
		this.yearName = yearName;
	}
	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	public Date getEndDate() {
		return endDate;
	}
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	public boolean isCurrentFlag() {
		return currentFlag;
	}
	public void setCurrentFlag(boolean currentFlag) {
		this.currentFlag = currentFlag;
	}
	
		
}
