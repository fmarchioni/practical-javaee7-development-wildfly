package com.itbuzzpress.chapter15.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

import javax.naming.InitialContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.annotation.Resource;
 
import javax.enterprise.concurrent.ManagedExecutorService;
import javax.enterprise.concurrent.ManagedScheduledExecutorService;
import javax.enterprise.concurrent.ManagedThreadFactory;

import com.itbuzzpress.chapter15.job.SimpleTask;




 

/**
 * Servlet implementation class Test
 */
@WebServlet("/FactoryExecutorServlet")
public class FactoryExecutorServlet extends HttpServlet {
 
	@Resource(name ="DefaultManagedThreadFactory")
	ManagedThreadFactory factory;

 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter writer = response.getWriter();
		
		Thread thread = factory.newThread(new SimpleTask());
		thread.setName("My Managed Thread");
		thread.setPriority(Thread.MAX_PRIORITY);
		thread.start();

		writer.write("Thread started. Check logs");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
