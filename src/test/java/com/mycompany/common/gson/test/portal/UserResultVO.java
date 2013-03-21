package com.mycompany.common.gson.test.portal;

import java.util.List;

import org.apache.commons.lang.builder.ToStringBuilder;

public class UserResultVO {

	private String rcmsid;
	
	private String result; //SUCCESS 或者 FAILED
	
	private String info = "";
	
	private List<String> whitelist;
	
	private boolean isSub ;
	
	private String parent = "";

	public String getRcmsid() {
		return rcmsid;
	}

	public void setRcmsid(String rcmsid) {
		this.rcmsid = rcmsid;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public String getInfo() {
		return info;
	}

	public void setInfo(String info) {
		this.info = info;
	}

	public List<String> getWhitelist() {
		return whitelist;
	}

	public void setWhitelist(List<String> whitelist) {
		this.whitelist = whitelist;
	}

	public boolean isSub() {
		return isSub;
	}

	public void setSub(boolean isSub) {
		this.isSub = isSub;
	}

	public String getParent() {
		return parent;
	}

	public void setParent(String parent) {
		this.parent = parent;
	}
	
	public String toString(){
		return ToStringBuilder.reflectionToString(this);
	}
	
}
