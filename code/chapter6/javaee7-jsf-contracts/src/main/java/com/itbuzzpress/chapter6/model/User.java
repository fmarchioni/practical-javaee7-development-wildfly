package com.itbuzzpress.chapter6.model;

import java.io.Serializable;
 
public class User implements Serializable {
 
	 	 
private String name;
	 
private String surname;
 
private String email;
 
 
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getSurname() {
	return surname;
}
public void setSurname(String surname) {
	this.surname = surname;
}
 
}
