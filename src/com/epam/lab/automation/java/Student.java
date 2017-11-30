package com.epam.lab.automation.java;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Student {
	private String firstName;
	private String lastName;
	private String course;
	private int mark;

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public String getCourse() {
		return course;
	}

	public int getMark() {
		return mark;
	}

	@XmlAttribute
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	@XmlElement
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	@XmlElement
	public void setCourse(String course) {
		this.course = course;
	}

	@XmlElement
	public void setMark(int mark) {
		this.mark = mark;
	}

	@Override
	public String toString() {
		return "Student:: First Name=" + this.firstName + " Last Name=" + this.lastName + " Course=" + this.course
				+ " Mark=" + this.mark;

	}
}
