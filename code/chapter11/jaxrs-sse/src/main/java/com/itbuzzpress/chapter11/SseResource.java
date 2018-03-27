package com.itbuzzpress.chapter11;

import java.util.List;
import java.util.Random;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import javax.annotation.Resource;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.sse.OutboundSseEvent;
import javax.ws.rs.sse.Sse;
import javax.ws.rs.sse.SseEventSink;
//import javax.enterprise.concurrent.ManagedExecutorService;
//import javax.enterprise.concurrent.ManagedScheduledExecutorService;
//import javax.enterprise.concurrent.ManagedThreadFactory;

@Path("/events")
public class SseResource {

 
	Executor executorService = Executors.newSingleThreadExecutor();

	// @Resource(name = "DefaultManagedExecutorService")
	// ManagedExecutorService executorService;

 

	@GET
	@Produces(MediaType.SERVER_SENT_EVENTS)
	public void sendEvents(@Context SseEventSink sseEventSink, @Context Sse sse) {
		Random rnd = new Random();
		IntStream rndStream = IntStream.generate(() -> rnd.nextInt(90));
		List<Integer> lottery = rndStream.limit(5).boxed().collect(Collectors.toList());

		executorService.execute(() -> {
			lottery.forEach(value -> {
				try {
					TimeUnit.SECONDS.sleep(5);
					System.out.println("Sending the following value: " + value);
					final OutboundSseEvent outboundSseEvent = sse.newEventBuilder().name("lottery")
							.data(Integer.class, value).build();
					sseEventSink.send(outboundSseEvent);
				} catch (InterruptedException ex) {
					ex.printStackTrace();
				}

			});
			sseEventSink.close();
		});

	}
 
}
