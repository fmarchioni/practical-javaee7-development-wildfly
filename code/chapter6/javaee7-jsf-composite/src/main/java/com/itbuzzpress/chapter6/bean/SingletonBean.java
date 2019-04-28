package com.itbuzzpress.chapter6.bean;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;

import com.itbuzzpress.chapter6.model.User;



@Singleton
public class SingletonBean {
	List<User> listUsers;

	@PostConstruct
	public void init() {
		listUsers = new ArrayList();
	}
	public void put(User user) {
		this.listUsers.add(user);

	}
	public void delete(User user) {
		listUsers.remove(user);

	}
	public List<User> getListUsers() {
		return listUsers;
	}
	public void setListUsers(List<User> listUsers) {
		this.listUsers = listUsers;
	}
}
