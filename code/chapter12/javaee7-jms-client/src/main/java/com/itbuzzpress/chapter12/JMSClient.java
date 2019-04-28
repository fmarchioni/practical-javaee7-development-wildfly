package com.itbuzzpress.chapter12;

import java.util.logging.Logger;
import java.util.Properties;

import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSConsumer;
import javax.jms.JMSContext;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

public class JMSClient {
 

	private static String MESSAGE = "Hello, World!";
	private static String CONNECTION_FACTORY = "jms/RemoteConnectionFactory";
    private static String DESTINATION = "jms/queue/exampleQueue";
 
 

    public static void main(String[] args) throws Exception {

  Context namingContext = null;
		JMSContext context = null;

		try {

			// Set up the namingContext for the JNDI lookup
			final Properties env = new Properties();
			env.put(Context.INITIAL_CONTEXT_FACTORY,
					"org.wildfly.naming.client.WildFlyInitialContextFactory");
			env.put(Context.PROVIDER_URL, "http-remoting://127.0.0.1:8080");
			env.put(Context.SECURITY_PRINCIPAL, "jmsuser");
			env.put(Context.SECURITY_CREDENTIALS, "Password1!");
			namingContext = new InitialContext(env);

			ConnectionFactory connectionFactory = (ConnectionFactory) namingContext
					.lookup(CONNECTION_FACTORY);
			System.out.println("Got ConnectionFactory " + CONNECTION_FACTORY);

			Destination destination = (Destination) namingContext
					.lookup(DESTINATION);
			System.out.println("Got JMS Endpoint " + DESTINATION);

			// Create the JMS context
			context = connectionFactory.createContext("jmsuser", "Password1!");

			context.createProducer().send(destination, MESSAGE);
			System.out.println("Sent message " + MESSAGE);

			// Create the JMS consumer
			JMSConsumer consumer = context.createConsumer(destination);
			// Then receive the same number of messages that were sent

			String text = consumer.receiveBody(String.class, 5000);
			if (text == null) System.out.println("No message Received! Maybe another Consumer listening on the Queue ??");
			System.out.println("Received message with content " + text);
			

		} catch (Exception e) {
			System.out.println(e.getMessage());
			throw e;
		} finally {
			if (namingContext != null) {
				namingContext.close();
			}

			// closing the context takes care of consumer too
			if (context != null) {
				context.close();
			}
		}

    }
}
