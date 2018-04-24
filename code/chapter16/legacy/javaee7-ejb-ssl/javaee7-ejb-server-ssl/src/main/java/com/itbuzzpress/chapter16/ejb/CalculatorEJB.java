package com.itbuzzpress.chapter16.ejb;

import java.util.List;
import java.util.Timer;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.annotation.security.RolesAllowed;
import javax.ejb.EJB;
import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.ejb.Timeout;
import javax.ejb.TimerConfig;
import javax.ejb.TimerService;

@Stateless
@Remote(Calculator.class)
@RolesAllowed("employee")
@org.jboss.ejb3.annotation.SecurityDomain("other")
public class CalculatorEJB implements Calculator {
   
	float interest=5;
 
	@Override
	public float calculateInterest(long money) {
	 
	    return money * (1+ (interest/100));
	    
	   
   }
	
	 
	
}
