package com.itbuzzpress.chapter11.handler;

import java.net.HttpURLConnection;

import javax.ws.rs.container.AsyncResponse;
import javax.ws.rs.container.TimeoutHandler;
import javax.ws.rs.core.Response;

import com.itbuzzpress.chapter11.model.SimpleProperty;

public class MyTimeoutHandler implements TimeoutHandler {

	@Override
	public void handleTimeout(AsyncResponse asyncResp) {
		Response r = Response.serverError().status( HttpURLConnection.HTTP_UNAVAILABLE).build( );
		asyncResp.resume( r );
		   
	}

}
