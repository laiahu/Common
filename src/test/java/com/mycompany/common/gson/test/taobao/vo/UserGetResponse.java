package com.mycompany.common.gson.test.taobao.vo;

import java.io.Serializable;

import com.google.gson.annotations.SerializedName;

public class UserGetResponse implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4420344799713108177L;
	
	@SerializedName("user_get_response")
	private UserWrapper userGetResponse;

	public UserWrapper getUserGetResponse() {
		return userGetResponse;
	}

	public void setUserGetResponse(UserWrapper userGetResponse) {
		this.userGetResponse = userGetResponse;
	}
	
	
}
