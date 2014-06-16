package com.itbuzzpress.chapter5.interceptors;


import java.io.Serializable;

import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;

import com.itbuzzpress.chapter5.qualifier.Auditing;

 

@Interceptor
@Auditing
public class AuditInterceptor implements Serializable {

    
    @AroundInvoke
     public Object logMethodEntry(InvocationContext ctx) throws Exception {
           System.out.println("Before entering method:" + ctx.getMethod().getName());
           return ctx.proceed();
     }
}