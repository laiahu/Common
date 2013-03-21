package com.mycompany.common.gson.test.taobao.vo;

import java.io.Serializable;

import com.google.gson.annotations.SerializedName;

public class UserWrapper implements Serializable {
	
	private static final long serialVersionUID = -6305118346735631444L;

	@SerializedName("user")
	private TaobaoUser user;

	public TaobaoUser getUser() {
		return user;
	}

	public void setUser(TaobaoUser user) {
		this.user = user;
	}
	
	
}
