package com.itbuzzpress.chapter16.ejb;

import java.util.concurrent.Future;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.annotation.security.RolesAllowed;
import javax.ejb.*;

import com.itbuzzpress.chapter16.exception.InsufficientFundsException;
 

@Stateful
@Remote(Account.class)
@RolesAllowed("employee")
@org.jboss.ejb3.annotation.SecurityDomain("other")
public class AccountEJB implements Account {

    long money;
 
    
	@Override
	public long getMoney() {
		return money;

	}

	public void createAccount(long amount)  
	{
		this.money= amount;
		 
	}

	@Override
	public void deposit(long amount)  
	{
		 
			this.money+= amount;
			 
		System.out.println("Money deposit. total is "+money);
	}
 
	 
	@Override
	public void withdraw(long amount) throws InsufficientFundsException {
		
		long newAmount = money - amount;
		if (newAmount < 0) {
			throw new InsufficientFundsException("Unsufficient funds for account! ");
		}
		
		money = newAmount;	 
		System.out.println("Money withdrawal. total is "+money);

	}
}
