package com.itbuzzpress.chapter12.controller;

import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.enterprise.inject.Model;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.jms.JMSConnectionFactory;
import javax.jms.JMSConnectionFactoryDefinition;
import javax.jms.JMSContext;
import javax.jms.JMSDestinationDefinition;
import javax.jms.Queue;
@Model
 

@JMSConnectionFactoryDefinition(name = "java:/TempConnectionFactory", 
className = "javax.jms.ConnectionFactory",user="jmsuser",password="Password1!")
@JMSDestinationDefinition(name = "java:jboss/jms/queue/tempQueue", 
                          className = "javax.jms.Queue", 
                          interfaceName = "javax.jms.Queue")
public class MessageSender {

	
	String message;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

 

	@Resource(mappedName = "java:jboss/jms/queue/tempQueue")
	Queue queue;

	@Inject
	@JMSConnectionFactory("java:/TempConnectionFactory")
	private JMSContext context;

	public void sendMessage() {
		context.createProducer().send(queue, message);
		
		
		printMessage("Sent message " + message);
	}

	private void printMessage(String string) {
		FacesContext.getCurrentInstance().addMessage(null,
				new FacesMessage(FacesMessage.SEVERITY_INFO, string, string));

	}
	 

}
