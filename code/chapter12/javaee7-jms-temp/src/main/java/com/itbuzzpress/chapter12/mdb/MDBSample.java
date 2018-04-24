package com.itbuzzpress.chapter12.mdb;

import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

@MessageDriven(activationConfig = {
		@ActivationConfigProperty(propertyName = "destinationLookup", propertyValue = "queue/tempQueue"),
		@ActivationConfigProperty(propertyName = "destinationType", propertyValue = "javax.jms.Queue"), })
public class MDBSample implements MessageListener {

	public void onMessage(Message message) {
		try {
			TextMessage tm = (TextMessage) message;
			System.out.println("Message received  : " + tm.getText());
		} catch (JMSException ex) {
			ex.printStackTrace();
		}
	}

}
