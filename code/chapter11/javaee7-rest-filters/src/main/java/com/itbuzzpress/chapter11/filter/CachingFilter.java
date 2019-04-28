package com.itbuzzpress.chapter11.filter;

import java.io.IOException;

import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerResponseContext;
import javax.ws.rs.container.ContainerResponseFilter;
import javax.ws.rs.ext.Provider;

@Provider
public class CachingFilter implements  ContainerResponseFilter {
    
    @Override
    public void filter(ContainerRequestContext crc, ContainerResponseContext crc1) throws IOException {
    	 System.out.println("[Caching filter] Running");
    	if (crc.getMethod().equals("GET")) {    		 
    		crc.getHeaders().add("Cache-Control", "no-store, no-cache, must-revalidate, max-age=0, post-check=0, pre-check=0");
    		crc.getHeaders().add("Expires", "-1"); 
    		}
    }
	 
}
