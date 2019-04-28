package com.itbuzzpress.chapter14.listener;

import javax.batch.api.chunk.listener.AbstractItemReadListener;
import javax.inject.Named;

@Named
public class BatchItemReadListener extends AbstractItemReadListener {

	    @Override
	    public void beforeRead() throws Exception {       
	        System.out.println("BatchItemReadListener.beforeRead");
	    }

	    @Override
	    public void afterRead(Object item) throws Exception {	       
	        System.out.println("BatchItemReadListener.afterRead: " + item);	      
	    }

	    @Override
	    public void onReadError(Exception ex) throws Exception {	       
	        System.out.println("BatchItemReadListener.onReadError: " + ex.getMessage());
	    }
}