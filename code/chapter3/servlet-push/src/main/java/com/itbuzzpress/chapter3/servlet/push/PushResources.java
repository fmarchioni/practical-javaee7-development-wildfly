package com.itbuzzpress.chapter3.servlet.push;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.PushBuilder;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by usta on 12.02.2017.
 */
@WebServlet(value = { "/http2" })
public class PushResources extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		PushBuilder pushBuilder = req.newPushBuilder();
		if (pushBuilder != null) {
			pushBuilder.path("css/style.css").push();
			pushBuilder.path("css/myscript.js").push();

		}
		try (PrintWriter respWriter = resp.getWriter();) {
			respWriter.write("<html><head>" + "<link rel=\"stylesheet\" href=\"css/style.css\"></head>"
					+ "<script src=\"css/myscript.js\"></script><body onload=\"hello()\"></body></html>");
		}

	}
}