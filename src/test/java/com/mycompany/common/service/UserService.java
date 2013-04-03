package com.mycompany.common.service;

import com.mycompany.common.model.User;

public interface UserService {
	
	public void add(User user);
	
	public void delete(Integer id);
	
	public void update(User user);
	
}
