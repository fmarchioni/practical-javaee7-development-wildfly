package com.itbuzzpress.chapter3.servlet.async;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.AsyncContext;
import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "/noblock", urlPatterns = { "/noblock" }, asyncSupported = true)
public class NonBlockingServlet  extends HttpServlet {
	 
 

	public NonBlockingServlet() {
		super();

	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		PrintWriter writer = response.getWriter();
		writer.println("Only GET method available sorry.");
		writer.flush();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		final AsyncContext acontext = request.startAsync();
		final ServletInputStream input = request.getInputStream();

		input.setReadListener(new ExampleReadListener(input, acontext));
		PrintWriter writer = response.getWriter();
		writer.println("Non Blocking Servlet completed. Check logs.");
		writer.flush();
	}

}
