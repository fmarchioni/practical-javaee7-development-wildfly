package com.itbuzzpress.chapter5.decorator;

import java.io.Serializable;

import javax.decorator.Decorator;
import javax.decorator.Delegate;
import javax.inject.Inject;


@Decorator
public class PlayerDecorator implements PlayerItf,Serializable {
	 
	
	@Inject @Delegate PlayerItf player;

	
	public void check()  {	 
	    System.out.println("[Decorator] User check with "+player.getGuess());
	    player.check();
	    
	}
	public String getGuess() {
		return player.getGuess();
	}
	public void setGuess(String guess) {
		player.setGuess(guess.toUpperCase());
	}   

}
