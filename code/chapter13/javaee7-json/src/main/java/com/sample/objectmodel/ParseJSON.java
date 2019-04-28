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

/**
 * Servlet implementation class Transaction
 */
// @Transactional
@WebServlet("/ParseJSON")
public class ParseJSON extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
	
		PrintWriter writer = response.getWriter();
		
		// File is picked up from the src/main/resources folder of your project
		JsonReader jsonReader = Json.createReader(this.getClass()
				.getClassLoader().getResourceAsStream("data.json"));
		JsonArray array = jsonReader.readArray();

		for (int i = 0; i < array.size(); i++) {
			JsonObject jObj = array.getJsonObject(i);
			writer.write("Found actor " + jObj.getString("name") + " " +jObj.getString("surname") +"\n");
			 
		}
	

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
