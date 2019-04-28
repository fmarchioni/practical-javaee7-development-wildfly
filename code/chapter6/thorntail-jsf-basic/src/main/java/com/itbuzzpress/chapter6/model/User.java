package com.itbuzzpress.chapter6.model;

import java.io.Serializable;
import javax.validation.constraints.*;

public class User implements Serializable {

	@Size(min = 5, max = 20, message = "Please enter a valid name (5-20 characters)")
	private String name;
	@Size(min = 5, max = 20, message = "Please enter a valid surname (5-20 characters)")
	private String surname;
	@Size(min = 5, message = "Mail size is at least 5 characters")
	@Pattern(regexp = "[a-zA-Z0-9]+@[a-zA-Z0-9]+\\.[a-zA-Z0-9]+", message = "Email format is invalid.")
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
