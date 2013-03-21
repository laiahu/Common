package com.mycompany.common.gson.test.complex;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Test;

import com.google.gson.Gson;
import com.mycompany.common.gson.test.channel.ChannelVO;

public class ComplexGsonTest {

	@Test
	public void testComplex() throws Exception{
		ComplexVO complexVO = new ComplexVO();
		
		String complexName = "mycomplex";
		Date date = new Date();
		
		UserVO userVO = new UserVO();
		String userName = "myusername";
		String userPwd = "myuserpwd";
		userVO.setUserName(userName);
		userVO.setUserPwd(userPwd);
		
		UserVO userVO2 = new UserVO();
		String userName2 = "myusername2";
		String userPwd2 = "myuserpwd2";
		userVO2.setUserName(userName2);
		userVO2.setUserPwd(userPwd2);
		
		List<UserVO> voList = new ArrayList<UserVO>();
		voList.add(userVO);
		voList.add(userVO2);
		
		complexVO.setComplexName(complexName);
		complexVO.setDate(date);
		complexVO.setVoList(voList);
		
		Gson gson = new Gson();
		String jsonStr = gson.toJson(complexVO);
		
		System.out.println("toJsonStr="+jsonStr);
		
		ComplexVO resultVO = gson.fromJson(jsonStr, ComplexVO.class);
		System.out.println(" fromjson to vo="+resultVO);
	}
	
	
	@Test
	public void testComplexList() throws Exception{
		//{"complexName":"mycomplex","voList":[{"userName":"myusername","userPwd":"myuserpwd"},{"userName":"myusername2","userPwd":"myuserpwd2"}],"date":"2012-5-23 17:40:28"}
		String arrJsonStr = "[{\"complexName\":\"mycomplex\",\"voList\":[{\"userName\":\"myusername\",\"userPwd\":\"myuserpwd\"},{\"userName\":\"myusername2\",\"userPwd\":\"myuserpwd2\"}],\"date\":\"2012-5-23 17:40:28\"}]";
				
		java.lang.reflect.Type type = new com.google.gson.reflect.TypeToken<List<ComplexVO>>() {}.getType();
		
		Gson gson = new Gson();
		List<ComplexVO> complexvoList = gson.fromJson(arrJsonStr, type);
		System.out.println(" fromjson list to vo="+complexvoList);
	}
}
