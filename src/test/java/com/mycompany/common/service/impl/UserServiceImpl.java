package com.mycompany.common.service.impl;

import org.springframework.stereotype.Service;

import com.mycompany.common.model.User;
import com.mycompany.common.service.UserService;

@Service("userService")
public class UserServiceImpl implements UserService {

	public void add(User user){
		System.out.println("add user sussess!");
	}
	
	public void delete(Integer id){
		System.out.println("delete user fail,throws RuntimeException!");
		int a = 1;
		if(a == 1){
			throw new RuntimeException("delete user excepction: not exist id");
		}
		System.out.println("do delete user");
	}
	
	public void update(User user){
		System.out.println("update user sussess!");
	}
}
