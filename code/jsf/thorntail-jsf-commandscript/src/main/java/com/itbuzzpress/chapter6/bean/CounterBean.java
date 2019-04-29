package com.itbuzzpress.chapter6.bean;

import java.io.Serializable;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;

 
@Named
@RequestScoped
public class CounterBean implements Serializable {


    private String input;
    private Integer total;
    
    
	
    

    public CounterBean() {
        // NOOP
    }

 

    public String getInput() {
		return input;
	}

	public void setInput(String input) {
		this.input = input;
	}

	 
	 
    public void count() {
        total = input.length();    
    }



	public Integer getTotal() {
		return total;
	}



	public void setTotal(Integer total) {
		this.total = total;
	}

}
