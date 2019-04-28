package com.itbuzzpress.chapter9.endpoint;
 

import javax.websocket.*;
import javax.websocket.server.ServerEndpoint;

 
@ServerEndpoint(value="/hello")
	  
 

public class HelloWorldEndpoint {
	@OnMessage
	public String hello(String message) {
		System.out.println("Received : "+ message);
		return "Hello form the Server!";
	}
	@OnOpen
	public void myOnOpen(Session session) {
		System.out.println("WebSocket opened: " + session.getId());
	}
	@OnClose
	public void myOnClose(CloseReason reason) {
		System.out.println("Closing a due to " + reason.getReasonPhrase());
	}
    @OnError
    public void error(Throwable t) {      
    	
    }
}
