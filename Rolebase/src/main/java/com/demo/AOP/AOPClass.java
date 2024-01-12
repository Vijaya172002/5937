package com.demo.AOP;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class AOPClass {
	

	@Pointcut("execution(* com.demo.*.*.*(..))")
	//@Pointcut("execution(* com.app.EmpTaskList.insert())")
	public void logPointcut(){
	}

	@Before("logPointcut()")
	@After("logPointcut()")
	public void logAllMethodCallsAdvice(){
	System.out.println("method invoke");
	}
	}


