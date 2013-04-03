package com.mycompany.common.aop.test;

public class AopMethod {

	public void beforeMethod() {
		System.out.println("AOP: before method...");
	}

	public void afterReturningMethod() {
		System.out.println("AOP: after  Returning  normal...AOP！！！！");
	}

	public void afterMethod() {
		System.out.println("AOP: after  method...AOP！！！！");
	}

	public void afterThrowing() {
		System.out.println("AOP: after Throwing...AOP！！！！");
	}
}
