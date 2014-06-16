package com.itbuzzpress.chapter10.handler;


import javax.xml.transform.OutputKeys;
import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;

import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.ws.LogicalMessage;
import javax.xml.ws.handler.LogicalHandler;
import javax.xml.ws.handler.LogicalMessageContext;
import javax.xml.ws.handler.MessageContext;

import org.w3c.dom.Attr;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;





public class  SampleLogicalHandler implements LogicalHandler {
	@Override
	public boolean handleMessage(MessageContext context) {


		LogicalMessage   soapmc = ((LogicalMessageContext)context).getMessage();

		javax.xml.transform.dom.DOMSource source = (DOMSource) soapmc.getPayload();
		Node rootNode = source.getNode();
		System.out.println("[Logical Handler] Root Node"+rootNode.getNodeName());
		// Manipulate DOM here
		// . . . .
		source.setNode(rootNode);
		soapmc.setPayload(source);
		return true; 

 
	}


	@Override
	public boolean handleFault(MessageContext context) {
		return false;
	}
	@Override
	public void close(MessageContext context) {
		//. . .
	}
	
	public static void main(String args[]) {
		String s = "John Smith1000";
		System.out.println(s.replaceAll("1000", "2000"));
	}
}