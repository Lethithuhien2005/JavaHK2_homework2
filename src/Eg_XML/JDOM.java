package Eg_XML;

import java.io.*;
import org.jdom.*;
import org.jdom.input.*;
import org.jdom.output.*;

import org.w3c.dom.*;
import org.xml.sax.*;

import javax.xml.parsers.*;

public class JDOM {
  public static void main (String args []) throws IOException,JDOMException,ParserConfigurationException,SAXException { 
    int index=0;
    index=Integer.parseInt(args[0]);
    String xmlFile="";   
    String[] file = {"item.xml","chessboard.xml","contents.xml"};
    try {     
      xmlFile = "file:\\" + new File(file[index]).getAbsolutePath();     
      System.out.println(xmlFile);            
     }
     catch (Exception e) { e.printStackTrace(); } 
     System.out.println();  
     System.out.println("####### building a  JDOM document from an XML file using a SAXBuilder");    
     saxDocument(xmlFile);
     System.out.println(); 
     System.out.println("####### building a  JDOM document from a DOM document using a DOMBuilder");    
     domDocument(xmlFile);     
     
    System.exit(0);
    
  }//main()
  
  public static void saxDocument(String fileName) throws IOException,JDOMException {  	 
    SAXBuilder builder = new SAXBuilder(false);     
    org.jdom.Document doc = builder.build(fileName);       
    printDocument(doc);
  }
  
  public static void domDocument(String fileName) throws ParserConfigurationException,SAXException,IOException,JDOMException {
    DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
    DocumentBuilder build = dbf.newDocumentBuilder();   
    org.w3c.dom.Document domDoc = build.parse(fileName);
    DOMBuilder builder = new DOMBuilder(false);
    org.jdom.Document jdomDoc = builder.build(domDoc);        
    printDocument(jdomDoc);
  }   
        
  public static void printDocument(org.jdom.Document doc)throws IOException {
    XMLOutputter fmt = new XMLOutputter();
    System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
    fmt.output(doc,System.out);
    System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");  	  	  	
 }
}

