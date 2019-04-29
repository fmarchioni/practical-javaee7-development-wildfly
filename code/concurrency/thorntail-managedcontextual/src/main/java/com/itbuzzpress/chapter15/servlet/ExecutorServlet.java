package com.itbuzzpress.chapter15.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.security.AccessController;

import javax.ejb.EJB;
import javax.security.auth.Subject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itbuzzpress.chapter15.ejb.ContextExecutorEJB;
import com.itbuzzpress.chapter15.job.CallableTask;
 
 
/**
 * Servlet implementation class Test
 */
@WebServlet("/ExecutorServlet")
public class ExecutorServlet extends HttpServlet {
 
  
    @EJB ContextExecutorEJB ejb;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 Subject subject = 
				 Subject.getSubject(AccessController.getContext());
		if (subject != null)
			System.out.println("getPrincipals is "+subject.getPrincipals());
		
		PrintWriter writer = response.getWriter();
		
		CallableTask task = new CallableTask(5);
		ejb.submitJob(task);
		
		writer.write("Callable Task Submitted!");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
