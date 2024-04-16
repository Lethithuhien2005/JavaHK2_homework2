package ExerciseXML;

import java.io.File;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

public class Ex1_Main {
	public static void main(String[] args) {	
		try {
			File fileXML = new File("D:\\\\Users/DIEN MAY XANH/eclipse-workspace/homework2/src/ExerciseXML/Students.xml");
			SAXParserFactory factory = SAXParserFactory.newInstance();
			SAXParser saxParser = factory.newSAXParser();
			Ex1_SAXParser userHandler = new Ex1_SAXParser();
			saxParser.parse(fileXML, userHandler);
			for (Student st : userHandler.getListStudent()) {
				System.out.println(st.toString());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
