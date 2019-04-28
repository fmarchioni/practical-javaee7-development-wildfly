package com.itbuzzpress.json.service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import javax.json.bind.Jsonb;
import javax.json.bind.JsonbBuilder;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.itbuzzpress.json.model.Person;

@Path("/jsonb")
public class JsonService {

	@POST
	@Path("/tojava")
	public Response createJava(@FormParam("json") String json) {
		Response response;

		Jsonb jsonb = JsonbBuilder.create();

		Person p = jsonb.fromJson(json, Person.class);
		System.out.println("Created Person " + p);
		response = Response.ok(p.toString()).build();

		return response;
	}

	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/tojson")
	public Response createJson(@FormParam("name") String name, @FormParam("surname") String surname,
			@FormParam("address") String address, @FormParam("city") String city) {
		Response response;
		Person p = new Person(name, surname, address, city);

		Jsonb jsonb = JsonbBuilder.create();
		String jsonString = jsonb.toJson(p);
		response = Response.ok(jsonString).build();

		return response;
	}
}
