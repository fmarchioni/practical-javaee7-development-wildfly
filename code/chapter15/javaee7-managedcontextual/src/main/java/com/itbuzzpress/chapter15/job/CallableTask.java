package com.itbuzzpress.chapter15.job;

import java.security.AccessController;
import java.util.concurrent.Callable;

import javax.security.auth.Subject;

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
		Subject subject = Subject.getSubject(AccessController.getContext());

		logInfo(subject, summation);
		return new Long(summation);
	}

	private void logInfo(Subject subject, long summation) {
		System.out.println("Subject is " + subject);
		if (subject != null)
			System.out.println("Subject is " + subject.getPrincipals());
	}

}
