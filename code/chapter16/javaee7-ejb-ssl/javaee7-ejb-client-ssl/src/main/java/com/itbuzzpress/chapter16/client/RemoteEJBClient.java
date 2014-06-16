
package com.itbuzzpress.chapter16.client;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import com.itbuzzpress.chapter16.ejb.Account;
import com.itbuzzpress.chapter16.ejb.Calculator;
import com.itbuzzpress.chapter16.exception.InsufficientFundsException;

import java.util.Hashtable;

public class RemoteEJBClient {

	public static void main(String[] args) throws Exception {

		/*  //////// System properties set in pom.xml 
		 System.setProperty("javax.net.ssl.keyStore",
		 "C:\\wildfly-8.0.0.Final\\standalone\\configuration\\client.keystore");
		 System.setProperty("javax.net.ssl.trustStore",
		 "C:\\wildfly-8.0.0.Final\\standalone\\configuration\\client.truststore");
		 System.setProperty("javax.net.ssl.keyStorePassword", "mypassword");
		 System.setProperty("javax.net.ssl.trustStorePassword", "mypassword");
        */
		
		Account account = lookupAccountEJB();
		Calculator calculator = lookupCalculatorEJB();
		System.out.println("Going to deposit 1000$ ");

		account.createAccount(1000l);

		account.deposit(250);

		try {
			System.out.println("Going to withdraw 500$ ");
			account.withdraw(500);
		} catch (InsufficientFundsException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		long money = account.getMoney();
		System.out.println("Money left " + money);
		float totalMoney = calculator.calculateInterest(money);
		System.out.println("Money plus interests " + totalMoney);

	}

	private static Account lookupAccountEJB() throws NamingException {
		final Hashtable jndiProperties = new Hashtable();
		jndiProperties.put(Context.URL_PKG_PREFIXES,
				"org.jboss.ejb.client.naming");
		final Context context = new InitialContext(jndiProperties);

		return (Account) context
				.lookup("ejb:/javaee7-ejb-server-ssl/AccountEJB!com.itbuzzpress.chapter4.ejb.Account?stateful");
	}

	private static Calculator lookupCalculatorEJB() throws NamingException {
		final Hashtable jndiProperties = new Hashtable();
		jndiProperties.put(Context.URL_PKG_PREFIXES,
				"org.jboss.ejb.client.naming");
		final Context context = new InitialContext(jndiProperties);

		return (Calculator) context
				.lookup("ejb:/javaee7-ejb-server-ssl/CalculatorEJB!com.itbuzzpress.chapter4.ejb.Calculator");
	}
}
