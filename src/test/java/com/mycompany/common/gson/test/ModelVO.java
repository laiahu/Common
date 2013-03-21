package com.mycompany.common.gson.test;

import com.google.gson.annotations.SerializedName;

public class ModelVO {

	//@SerializedName("name")
	private String channelId;

	private String channelName ="www.aaa.com";

	private String channelType ="channelType";

	private String userId ="1111";

	private String userName = "myuserName";

	public String getChannelId() {
		return channelId;
	}

	public void setChannelId(String channelId) {
		this.channelId = channelId;
	}

	public String getChannelName() {
		return channelName;
	}

	public void setChannelName(String channelName) {
		this.channelName = channelName;
	}

	public String getChannelType() {
		return channelType;
	}

	public void setChannelType(String channelType) {
		this.channelType = channelType;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	public String toString(){
	    return channelId +" " +channelName + " "+channelType +" "+userId+" "+userName;

	}
	
}
