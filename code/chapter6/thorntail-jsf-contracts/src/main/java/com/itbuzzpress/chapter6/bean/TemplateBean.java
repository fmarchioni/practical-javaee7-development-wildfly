package com.itbuzzpress.chapter6.bean;

import java.io.Serializable;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

 
@Named
@SessionScoped
public class TemplateBean implements Serializable {
    
    String contract = "black";

    public String getContract() {
        return contract;
    }

    public void setContract(String contract) {
        this.contract = contract;
    }
    
    public String change(String s) {
    	System.out.println("Change to "+s);
    	this.contract=s;
    	return "index";
    }
 
}
