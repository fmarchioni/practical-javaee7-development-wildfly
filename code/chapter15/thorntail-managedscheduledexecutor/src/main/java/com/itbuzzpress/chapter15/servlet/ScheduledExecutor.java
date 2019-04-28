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

import com.itbuzzpress.chapter15.job.SimpleTask;
 
/**
 * Servlet implementation class Test
 */
@WebServlet("/ScheduledExecutor")
public class ScheduledExecutor extends HttpServlet {
 
    @Resource(name ="DefaultManagedScheduledExecutorService")
    ManagedScheduledExecutorService scheduledExecutor;

    
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter writer = response.getWriter();
		
		ScheduledFuture<?> futureResult = scheduledExecutor.schedule(new SimpleTask(),
				10,TimeUnit.SECONDS);

		
		writer.write("Waiting 10 seconds before firing the task");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
