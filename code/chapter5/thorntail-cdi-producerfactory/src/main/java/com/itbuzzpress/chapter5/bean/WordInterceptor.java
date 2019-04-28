package com.itbuzzpress.chapter5.bean;

import javax.annotation.Priority;
import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;

import com.itbuzzpress.chapter5.model.Word;
import com.itbuzzpress.chapter5.qualifier.AnagramInterceptor;

@AnagramInterceptor
@Interceptor
@Priority(500)
public class WordInterceptor {
    
    @AroundInvoke
    public Object inspect(InvocationContext context) throws Exception {

    	System.out.println("-->"+context.getMethod().getName());
    	System.out.println("data " +context.getContextData());
    	System.out.println("target " +context.getTarget());
    	
    	if (context.getTarget() != null) {
    		Word word = (Word) context.getTarget();
    	    System.out.println("The solution is -->"+word.getSolution());
    	}

        return context.proceed();
    }
}