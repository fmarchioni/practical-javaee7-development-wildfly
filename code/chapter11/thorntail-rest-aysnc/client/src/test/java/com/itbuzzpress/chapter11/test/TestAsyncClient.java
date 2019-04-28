package com.itbuzzpress.chapter11.test;

import static org.junit.Assert.*;

import java.util.concurrent.Future;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.InvocationCallback;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.junit.Test;

import com.itbuzzpress.chapter11.model.SimpleProperty;

public class TestAsyncClient {
	String BASE_URL = "http://localhost:8080/rest";

	@Test
	public void testClientAsync() throws Exception {

		Client client = ClientBuilder.newClient();
		SimpleProperty propertyIn = new SimpleProperty("secretkey", "value");

		WebTarget myResource = client.target(BASE_URL + "/param/add");
		Future<SimpleProperty> ret = myResource
				.request(MediaType.APPLICATION_XML).async()
				.post(Entity.xml(propertyIn), SimpleProperty.class);

		SimpleProperty property = ret.get();
		assertEquals("value", property.getValue());

		// Wait for Future
		Future<SimpleProperty> future = client
				.target(BASE_URL + "/param/xmlasync/{key}")
				.resolveTemplate("key", "secretkey")
				.request(MediaType.APPLICATION_XML).async()
				.get(SimpleProperty.class);

		SimpleProperty propertyOut = null;
		try {
			while (!future.isDone()) {
				Thread.sleep(100);
			}
			propertyOut = future.get();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		assertEquals("value", propertyOut.getValue());
		
		// Alternative approach using InvocationCallback
		client.target(BASE_URL + "/param/xmlasync/{key}")
		.resolveTemplate("key", "secretkey")
		.request(MediaType.APPLICATION_XML)
				.async()
				.get(new InvocationCallback<SimpleProperty>() {
					@Override
					public void completed(SimpleProperty p) {
						System.out.println("Got a "+p);
					}
					@Override
					public void failed(Throwable t) {
						//. . .
					}
				});

	}

}
