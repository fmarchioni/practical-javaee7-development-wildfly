package com.itbuzzpress.chapter5.bean;

import javax.enterprise.inject.Alternative;

@Alternative
public class Hard implements Rules {
	private int maxAttempts = 3;

	public int getMaxAttempts() {
		return maxAttempts;
	}
}
