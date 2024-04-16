package Eg_XML;

import org.xml.sax.Attributes;

import org.xml.sax.ContentHandler;
import org.xml.sax.Locator;
import org.xml.sax.SAXException;

public class MyContentHandler implements ContentHandler {
	String data ="";
	private Locator locator;
	
	public void setDocumentLocator(Locator locator) {
		this.locator = locator;
		System.out.println("The locator set");
	}
	public void startDocument() throws SAXException {
		System.out.println("Processing started");
	}
	public void endDocument() throws SAXException {
		System.out.println("Processing stopped");
	}
	public void processingInstruction(String target, String data) throws SAXException {
		System.out.println("PI: the goal PI:" + target + " Data: " + data);
	}
	public void startPrefixMapping(String prefix, String uri) {
		System.out.println("Prefix " + prefix + " mapped to " + uri);
	}
	public void endPrefixMapping(String prefix) {
		System.out.println("Finished mapping the prefix " + prefix);
	}
	public void startElement(String namespaceURI, String localName, String rawName,Attributes atts) throws SAXException {
		System.out.println("start of the element " + localName);
		if (!namespaceURI.equals("")) {
			System.out.println(" the name of the element " + namespaceURI + " [" + rawName + "]");
		}
		else System.out.println("No namespace found ");
		for (int i=0; i<atts.getLength(); i++) {
			System.out.println(" Attribute: " + atts.getLocalName(i) + "=" + atts.getValue(i));
		}
		System.out.println("element's data " + localName + ":" + data);
	}
	public void endElement(String namespaceURI, String localName, String rawName) throws SAXException {
		System.out.println("end of the element: " + localName + "\n") ;
	}
	@Override
	public void ignorableWhitespace(char[] ch, int start, int end) throws SAXException {
		String s = new String (ch, start, end);
		System.out.println("skipped whilespaces: [" + s + "]");
	}
	@Override
	public void skippedEntity(String name) throws SAXException {
		System.out.println("Skipped entities " + name);
	}
	@Override
	public void characters(char[] ch, int start, int end) throws SAXException {
		data = new String (ch, start, end);
	}
}
