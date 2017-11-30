package com.epam.lab.automation.java;

import java.io.IOException;

import org.xml.sax.SAXException;

public class Main {

	public static void main(String[] args) throws SAXException, IOException {
		Validator validator = new Validator();
		boolean isValid = validator.validateXMLByXSD("XML.txt", "XSD.txt");
		if (isValid) {
			System.out.println("XML is valid against XSD");
		} else {
			System.out.println("XML is not valid against XSD");
		}

		System.out.println("****************************");

		DOMParser dParse = new DOMParser();
		dParse.dparser();
		System.out.println("****************************");

		SAXParserUsage sParse = new SAXParserUsage();
		sParse.saxParse();

		System.out.println("****************************");

		StaXParser stParse = new StaXParser();
		stParse.staxParser();

		System.out.println("****************************");

		System.out.println("JAXB Marshalling: Converting a Java Object to XML:");
		JAXBMarshall ConvertObjectXML = new JAXBMarshall();
		ConvertObjectXML.marshall();

		System.out.println("****************************");

		System.out.println("JAXB Unmarhsalling: Converting XML to Java Object:");
		JAXBUnmarshall ConvertXMObject = new JAXBUnmarshall();
		ConvertXMObject.unmarshall();
	}
}
