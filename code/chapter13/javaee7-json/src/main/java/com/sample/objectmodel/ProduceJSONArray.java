package com.sample.objectmodel;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonObject;
import javax.json.JsonReader;
import javax.servlet.ServletException;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ProduceJSONArray")  
public class ProduceJSONArray extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		PrintWriter writer = response.getWriter();
		
		JsonArray jsonArray = Json.createArrayBuilder()
				.add(Json.createObjectBuilder() 
					.add("name", "Nicolas")
					.add("surname", "Cage")
				  .build())
				.add(Json.createObjectBuilder()//Another object builder to build JSON Object.
					.add("name", "John")
					.add("surname", "Travolta")
				  .build()).build();
			Json.createWriter(writer).writeArray(jsonArray);

		 
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
