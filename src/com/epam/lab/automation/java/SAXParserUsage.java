package com.epam.lab.automation.java;

import java.io.File;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

public class SAXParserUsage {
	public void saxParse() {
		long startTime = System.currentTimeMillis();
		try {
			System.out.println("\n----------------------------");
			System.out.println("SAX Parser");
			System.out.println("\n----------------------------");
			File inputFile = new File("XML.txt");
			SAXParserFactory factory = SAXParserFactory.newInstance();
			SAXParser saxParser = factory.newSAXParser();
			SaxParser userhandler = new SaxParser();
			saxParser.parse(inputFile, userhandler);
		} catch (Exception e) {
			e.printStackTrace();
		}
		long time = System.currentTimeMillis() - startTime;
		System.out.println(String.format("Time of SAX Parser: %s", time));
	}

}
