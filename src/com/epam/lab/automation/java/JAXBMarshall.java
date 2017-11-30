package com.epam.lab.automation.java;

import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

public class JAXBMarshall {
	public void marshall() {
		Student st = new Student();
		st.setFirstName("IRYNA");
		st.setLastName("Kushnir");
		st.setCourse("Statistics");
		st.setMark(87);
		try {

			File file = new File("XML1.txt");
			JAXBContext jaxbContext = JAXBContext.newInstance(Student.class);
			Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

			jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

			jaxbMarshaller.marshal(st, file);
			jaxbMarshaller.marshal(st, System.out);

		} catch (JAXBException e) {
			e.printStackTrace();
		}
	}
}
