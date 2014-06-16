package com.itbuzzpress.chapter14.exception;

public class IllegalItemException extends IllegalArgumentException {
   public int getItem() {
		return item;
	}
int item;
   public IllegalItemException(String error, int item) {
	   super(error);
	   this.item = item;
   }
}
