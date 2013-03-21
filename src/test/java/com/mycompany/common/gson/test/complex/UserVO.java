package com.mycompany.common.gson.test.complex;

import org.apache.commons.lang.builder.ToStringBuilder;

public class UserVO {

	private String userName;
	
	private String userPwd;

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserPwd() {
		return userPwd;
	}

	public void setUserPwd(String userPwd) {
		this.userPwd = userPwd;
	}
	
	public String toString(){
		return ToStringBuilder.reflectionToString(this);
	}
}
