package com.mycompany.common.gson.test.channel;

import java.net.URL;
import java.util.List;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.junit.Test;

import com.google.gson.Gson;

public class HttpClientAndToGson {

	@Test
	public void testGetFromHttpAndToGson() throws Exception {
		String url = "http://www.mycompany.com/customer/myuser/channels";
		String resultJsonStr = "";
		
//		URL fileUrl = HttpClientAndToGson.class.getResource("/");
//		System.out.println("fileUrl="+fileUrl);
		
		HttpClient httpclient = new DefaultHttpClient();
		try {
			HttpGet httpget = new HttpGet(url);
			HttpResponse response = httpclient.execute(httpget);
			if(response.getEntity() != null){
				//返回结果字符串
				resultJsonStr = EntityUtils.toString(response.getEntity());
				System.out.println("resultSrr="+resultJsonStr);
			}
		} finally {
			httpclient.getConnectionManager().shutdown();
		}
		
		testToChannelVOList(resultJsonStr);
	}
	
	
	public void testToChannelVOList(String resultJsonArrayStr){
		Gson gson = new Gson();
		
		java.lang.reflect.Type type = new com.google.gson.reflect.TypeToken<List<ChannelVO>>() {}.getType();
		List<ChannelVO> list = gson.fromJson(resultJsonArrayStr,type);
		for(ChannelVO channelVO : list){
			System.out.println(channelVO);
		}		
	}
	
	
}
