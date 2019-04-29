package com.itbuzzpress.chapter11.test;

 

import static org.junit.Assert.*;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.junit.Test;

import com.itbuzzpress.chapter11.model.SimpleProperty;

public class TestClient {
String BASE_URL ="http://localhost:8080/rest";
	 @Test
	public void testSimple() {
		Client client = ClientBuilder.newClient();
		String hello = client
				.target(BASE_URL +"/simple/text")
		             .request()
		             .get(String.class);	
		assertEquals("hello world!",hello);
	}
	@Test
	public void testParam() {
		Client client = ClientBuilder.newClient();
		SimpleProperty p1 = new SimpleProperty("mykey","value");

		WebTarget myResource = client.target(BASE_URL+"/param/add");
		Response rs = myResource.request(MediaType.APPLICATION_XML)
						.post(Entity.xml(p1), Response.class);
		
		assertEquals(rs.getStatus(),200);
		
		String out = rs.readEntity(String.class);
		
		assertEquals(out,"Success");

		SimpleProperty p2 = client
				.target(BASE_URL + "/param/xml/{id}")
				.resolveTemplate("id", "0")
				.request(MediaType.APPLICATION_XML)
		             .get(SimpleProperty.class);

		assertEquals("mykey",p2.getKey());
		assertEquals("value",p2.getValue());
	}
	 
	 

}
