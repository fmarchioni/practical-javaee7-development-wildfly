package com.itbuzzpress.chapter14.model;

 

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
@Entity
public class User implements Serializable {


    public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	 

	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

     
    private String user; 
    public String getUser() {
		return user;
	}


	public void setUser(String user) {
		this.user = user;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}




	private String password;
    
}    