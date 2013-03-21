package com.mycompany.common.gson.test.channel;

import java.util.List;

import com.google.gson.Gson;
import com.mycompany.common.gson.test.ModelVO;

public class GsonMapTest {

	public static void main(String[] args) {
		String jsonStr = "[{\"code\":\"0005\",\"name\":\"http://www.mycompany.com\"}]";
		
		Gson gson = new Gson();
		
		java.lang.reflect.Type type = new com.google.gson.reflect.TypeToken<List<ChannelVO>>() {}.getType();
		List<ChannelVO> list = gson.fromJson(jsonStr,type);
		for(ChannelVO channelVO : list){
			System.out.println(channelVO);
		}		
	}
}
