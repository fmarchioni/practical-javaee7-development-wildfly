package com.itbuzzpress.chapter10.handler;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.Set;

import javax.xml.namespace.QName;
import javax.xml.soap.SOAPBody;
import javax.xml.soap.SOAPException;
import javax.xml.soap.SOAPHeader;
import javax.xml.soap.SOAPMessage;
import javax.xml.ws.ProtocolException;
import javax.xml.ws.handler.MessageContext;
import javax.xml.ws.handler.soap.SOAPMessageContext;

import org.w3c.dom.NodeList;

public class SampleSOAPHandler implements javax.xml.ws.handler.soap.SOAPHandler<SOAPMessageContext> {

	@Override
	public boolean handleMessage(SOAPMessageContext mc) {
		Boolean outboundProperty = (Boolean)
				mc.get (MessageContext.MESSAGE_OUTBOUND_PROPERTY);

		if (outboundProperty.booleanValue()) {
			System.out.println("\nOutbound message:");
		} else {
			System.out.println("\nInbound message:");
		}
		SOAPMessage soapMessage =
				((SOAPMessageContext)mc).getMessage();

		try {
			ByteArrayOutputStream baos = new
					ByteArrayOutputStream();
			soapMessage.writeTo(baos);
			System.out.println(baos.toString());

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return true;
	}
	@Override
	public Set<QName> getHeaders() {
		return null;
	}

	@Override
	public void close(MessageContext mc) {
	}

	@Override
	public boolean handleFault(SOAPMessageContext mc) {
		return true;
	}	
}