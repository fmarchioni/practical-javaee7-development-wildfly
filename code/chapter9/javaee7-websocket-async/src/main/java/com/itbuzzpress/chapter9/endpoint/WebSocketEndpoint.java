package com.itbuzzpress.chapter9.endpoint;

 
 

import javax.websocket.CloseReason;
 
import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
 
 

@javax.websocket.ClientEndpoint()
public class WebSocketEndpoint   {
	 
 

	@OnOpen
	public void onOpen(Session session) {
		
	 
		 
	}
	 @OnClose
    public void onClose(Session userSession, CloseReason reason) {
        
        System.out.println("Session closed!");
    } 
	@OnMessage
	public void onMessage(String message) {
		System.out.println("Received message: " + message);
		 
	}

	 
    
}
