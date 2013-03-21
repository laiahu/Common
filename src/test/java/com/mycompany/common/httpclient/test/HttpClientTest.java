package com.mycompany.common.httpclient.test;

import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.protocol.HTTP;
import org.apache.http.util.EntityUtils;
import org.junit.Test;

import com.google.gson.Gson;
import com.mycompany.common.gson.test.complex.UserVO;

public class HttpClientTest {

	/**
	 * 获得结果
	 * @throws Exception
	 */
	@Test  //get请求
	public void testHttpClientGet() throws Exception{
		String url = "http://172.16.29.69:8080/css/wenti/wenti!upToS.action";
		HttpClient httpclient = new DefaultHttpClient();
		try {
			HttpGet httpget = new HttpGet(url);
			HttpResponse response = httpclient.execute(httpget);
			if(response.getEntity() != null){
				//返回结果字符串
				String resultStr = EntityUtils.toString(response.getEntity());
				System.out.println("resultSrr="+resultStr);
			}
		} finally {
			httpclient.getConnectionManager().shutdown();
		}
	}
	
	@Test  //post请求
	public void testHttpPost() throws Exception{
		String url = "http://192.168.6.31:8080/mypro/testAction.do";
		HttpClient httpclient = new DefaultHttpClient();
		HttpPost httpost = new HttpPost(url);
		
		//参数值
		String jsonValStr = "{\"userName\":\"myhello\"}";
		
		List <NameValuePair> nvps = new ArrayList <NameValuePair>();
        nvps.add(new BasicNameValuePair("channelConfig", jsonValStr)); //参数名
        //nvps.add(new BasicNameValuePair("IDToken2", "password"));
        httpost.setEntity(new UrlEncodedFormEntity(nvps, HTTP.UTF_8));

        HttpResponse response = httpclient.execute(httpost);
        HttpEntity entity = response.getEntity();

//        System.out.println("Login form get: " + response.getStatusLine());
//        System.out.println("Login form getContentLength: " + entity.getContentLength());
//        System.out.println("Login form getContent: " + entity.getContent());
        try{
        	//EntityUtils.consume(entity);
        	if(entity != null){
        		String resultStr = EntityUtils.toString(entity);
        		System.out.println("resultSrr="+resultStr);
        	}
        }catch(Exception e){
        	System.out.println(e.getMessage());
        }finally {
			httpclient.getConnectionManager().shutdown();
		}
	}
	
	
	@Test  //单个对象情况
	public void testToGson() throws Exception{
		
		UserVO  userVO = new UserVO();
		userVO.setUserName("user1");
		userVO.setUserPwd("hellopwd");
		
		Gson gson = new Gson();
		String jsonStr = gson.toJson(userVO);
		System.out.println(jsonStr);		
	}
	
	@Test  //单个对象情况
	public void testFromGson() throws Exception{
		//{"userName":"user1","userPwd":"hellopwd"}
		String jsonStr = "{\"userName\":\"user1\",\"userPwd\":\"hellopwd\"}";
				
		Gson gson = new Gson();
		UserVO userVO = gson.fromJson(jsonStr, UserVO.class);
		System.out.println(userVO);		
	}
	
	@Test //list转化为gson字符串
	public void testToGsonList() throws Exception{
		List<UserVO> voList = new ArrayList<UserVO>();
		UserVO  userVO = new UserVO();
		userVO.setUserName("user1");
		userVO.setUserPwd("hellopwd");
		
		voList.add(userVO);
		
		UserVO  userVO2 = new UserVO();
		userVO2.setUserName("user2");
		userVO2.setUserPwd("hellopwd2");
		
		voList.add(userVO2);
		
		Gson gson = new Gson();
		String jsonStr = gson.toJson(voList);
		System.out.println(jsonStr);		
	}
	
	@Test  //多个值情况： gson(数组)字符串  转化为list对象
	public void testFromGsonList(){  
		//[{"userName":"user1","userPwd":"hellopwd"},{"userName":"user2","userPwd":"hellopwd2"}]
		String jsonStr = "[{\"userName\":\"user1\",\"userPwd\":\"hellopwd\"},{\"userName\":\"user2\",\"userPwd\":\"hellopwd2\"}]";
		java.lang.reflect.Type type = new com.google.gson.reflect.TypeToken<List<UserVO>>() {}.getType();
		
		Gson gson = new Gson();
		List<UserVO> voList = gson.fromJson(jsonStr,type);
		for(UserVO userVO : voList){
			System.out.println(userVO.getUserName() + ";  userpwd="+ userVO.getUserPwd());
		}	
	}

}
