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

import com.itbuzzpress.chapter15.job.CallableTask;
import com.itbuzzpress.chapter15.job.SimpleTask;
import com.itbuzzpress.chapter15.job.TxCallableTask;
 
 
/**
 * Servlet implementation class Test
 */
@WebServlet("/CallableExecutorServlet")
public class CallableExecutorServlet extends HttpServlet {
 
    @Resource(name = "DefaultManagedExecutorService")
    ManagedExecutorService executor;
    
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter writer = response.getWriter();
		
		Future<Long> futureResult = executor.submit(new CallableTask(5));		 		
		while (!futureResult.isDone()) {
			// Wait
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		try {
			writer.write("Callable Task returned " +futureResult.get());
			 
		} catch ( Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  
		 
	}

	 

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
