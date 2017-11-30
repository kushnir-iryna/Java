package com.epam.lab.automation.java;

import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class DOMParser {
	public void dparser() {
		long startTime = System.currentTimeMillis();
		try {
			File inputFile = new File("XML.txt");
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(inputFile);
			doc.getDocumentElement().normalize();
			System.out.println("DOM Parser");
			NodeList nList = doc.getElementsByTagName("student");
			System.out.println("----------------------------");

			for (int temp = 0; temp < nList.getLength(); temp++) {
				Node nNode = nList.item(temp);
				System.out.println("\nCurrent Element :" + nNode.getNodeName());

				if (nNode.getNodeType() == Node.ELEMENT_NODE) {
					Element eElement = (Element) nNode;
					System.out.println("First name : " + eElement.getAttribute("firstName"));
					System.out.println(
							"Last Name : " + eElement.getElementsByTagName("lastName").item(0).getTextContent());
					System.out.println("Course : " + eElement.getElementsByTagName("course").item(0).getTextContent());
					System.out.println("Marks : " + eElement.getElementsByTagName("mark").item(0).getTextContent());
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		long time = System.currentTimeMillis() - startTime;
		System.out.println(String.format("\nTime of DOM Parser: %s", time));
	}
}
