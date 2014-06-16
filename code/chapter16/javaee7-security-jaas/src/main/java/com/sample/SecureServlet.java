package com.sample;

import java.io.IOException;
import java.io.PrintWriter;

import java.util.concurrent.ScheduledThreadPoolExecutor;

import javax.annotation.Resource;
import javax.ejb.EJB;

import javax.enterprise.concurrent.ManagedExecutorService;
import javax.servlet.AsyncContext;
import javax.servlet.AsyncEvent;
import javax.servlet.AsyncListener;
import javax.servlet.ServletException;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@ServletSecurity(value = @HttpConstraint(rolesAllowed = { "employee" }), httpMethodConstraints = {
		@HttpMethodConstraint(value = "GET", rolesAllowed = "employee"),
		@HttpMethodConstraint(value = "POST", rolesAllowed = { "employee" }) })
@WebServlet("/SecureServlet")
public class SecureServlet extends HttpServlet {

	public SecureServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		PrintWriter out = response.getWriter();
		out.write("Hello from Secure Servlet");
		out.close();

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
