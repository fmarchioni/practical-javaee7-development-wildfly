package com.itbuzzpress.chapter10.ws;


import javax.inject.Inject;
import javax.jws.HandlerChain;

import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;



@WebService
@SOAPBinding(style= SOAPBinding.Style.RPC)
@HandlerChain(file = "handlers.xml")
public class AccountWS implements AccountWSItf{
	@Inject
	AccountManager ejb;

 
	public void newAccount(@WebParam(name = "name") String name) {
		ejb.createAccount(name);

	}

 
	public void withdraw(@WebParam(name = "name") String name,
			@WebParam(name = "amount") long amount) throws RuntimeException {
		ejb.withdraw(name, amount);
	}

 
	public void deposit(@WebParam(name = "name") String name,
			@WebParam(name = "amount") long amount) {
		ejb.deposit(name, amount);
	}

	@WebResult(name = "BankAccount")
	public Account findAccountByName(String name) {
		return ejb.findAccount(name);
	}
}
