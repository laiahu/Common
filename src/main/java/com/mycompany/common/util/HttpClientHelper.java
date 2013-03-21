package com.mycompany.common.util;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
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

public class HttpClientHelper {

	private static Log log = LogFactory.getLog(HttpClientHelper.class);
	
	public static String ERROR = "get_url_error";
	
	//反馈给css的状态, css那边执行成功 标识, 如果不等于"success",都是失败的
	public static String FEEDBACK_SUCCESS = "success";
	
	/**
	 * 发送http url,获得返回的结果字符串,如果发生错误会返回 HttpClientHelper.ERROR 对应的字符串
	 * @param url
	 * @return
	 */
	public static String sendPost(String url){
		return sendPostWithParameter(url,null);
	}
	
	
	/**
	 * 发送http url,获得返回的结果字符串,如果发生错误会返回 HttpClientHelper.ERROR 对应的字符串
	 * @param url
	 * @param parameters 参数
	 * @return
	 */
	public static String sendPostWithParameter(String url,Map<String,String> parameters){
		String resultStr = "";
		HttpClient httpclient = new DefaultHttpClient();
		try {			
			HttpPost httpost = new HttpPost(url);
			List<NameValuePair> nvps = new ArrayList<NameValuePair>();
			// nvps.add(new BasicNameValuePair("jsonStr", jsonStr)); //参数名
			if(parameters != null && parameters.size() > 0 ){
				for(Map.Entry<String,String> entry : parameters.entrySet()){
					nvps.add(new BasicNameValuePair(entry.getKey(), entry.getValue())); //参数名
				}		
			}
			httpost.setEntity(new UrlEncodedFormEntity(nvps, HTTP.UTF_8));

			HttpResponse response = httpclient.execute(httpost);
			HttpEntity entity = response.getEntity();
			resultStr = EntityUtils.toString(entity); 
		} catch (Exception e) {
			resultStr = HttpClientHelper.ERROR;
			log.error("get url=[" + url + "] error, error msg=[" + e.getMessage() + "]");
		} finally {
			httpclient.getConnectionManager().shutdown();
		}
		
		return resultStr;
	}
	
	
	public static String sendGet(String url){
		String resultStr = "";
		HttpClient httpclient = new DefaultHttpClient();
		try {			
			HttpGet httpGet = new HttpGet(url);

			HttpResponse response = httpclient.execute(httpGet);
			HttpEntity entity = response.getEntity();
			if(entity != null){
				resultStr = EntityUtils.toString(entity); 
			}
			
		} catch (Exception e) {
			log.error("get url=[" + url + "] error, error msg=[" + e.getMessage() + "]");
		} finally {
			httpclient.getConnectionManager().shutdown();
		}
		
		return resultStr;
	}
}
