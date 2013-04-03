package com.mycompany.util.test;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.mycompany.common.service.UserService;
import com.mycompany.common.util.SpringContextHolder;

@RunWith(SpringJUnit4ClassRunner.class)  
@ContextConfiguration(locations="classpath:applicationContext.xml")
//@TransactionConfiguration(transactionManager="transactionManager", defaultRollback=false)
//@Transactional
public class SpringContextHolderTest {

	@Resource
	private UserService userService;
	
	@Test
	public void testGetBean(){ 
		//获得注解的类 (也可用Resource)
		UserService userService_2 = SpringContextHolder.getBean("userService");
		System.out.println("userService_2="+userService_2);
		
		System.out.println("(userService == userService_2) ?= "+(userService == userService_2)); //true
	}
}
