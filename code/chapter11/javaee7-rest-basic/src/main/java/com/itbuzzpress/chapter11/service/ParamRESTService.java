package com.itbuzzpress.chapter11.service;



import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;















import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.container.AsyncResponse;
import javax.ws.rs.container.Suspended;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

import com.itbuzzpress.chapter11.ejb.DataList;
import com.itbuzzpress.chapter11.model.SimpleProperty;



//http://localhost:8080/rest-javaee7/rest/simple/json

@Path("/param")
public class ParamRESTService {
    String RESPONSE_OK="<p>Property has been added ! </p>" +
		"<p><a href=\"http://localhost:8080/javaee7-rest-basic\">Back</a></p>";
    
	@Inject DataList ejb;

	@GET
	@Path("/xml/{id}")
	@Produces(MediaType.APPLICATION_XML)
	public SimpleProperty getPropertyByPathParam(@PathParam("id")int id) 
	{
		return ejb.getList().get(id);
	}

	@GET
	@Path("/xml")
	@Produces(MediaType.APPLICATION_XML)
	public SimpleProperty getPropertyByQueryId(@QueryParam("id") int id) 
	{
		return ejb.getList().get(id);
	}
	@GET
	@Path("/list")
	@Produces(MediaType.APPLICATION_XML)
	public List<SimpleProperty> getProperty() 
	{
		return ejb.getList();
	}
	@POST
	@Produces("text/html")
	public Response createProperty(@FormParam("key")String key,
			@FormParam("value")String value)
	{	 
		int n = ejb.addToList(key,value);	 
		return Response.ok(RESPONSE_OK).build();	 

	}  
 
}
