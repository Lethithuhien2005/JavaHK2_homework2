package Eg_XML;

import java.io.File;
import java.io.IOException;

import org.w3c.dom.Document;
import org.w3c.dom.DocumentType;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;



public class DOM {
	private static String xmlResource;

	public static void main(String[] args) throws IOException{
		int index = 0;
		index =Integer.parseInt(args[0]);
		String[] file = {"item.xml", "chesboard.xml", "contents.xml"};
		try {
			xmlResource = "file:\\" + new File(file[index]).getAbsolutePath();
			System.out.println(xmlResource);
			DOMParser parser = new DOMParser();
			parser.setFeature("http://xml.org/sax/features/validation", false);
			parser.setFeature("http://xml.org/sax/features/namespaces",true);
			parser.parse(xmlResource);
			Document doc = parser.getDocument();
			printTree(doc, "");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
		public static void printTree(Node node, String insets) {
			switch(node.getNodeType()) {
			case Node.DOCUMENT_NODE:
				System.out.println("<xml version=\"1.0\">\n");
				Document doc = (Document)node;
				printTree(doc.getDocumentElement(), "");
				break;
			case Node.ELEMENT_NODE:
				String name = node.getNodeName();
				System.out.println(insets + "<" + name);
				NamedNodeMap attributes = node.getAttributes();
				for (int i=0; i<attributes.getLength(); i++) {
					Node current=attributes.item(i);
					System.out.println(" " + current.getNodeName() + "=\"" + current.getNodeValue() + "\"");
				}
				System.out.println(">");
				NodeList children = node.getChildNodes();
				if (children!=null) {
					for (int i=0; i<children.getLength(); i++) {
						printTree(children.item(i), insets + " ");
					}
				}
				break;
			case Node.CDATA_SECTION_NODE:
				System.out.println(node.getNodeValue());
				break;
			case Node.PROCESSING_INSTRUCTION_NODE:
				System.out.print("<?"+node.getNodeName()+ "  "+node.getNodeValue()+  "?>");	    
				break; 
			case Node.ENTITY_REFERENCE_NODE: 
				break;
			case Node.DOCUMENT_TYPE_NODE:
				break;
			}
		}
	}
