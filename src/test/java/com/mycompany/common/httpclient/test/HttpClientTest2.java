package com.mycompany.common.httpclient.test;

import org.junit.Test;

import com.mycompany.common.util.HttpClientHelper;

public class HttpClientTest2 {

	@Test
	public void testHttpClient(){
		String url = "http://www.baidu.com";
		
		String result = HttpClientHelper.sendGet(url);
		System.out.println(result);
	}
}
