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
import com.itbuzzpress.chapter11.test.filter.ClientFilter;

public class TestClient {
String BASE_URL ="http://localhost:8080/javaee7-rest-filters/rest";
	@Test
	public void test() {
		Client client = ClientBuilder.newClient();
		client.register(new ClientFilter("user","password"));
		String hello = client
				.target(BASE_URL +"/simple/text")
		             .request()
		             .get(String.class);	
		assertEquals("hello world!",hello);
	}
 

}
