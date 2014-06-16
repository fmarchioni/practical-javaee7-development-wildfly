package com.itbuzzpress.chapter6.flow;

import java.io.Serializable;
import java.util.UUID;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.flow.FlowScoped;
import javax.inject.Named;

@Named
@FlowScoped("confirm")
public class ConfirmBean implements Serializable {
	@PostConstruct
	public void createKey() {
		secretKey = UUID.randomUUID().toString();
		System.out.println("Secret Key is " + secretKey);
	}

	private String key;
	private String secretKey;

	public String getHomeAction() {
		return "/index";
	}

	public String checkKey() {

		if (key.equals(secretKey)) {
			return "confirm2";
		} else {
			FacesContext.getCurrentInstance().addMessage(
					null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "Wrong key!",
							"You have entered a wrong key! "));
			return null;
		}
	}

	public String getSecretKey() {
		return secretKey;
	}

	public void setSecretKey(String secretKey) {
		this.secretKey = secretKey;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}
}
