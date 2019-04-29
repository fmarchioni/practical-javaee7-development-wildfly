package com.itbuzzpress.chapter15.job;

import java.util.Map;
import java.util.concurrent.Callable;

  

public class CallableTask implements Callable<Long> {
	private long id;

	public CallableTask(long id) {
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
