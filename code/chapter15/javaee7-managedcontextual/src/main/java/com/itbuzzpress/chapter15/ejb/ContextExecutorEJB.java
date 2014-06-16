package com.itbuzzpress.chapter15.ejb;

 
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.Callable;
 
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
 
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

 

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
 
import javax.ejb.Singleton;
import javax.enterprise.concurrent.ContextService;
 
import javax.enterprise.concurrent.ManagedThreadFactory;

 

@Singleton
public class ContextExecutorEJB {

	private ExecutorService threadPoolExecutor = null;

	@Resource(name = "DefaultManagedThreadFactory")
	ManagedThreadFactory factory;

	@Resource(name = "DefaultContextService")
	ContextService cs;

	public ExecutorService getThreadPoolExecutor() {
		return threadPoolExecutor;
	}

	@PostConstruct
	public void postConstruct() {
		threadPoolExecutor = new ThreadPoolExecutor(5, 10, 5, TimeUnit.SECONDS,
				new ArrayBlockingQueue<Runnable>(10), factory);
	}
	
	public Future<Long> submitJob(Callable<Long> task) {
		Callable<Long> proxy = cs.createContextualProxy(task, Callable.class);
		return getThreadPoolExecutor().submit(proxy);

	}
}
