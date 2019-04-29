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
import javax.websocket.WebSocketContainer;
import com.itbuzzpress.chapter9.endpoint.WebSocketEncodedEndpoint;
 
 
@WebServlet("/connect")

public class ServletClient extends HttpServlet {
	private static final long serialVersionUID = 1L;
	 
	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ServletClient() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */

	 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 PrintWriter out = response.getWriter();  
		try {
           
			WebSocketContainer container = ContainerProvider.getWebSocketContainer();
			String uri = "ws://localhost:8080/helloencoded";
			container.connectToServer(WebSocketEncodedEndpoint.class, URI.create(uri));
			out.println("Message sent to Encoded WebSocket!");
			out.println("Check Server Logs.");
			 
		} catch (Exception e) {
			e.printStackTrace();
			out.println("Opps! it seems there was an error invoking the WebSocket !"+e.getMessage());
		}  
		 
	}

	 
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
