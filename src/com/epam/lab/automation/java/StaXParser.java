package com.epam.lab.automation.java;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Iterator;

import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.events.Attribute;
import javax.xml.stream.events.Characters;
import javax.xml.stream.events.EndElement;
import javax.xml.stream.events.StartElement;
import javax.xml.stream.events.XMLEvent;

public class StaXParser {
	boolean bFirstName = false;
	boolean bLastName = false;
	boolean bCourse = false;
	boolean bMark = false;

	public void staxParser() {
		long startTime = System.currentTimeMillis();
		try {
			System.out.println("\n----------------------------");
			System.out.println("StaX Parser");
			System.out.println("\n----------------------------");

			XMLInputFactory factory = XMLInputFactory.newInstance();
			XMLEventReader eventReader = factory.createXMLEventReader(new FileReader("XML.txt"));

			while (eventReader.hasNext()) {
				XMLEvent event = eventReader.nextEvent();

				switch (event.getEventType()) {

				case XMLStreamConstants.START_ELEMENT:
					StartElement startElement = event.asStartElement();
					String qName = startElement.getName().getLocalPart();

					if (qName.equalsIgnoreCase("student")) {
						System.out.println("Curent Element : student");
						Iterator<Attribute> attributes = startElement.getAttributes();
						String fname = attributes.next().getValue();
						System.out.println("First Name : " + fname);
					} else if (qName.equalsIgnoreCase("lastName")) {
						bLastName = true;
					} else if (qName.equalsIgnoreCase("course")) {
						bCourse = true;
					} else if (qName.equalsIgnoreCase("mark")) {
						bMark = true;
					}
					break;

				case XMLStreamConstants.CHARACTERS:
					Characters characters = event.asCharacters();
					if (bFirstName) {
						System.out.println("\nFirst Name: " + characters.getData());
						bFirstName = false;
					}
					if (bLastName) {
						System.out.println("Last Name: " + characters.getData());
						bLastName = false;
					}
					if (bCourse) {
						System.out.println("Course: " + characters.getData());
						bCourse = false;
					}
					if (bMark) {
						System.out.println("Marks: " + characters.getData());
						bMark = false;
					}
					break;

				case XMLStreamConstants.END_ELEMENT:
					EndElement endElement = event.asEndElement();

					if (endElement.getName().getLocalPart().equalsIgnoreCase("student")) {
						System.out.println();
					}
					break;
				}
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (XMLStreamException e) {
			e.printStackTrace();
		}
		long time = System.currentTimeMillis() - startTime;
		System.out.println(String.format("Time of StaX Parser: %s", time));
	}
}
