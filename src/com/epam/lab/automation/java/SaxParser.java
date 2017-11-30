package com.epam.lab.automation.java;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class SaxParser extends DefaultHandler {
	boolean bFirstName = false;
	boolean bLastName = false;
	boolean bCourse = false;
	boolean bMark = false;

	@Override
	public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {

		if (qName.equalsIgnoreCase("student")) {
			System.out.println("Curent Element : student");
			String rollNo = attributes.getValue("firstName");
			System.out.println("First Name : " + rollNo);
		} else if (qName.equalsIgnoreCase("lastName")) {
			bLastName = true;
		} else if (qName.equalsIgnoreCase("course")) {
			bCourse = true;
		} else if (qName.equalsIgnoreCase("mark")) {
			bMark = true;
		}
	}

	@Override
	public void endElement(String uri, String localName, String qName) throws SAXException {

		if (qName.equalsIgnoreCase("student")) {
			System.out.println();
		}
	}

	@Override
	public void characters(char ch[], int start, int length) throws SAXException {

		if (bFirstName) {
			System.out.println("First Name: " + new String(ch, start, length));
			bFirstName = false;
		} else if (bLastName) {
			System.out.println("Last Name: " + new String(ch, start, length));
			bLastName = false;
		} else if (bCourse) {
			System.out.println("Course: " + new String(ch, start, length));
			bCourse = false;
		} else if (bMark) {
			System.out.println("Mark: " + new String(ch, start, length));
			bMark = false;
		}
	}

}
