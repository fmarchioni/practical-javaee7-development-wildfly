 

package com.itbuzzpress.chapter9.endpoint;
 

import javax.websocket.*;

import com.itbuzzpress.chapter9.encoder.*;
import com.itbuzzpress.chapter9.model.User;
import com.itbuzzpress.chapter9.decoder.*;

@javax.websocket.ClientEndpoint(
encoders = { MessageEncoder.class},
decoders = { MessageDecoder.class})
	public class WebSocketEncodedEndpoint {

	    @OnOpen
	    public void onOpen(Session session) {
	        try {
	        	User person = new User();
	        	person.setName("john");
	        	person.setSurname("smith");
	        	person.setEmail("acme@gmail.com");

	        	
	            session.getBasicRemote().sendObject(person);
	            
	           
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	    }

	    @OnMessage
	    public void onMessage(String message) {
	        System.out.println("Received response from server: "+ message);
	    }
	}