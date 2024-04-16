package Eg_XML;

import java.io.File;
import java.io.IOException;

import org.xml.sax.ContentHandler;
import org.xml.sax.ErrorHandler;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

public class SAX {
	public static void main(String[] args) {
		String xmlResource="";
		int index = 0;
		index = Integer.parseInt(args[0]);
		//XML File
		String[] file = {"item.xml", "chessboard.xml"};
		try {
			//Get the path name
			xmlResource = "file:\\" + new File(file[index]).getAbsolutePath();
			System.out.println(xmlResource);
		} catch (Exception e) {
			System.out.println("Processing the file: " + xmlResource + "\n");
			ContentHandler contentHandler = new MyContentHandler();
			ErrorHandler errorHandler = new MyErrorHandler();
			try {
				XMLReader parser = XMLReaderFactory.createXMLReader("org.apache.xerces.parsers.SAXParser");
				System.out.println("parser= " + parser);
				parser.setContentHandler(contentHandler);
				parser.setErrorHandler(errorHandler);
				parser.setFeature("http://xml.org/sax/features/validation", false);
				parser.setFeature("http://xml.org/sax/features/namespaces", true);
				parser.parse(xmlResource);
			} catch (IOException e1) {
				System.out.println("Error while reading the file: " + e1.getMessage());
			} catch (SAXException e2) {
				System.out.println("Error while parsing the file: " + e.getMessage());
			}
			
			
		}
	}
}
