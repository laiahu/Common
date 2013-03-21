package com.mycompany.common.gson.test;

import java.util.List;

import com.google.gson.Gson;

public class GsonTest {

	public static void main(String[] args) {
		test2();
	}
	
	
	public static void test2() {
		String jsonStr = "[{\"channelId\":\"0005\",\"channelName\":\"mycompany.com\"},{\"channelId\":\"1111\",\"channelName\":\"www.mycompany.com\"}]";
		Gson gson = new Gson();
		
		java.lang.reflect.Type type = new com.google.gson.reflect.TypeToken<List<ModelVO>>() {}.getType();
		List<ModelVO> list = gson.fromJson(jsonStr,type);
		for(ModelVO modelVO : list){
			System.out.println(modelVO);
		}
		
	}
	
}
