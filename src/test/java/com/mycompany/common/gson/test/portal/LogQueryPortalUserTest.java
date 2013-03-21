package com.mycompany.common.gson.test.portal;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.junit.Test;

import com.google.gson.Gson;

public class LogQueryPortalUserTest {

	@Test
	public void testCheckUser() throws Exception{
		
		//返回的字符串： {"rcmsid":"2922","result":"SUCCESS","info":"","whitelist":[],"isSub":false,"parent":""}
		String resultJsonStr = "";
		String url = "http://www.mycompany.com/public-api/checkin.action?username=myuser&pwd=MTE3YjU2ZTlhNmNl";
		HttpClient httpclient = new DefaultHttpClient();
		try {
			HttpGet httpget = new HttpGet(url);
			HttpResponse response = httpclient.execute(httpget);
			if(response.getEntity() != null){
				//返回结果字符串
				resultJsonStr = EntityUtils.toString(response.getEntity());
				System.out.println("resultJsonStr="+resultJsonStr);
			}
		} finally {
			httpclient.getConnectionManager().shutdown();
		}
		//String resultJsonStrMy = "{\"rcmsid\":\"2922\",\"result\":\"SUCCESS\",\"info\":\"\",\"whitelist\":[127.0.0],\"isSub\":false,\"parent\":\"\"}";
		testToVO(resultJsonStr);
		
	}
	
	@Test
	public void testResultJsonStrWithInternalList(){ //whitelist有数据
		String resultJsonStr = "{\"rcmsid\":\"2922\",\"result\":\"SUCCESS\",\"info\":\"\",\"whitelist\":[\"192.168.1.1\",\"192.168.1.2\"],\"isSub\":false,\"parent\":\"\"}";
		testToVO(resultJsonStr);
	}
	
	
	public void testToVO(String resultJson){
		Gson gson = new Gson();		
		//java.lang.reflect.Type type = new com.google.gson.reflect.TypeToken<List<UserResultVO>>() {}.getType();
		UserResultVO vo = gson.fromJson(resultJson,UserResultVO.class);
		System.out.println(vo);
		System.out.println("===whiteList=======");
		System.out.println(vo.getWhitelist());
		//System.out.println(vo.getWhitelist().size());
		if(vo.getWhitelist() != null && vo.getWhitelist().size() > 0){
			System.out.println(" > 0");
		}
	}
	
	
	
	
	
}
