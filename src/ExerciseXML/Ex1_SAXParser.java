package ExerciseXML;

import java.util.ArrayList;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class Ex1_SAXParser extends DefaultHandler {
	private String content;
	private Student st;
	ArrayList<Student> listStudent = new ArrayList<Student>();
	
	@Override
	public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
		if ("student".equalsIgnoreCase(qName)) {
			 st = new Student();
			 st.toString();
		}
	}

	@Override
	public void characters(char[] ch, int start, int length) throws SAXException {
		content = String.copyValueOf(ch, start, length).trim();
	}
	
	@Override
	public void endElement(String uri, String localName, String qName) throws SAXException {
		switch(qName) {
		case "Student":
			listStudent.add(st);
			break;
		case "Name":
			st.setName(content);
			break;
		case "ID":
			st.setId(content);
			break;
		case "Birth":
			st.setBirth(content);
			break;
		case "GPA":
			st.setGpa(content);
			break;
		}
	}

	public ArrayList<Student> getListStudent() {
		return listStudent;
	}

	public void setListStudent(ArrayList<Student> listStudent) {
		this.listStudent = listStudent;
	}
	
}
