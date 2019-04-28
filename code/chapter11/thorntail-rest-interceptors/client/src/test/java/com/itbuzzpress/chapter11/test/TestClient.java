package com.itbuzzpress.chapter11.test;

 

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
 

import org.junit.Test;
 
 

public class TestClient {
String BASE_URL ="http://localhost:8080/rest";
	@Test
	public void test() {
		Client client = ClientBuilder.newClient();
		 
		String hello = client
				.target(BASE_URL +"/simple/text")
		             .request()
		             .get(String.class);	
		// Return value is zipped 
	}
 

}
