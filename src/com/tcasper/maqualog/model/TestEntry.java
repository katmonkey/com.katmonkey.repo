package com.tcasper.maqualog.model;

import java.sql.Timestamp;

public class TestEntry {
	
	private String testType;
	private Timestamp date;
	private float value;
	
	public String getTestType() {
		return testType;
	}
	
	public void setTestType(String testType) {
		this.testType = testType;
	}
	
	public Timestamp getDate() {
		return date;
	}
	public void setDate(Timestamp date) {
		this.date = date;
	}
	public float getValue() {
		return value;
	}
	public void setValue(float value) {
		this.value = value;
	}

}
