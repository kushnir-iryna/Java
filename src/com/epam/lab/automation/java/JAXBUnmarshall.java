package com.epam.lab.automation.java;

import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

public class JAXBUnmarshall {
	public void unmarshall() {
		try {
			File file = new File("XML1.txt");
			JAXBContext jaxbContext = JAXBContext.newInstance(Student.class);

			Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
			Student st = (Student) jaxbUnmarshaller.unmarshal(file);
			System.out.println(st);

		} catch (JAXBException e) {
			e.printStackTrace();
		}
	}

}
