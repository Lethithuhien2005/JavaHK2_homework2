package Eg_XML;

import org.xml.sax.ErrorHandler;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;

public class MyErrorHandler implements ErrorHandler {
	public void warning(SAXParseException e) throws SAXException {
		System.out.println("*Parse warning*\n" + " Line:   " + e.getLineNumber() + "\n" + " URI:    " + e.getSystemId() + "\n" + " Message:  " + e.getMessage());
		throw new SAXException("Warning");
	}
	public void error(SAXParseException e) throws SAXException {
		System.out.println("**Parsing Error**\n" + " Line:   " + e.getLineNumber() + "\n" + " URI:    " + e.getSystemId() + "\n" + " Message:  " + e.getMessage());
		throw new SAXException("Non-fatal error");
	}
	@Override
	public void fatalError(SAXParseException e) throws SAXException {
		System.out.println("**Parsing Fatal Error**\n" +  " Line:   " + e.getLineNumber() + "\n" + " URI:    " + e.getSystemId() + "\n" + " Message:  " + e.getMessage());
		throw new SAXException("Fatal error");
	}
}
