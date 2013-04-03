package com.mycompany.common.aop.test;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import com.mycompany.common.model.User;
import com.mycompany.common.service.UserService;

@RunWith(SpringJUnit4ClassRunner.class)  
@ContextConfiguration(locations="classpath:applicationContext.xml")
@TransactionConfiguration(transactionManager="transactionManager", defaultRollback=false)
//@Transactional
public class AopTest {

	@Resource
	private UserService userService;
	
	@Test
	public void testAopAnnotation(){
		User user = new User();
		Integer id = 1;
		String userName = "mytest";
		String userPwd = "mytestpwd";
		user.setId(id);
		user.setUserName(userName);
		user.setUserPwd(userPwd);
		
		userService.add(user);
	}
	
	@Test
	public void testDelete(){
		Integer id = 1;
		userService.delete(id);
		System.out.println("delete result");
	}
	
	@Test
	public void testAop(){
		User user = new User();
		Integer id = 1;
		String userName = "mytest";
		String userPwd = "mytestpwd";
		user.setId(id);
		user.setUserName(userName);
		user.setUserPwd(userPwd);
		
		userService.add(user);
	}
	
}
