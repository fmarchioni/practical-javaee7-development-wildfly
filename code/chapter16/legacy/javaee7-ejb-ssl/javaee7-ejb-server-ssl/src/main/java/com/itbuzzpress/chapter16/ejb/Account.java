package com.itbuzzpress.chapter16.ejb;

import com.itbuzzpress.chapter16.exception.InsufficientFundsException;

 
public interface Account {


	public void deposit(long amount);
	public void withdraw(long amount) throws InsufficientFundsException;
	
	public long getMoney();
	public void createAccount(long amount);
}