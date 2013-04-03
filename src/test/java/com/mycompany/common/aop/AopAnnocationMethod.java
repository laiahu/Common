package com.mycompany.common.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component("aopAnnocationMethod")  
@Aspect
public class AopAnnocationMethod {
	
	@Pointcut("execution( * com.mycompany.common.service..*.*(..))")  
	public void myMethod(){}  
	  
	@Before("execution( * com.mycompany.common.service..*.*(..))")//表示yingjun.service下任何包下任何类任何返回值的任何方法  
	public void beforeMethod(){  
	    System.out.println("annocation AOP: before method...");  
	}  
	@AfterReturning("myMethod()")  
	public void afterReturningMethod(){  
	    System.out.println("annocation AOP: after  Returning  normal...AOP");  
	}  
	@AfterThrowing("myMethod()")  
	public void afterThrowing(){  
	    System.out.println("annocation AOP: after Throwing...");  
	}  
	@Around("myMethod()")  
	public void around(ProceedingJoinPoint joinPoint) throws Throwable{  
		
//		getClassclass: org.springframework.aop.aspectj.MethodInvocationProceedingJoinPoint
//		getTarget: com.mycompany.common.service.impl.UserServiceImpl@17e21e3
//		getThis: com.mycompany.common.service.impl.UserServiceImpl@17e21e3
//		getArgs: [Ljava.lang.Object;@1e2bed8
//		getSignature: void com.mycompany.common.service.UserService.add(User)
//		getSignature: getName:add
//		getKind: method-execution
//		getStaticPart: execution(void com.mycompany.common.service.UserService.add(User))
//		annocation AOP: before method...
//		add user sussess!
//		annocation AOP: method around end！！！！
//		annocation AOP: after  Returning  normal...AOP
		
	    System.out.println("annocation AOP: method around start");  
	    System.out.println("getClass:"+joinPoint.getClass());  //getClassclass: org.springframework.aop.aspectj.MethodInvocationProceedingJoinPoint
	    System.out.println("getTarget: "+joinPoint.getTarget()); //com.mycompany.common.service.impl.UserServiceImpl@17e21e3
	    System.out.println("getThis: "+joinPoint.getThis());  //com.mycompany.common.service.impl.UserServiceImpl@17e21e3
	    System.out.println("getArgs: "+joinPoint.getArgs());  //getArgs: [Ljava.lang.Object;@1e2bed8
	    System.out.println("getSignature: "+joinPoint.getSignature()); //getSignature: void com.mycompany.common.service.UserService.add(User)
	    System.out.println("getSignature: getName:"+joinPoint.getSignature().getName()); //		getSignature: getName:add
	    System.out.println("getKind: "+joinPoint.getKind());   //getKind: method-execution
	    System.out.println("getStaticPart: "+joinPoint.getStaticPart()); //getStaticPart: execution(void com.mycompany.common.service.UserService.add(User))
	    System.out.println("joinPoint.getTarget().getClass().getName():"+joinPoint.getTarget().getClass().getName());
	    
	    joinPoint.proceed(); 
	    
	    System.out.println("annocation AOP: method around end！！！！");  
	}  
	  

}
