package com.itbuzzpress.chapter5.bean;

import javax.enterprise.inject.Alternative;

@Alternative
public class Simple implements Rules {
	private int maxAttempts = 6;

	public int getMaxAttempts() {
		return maxAttempts;
	}
}
