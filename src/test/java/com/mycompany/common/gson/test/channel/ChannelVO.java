package com.mycompany.common.gson.test.channel;

import org.apache.commons.lang.builder.ToStringBuilder;

import com.google.gson.annotations.SerializedName;

public class ChannelVO {

	@SerializedName("name")
	public String channelName;
	
	@SerializedName("code")
	public String channelId;

	public String getChannelName() {
		return channelName;
	}

	public void setChannelName(String channelName) {
		this.channelName = channelName;
	}

	public String getChannelId() {
		return channelId;
	}

	public void setChannelId(String channelId) {
		this.channelId = channelId;
	}
	
	public String toString(){
		return ToStringBuilder.reflectionToString(this);
	}
}
