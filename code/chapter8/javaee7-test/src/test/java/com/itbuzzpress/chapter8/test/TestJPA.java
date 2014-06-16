package com.itbuzzpress.chapter8.test;
 

import java.util.List;

 










import org.junit.Test;
 
import javax.inject.Inject;

import static org.junit.Assert.*;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
 
import org.jboss.shrinkwrap.api.Archive;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.WebArchive;
 
import org.junit.runner.RunWith;

import com.itbuzzpress.chapter8.ejb.ManagerEJB;
import com.itbuzzpress.chapter8.entity.Customer;
import com.itbuzzpress.chapter8.entity.Request;

@RunWith(Arquillian.class)
 
public class TestJPA {
	
	@Inject ManagerEJB ejb;
	
	@Deployment
	    public static Archive<?> createTestArchive() {
	        return ShrinkWrap.create(WebArchive.class, "testjpa.war")
	                .addPackage(Customer.class.getPackage())
	                .addPackage(ManagerEJB.class.getPackage())
	                .addAsResource("META-INF/persistence.xml")
	                .addAsWebInfResource(EmptyAsset.INSTANCE, "beans.xml");
	              
	               
	    }

	@Test
	public void test() {	 
		try {
			
			ejb.createCustomer("john","park avenue 125", "jsmith@gmail.com", "+3955555");
			Customer customer = ejb.findCustomerByName("john");
			List<Customer> cc = ejb.findAllCustomers();
			System.out.println(cc);
			assertNotNull(customer);
			ejb.createRequest("john",100);

			List<Customer> customerList = ejb.findAllCustomers();

			log("=======> Customer List ");
			for (Customer c : customerList) {
				log("Customer found: "+c);
				log("============> Request Accociated:");	
				List<Request> requestList= ejb.findAllRequestsByCustomer(c.getName());
				for (Request r : requestList) {
					log("Request found: "+r);
				}
			}

		} catch (Exception e) {
			System.out.println(e.getClass());
			// TODO Auto-generated catch block
			e.getMessage();
		}  
	}

	private void log(String string) {
		System.out.println(string);
		
	}
	 
}
