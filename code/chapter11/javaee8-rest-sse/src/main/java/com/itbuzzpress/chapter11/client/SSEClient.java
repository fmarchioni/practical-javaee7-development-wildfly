package com.itbuzzpress.chapter11.client;

import java.util.ArrayList;
import java.util.Collection;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.Resource;
import javax.ejb.Schedule;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.ejb.Timeout;
import javax.ejb.Timer;
import javax.ejb.TimerConfig;
import javax.ejb.TimerService;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.sse.SseEventSource;

@Singleton
@Startup
public class SSEClient {
	Client sseClient;
	WebTarget target;
	SseEventSource eventSource;
	@Resource 
	TimerService timerService;

	public ArrayList<String> listUsers;

	@PostConstruct
	public void init() {

		this.sseClient = ClientBuilder.newClient();
		this.target = this.sseClient.target("http://localhost:8080/jaxrs21sse-1.0/rest/events");

		timerService.createSingleActionTimer(5000, new TimerConfig());
		System.out.println("SSE client timer created");

		// Server side event source 
		eventSource = SseEventSource.target(target).build();
		System.out.println("SSE Event source created........");

	}

	public void addUser(String username) {
		listUsers.add(username);
	}

	public void removeUser(String username) {
		listUsers.remove(username);
	}

	public ArrayList<String> getListUsers() {
		return listUsers;
	}

	@Timeout
	public void client() {

		try {
			eventSource.register((sseEvent) -> {
				System.out.println("SSE event recieved ----- " + sseEvent.readData());
			}, (e) -> e.printStackTrace());

			eventSource.open();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@PreDestroy
	public void close() {
		eventSource.close();
		System.out.println("Closed SSE Event source..");
		sseClient.close();
		System.out.println("Closed JAX-RS client..");
	}

}