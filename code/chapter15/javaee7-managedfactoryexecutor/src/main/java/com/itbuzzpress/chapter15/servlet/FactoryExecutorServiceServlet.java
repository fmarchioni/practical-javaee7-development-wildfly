package com.itbuzzpress.chapter15.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import javax.annotation.Resource;
import javax.ejb.EJB;
import javax.enterprise.concurrent.ManagedThreadFactory;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/FactoryExecutorServiceServlet")
public class FactoryExecutorServiceServlet extends HttpServlet {
 
 
    @EJB PoolExecutorEJB ejb;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {	
		final PrintWriter writer = response.getWriter();
		writer.write("Invoking ExecutorService. Check Logs.");
		ExecutorService executorService = ejb.getThreadPoolExecutor();
		executorService.execute(new Runnable() {
			public void run() {
				System.out.println("Message from your Executor!");
			}
		});
		
	}
}
