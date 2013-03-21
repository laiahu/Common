package com.mycompany.common.gson.test.taobao.vo;

import org.junit.Test;

import com.google.gson.Gson;

public class Test1 {

	@Test
	public void test(){
		UserCredit userCredit = new UserCredit();
		userCredit.setScore(1);
		userCredit.setLevel(2);
		userCredit.setGoodNum(3);
		userCredit.setTotalNum(4);
		
		Gson gson = new Gson();
		String json = gson.toJson(userCredit);
		System.out.println(json);
	}
	
	@Test
	public void testFromJson(){
		String json = "{\"level\":2,\"score\":1,\"total_num\":4,\"good_num\":3}";
		Gson gson = new Gson();
		UserCredit userCredit = gson.fromJson(json, UserCredit.class);
		System.out.println("total_num="+userCredit.getTotalNum());
		System.out.println("good_num="+userCredit.getGoodNum());
	}
}
