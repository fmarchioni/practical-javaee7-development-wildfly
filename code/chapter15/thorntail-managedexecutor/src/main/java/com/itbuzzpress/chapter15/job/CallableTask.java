package com.itbuzzpress.chapter15.job;

import java.util.Map;
import java.util.concurrent.Callable;

  

public class CallableTask implements Callable<Long> {
	private int id;

	public CallableTask(int id) {
		this.id = id;
	}

	public Long call() {
		long summation = 0;
		for (int i = 1; i <= id; i++) {
			summation += i;
		}

		return new Long(summation);
	}

}
