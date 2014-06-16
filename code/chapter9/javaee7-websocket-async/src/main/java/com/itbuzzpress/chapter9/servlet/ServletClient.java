package com.itbuzzpress.chapter9.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URI;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.websocket.ContainerProvider;
import javax.websocket.SendHandler;
import javax.websocket.SendResult;
import javax.websocket.Session;
import javax.websocket.WebSocketContainer;

import com.itbuzzpress.chapter9.endpoint.WebSocketEndpoint;

/**
 * Servlet implementation class ServletClient
 */
@WebServlet("/connect")
public class ServletClient extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * Default constructor.
	 */
	public ServletClient() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		WebSocketContainer container = ContainerProvider
				.getWebSocketContainer();
		String uri = "ws://localhost:8080/javaee7-websocket-async/hello";
		try {
			final Session session = container.connectToServer(
					WebSocketEndpoint.class, new URI(uri));
			
			    session.getAsyncRemote().sendText("Hello from Async Message", new SendHandler() {
				 
				public void onResult(SendResult result) {
				  if (result.isOK()) {
					  
					  System.out.println("Successfully completed!");
				  }
				}
				});


			out.println("Asynchronous message sent to WebSocket endpoint!");
			out.println("Check Server Logs.");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
