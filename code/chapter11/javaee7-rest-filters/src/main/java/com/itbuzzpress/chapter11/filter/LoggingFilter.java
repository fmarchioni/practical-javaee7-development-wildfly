package com.itbuzzpress.chapter11.filter;

import java.io.IOException;

import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.ext.Provider;

@Provider 
public class LoggingFilter implements ContainerRequestFilter  {

    public void filter(ContainerRequestContext crc) throws IOException {
        
        System.out.println(crc.getMethod() + " " + crc.getUriInfo().getAbsolutePath());
        for (String key : crc.getHeaders().keySet()) {
            System.out.println("[Logging Filter] " +key + ": " + crc.getHeaders().get(key));
        }   
    }	 
}