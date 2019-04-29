package com.itbuzzpress.chapter5.bean;

import java.io.Serializable;

import javax.inject.Named;

 
@Named
public interface Rules extends Serializable{
	public int getMaxAttempts();
}
