package com.itbuzzpress.chapter12.controller;

import javax.faces.application.FacesMessage;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.enterprise.inject.Model;
import javax.inject.Inject;
import javax.jms.ConnectionFactory;
import javax.jms.DeliveryMode;
import javax.jms.JMSConnectionFactory;
import javax.jms.JMSContext;
import javax.jms.JMSSessionMode;
import javax.jms.Queue;
import javax.jms.Topic;
@Model
public class MessageSender {
	String message;
    public static final String MY_QUEUE = "java:/jms/queue/exampleQueue";
	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	@Inject
	JMSContext context;

    @Resource(lookup = MY_QUEUE)
    private Queue queue;

	public void sendMessage() {
		context.createProducer().send(queue, message);
		
		
		printMessage("Sent message " + message);
	}

	private void printMessage(String string) {
		FacesContext.getCurrentInstance().addMessage(null,
				new FacesMessage(FacesMessage.SEVERITY_INFO, string, string));

	}
	 

}
 