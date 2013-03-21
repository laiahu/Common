package com.mycompany.common.gson.test.complex;

import java.util.Date;
import java.util.List;

import org.apache.commons.lang.builder.ToStringBuilder;

public class ComplexVO {

	public String complexName;
	
	private List<UserVO> voList;
	
	private Date date;

	public String getComplexName() {
		return complexName;
	}

	public void setComplexName(String complexName) {
		this.complexName = complexName;
	}

	public List<UserVO> getVoList() {
		return voList;
	}

	public void setVoList(List<UserVO> voList) {
		this.voList = voList;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}
	
	
	public String toString(){
		return ToStringBuilder.reflectionToString(this);
	}
}
