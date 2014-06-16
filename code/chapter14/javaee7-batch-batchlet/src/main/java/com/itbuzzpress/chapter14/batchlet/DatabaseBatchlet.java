package com.itbuzzpress.chapter14.batchlet;

import javax.batch.api.AbstractBatchlet;
import javax.batch.runtime.context.StepContext;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.itbuzzpress.chapter14.model.User;

 
@Named
@Stateless
public class DatabaseBatchlet extends AbstractBatchlet {

	@Inject StepContext stepContext;

	@PersistenceContext 
	EntityManager em;
	@Override
	public String process() {
		String user = stepContext.getProperties().getProperty("user");
		String password = stepContext.getProperties().getProperty("password");

		User u = new User();
		u.setUser(user);
		u.setPassword(password);

		em.persist(u); 
		System.out.println("User created!");
		return "COMPLETED";
	}

}
