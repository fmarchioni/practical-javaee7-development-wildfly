package com.itbuzzpress.chapter15.ejb;

import javax.ejb.Stateless;

@Stateless
public class SimpleEJB {

	public long calculate(long id) {
		long summation = 0;
		for (int i = 1; i <= id; i++) {
			summation += i;
		}

		return new Long(summation);
	}

}
