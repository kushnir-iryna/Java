package com.epam.lab.automation.java;

import java.io.File;
import java.io.IOException;

import javax.xml.XMLConstants;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;

import org.xml.sax.SAXException;

public class Validator {
	public boolean validateXMLByXSD(String xml, String xsd) throws SAXException, IOException {
		try {
			SchemaFactory factory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
			Schema schema = factory.newSchema(new File(xsd));
			javax.xml.validation.Validator validator = schema.newValidator();
			validator.validate(new StreamSource(new File(xml)));
		} catch (IOException e) {
			System.out.println("Exception: " + e.getMessage());
			return false;
		} catch (SAXException e1) {
			System.out.println("SAX Exception: " + e1.getMessage());
			return false;
		}
		return true;
	}
}