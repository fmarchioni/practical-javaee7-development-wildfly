package com.itbuzzpress.chapter6.bean;


import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import javax.enterprise.inject.Model;
import javax.enterprise.inject.Produces;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import com.itbuzzpress.chapter6.model.User;


@Model
public class Manager {

	@Inject SingletonBean ejb;

	List<User> userList;

	@PostConstruct
	public void retrieveAllItems() {
		user = new User(); 
		userList = new ArrayList<User>();

	}

	@Produces
	@Named
	User user;

	@Produces
	@Named
	public List<User> getUserList() {
		return ejb.getListUsers();
	}


	public void save() {
		ejb.put(user);
		FacesMessage facesMsg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Added user "+user.getName(), null);
		FacesContext.getCurrentInstance().addMessage(null, facesMsg);
		user = new User(); 

	}

	public void delete(User user) {
		ejb.delete(user);

	}


	public boolean isFull() {
		return (ejb.getListUsers().size() > 0);

	}
}