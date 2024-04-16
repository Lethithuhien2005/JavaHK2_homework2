package ExerciseXML;

import java.io.File;
import java.security.DomainCombiner;
import java.util.ArrayList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import com.mysql.cj.xdevapi.DocResultBuilder;

public class Ex1_DOMParser {
	public static ArrayList<Student> readListStudents() {
		ArrayList<Student> listSt = new ArrayList<Student>();
		Student st = null;
		try {
			File fileXML = new File("D:\\Users/DIEN MAY XANH/eclipse-workspace/homework2/src/ExerciseXML/Students.xml");
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(fileXML);
			doc.getDocumentElement().normalize();

			// in phan tu goc ra man hinh:
			System.out.println("Original elament: " + doc.getDocumentElement().getNodeName());

			// doc tat ca cac phan tu co ten the la "Student":
			NodeList nodeListStudent = doc.getElementsByTagName("Student");

			// duyet cac phan tu Student:
			for (int i = 0; i < nodeListStudent.getLength(); i++) {
				st = new Student();
				// Doc cac thuoc tinh cua "Student":
				Node nNode = nodeListStudent.item(i);
				if (nNode.getNodeType() == Node.ELEMENT_NODE) {
					Element element = (Element) nNode;
					st.setId(element.getElementsByTagName("Name").item(0).getTextContent());
					st.setId(element.getElementsByTagName("ID").item(0).getTextContent());
					st.setBirth(element.getElementsByTagName("Birth").item(0).getTextContent());
					st.setGpa(element.getElementsByTagName("GPA").item(0).getTextContent());
				}
				// add doi tuong vao st vafo listSt
				listSt.add(st);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return listSt;
	}

	public static void main(String[] args) {
		ArrayList<Student> listSt = Ex1_DOMParser.readListStudents();
		// Hien thi danh sach ra man hinh:
		for (Student st : listSt) {
			System.out.println(st.toString());
		}
	}
}
