package com.mycompany.common.util;

import java.io.IOException;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.conn.ClientConnectionManager;
import org.apache.http.conn.scheme.Scheme;
import org.apache.http.conn.scheme.SchemeRegistry;
import org.apache.http.conn.ssl.SSLSocketFactory;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.protocol.HTTP;
import org.apache.http.util.EntityUtils;

/**
 * https的访问
 * @author myhello
 *
 */
public class HttpClientSSLHelper {

	private static Log log = LogFactory.getLog(HttpClientSSLHelper.class);
	
	private static X509TrustManager trustManager= new X509TrustManager() {
		public void checkClientTrusted(X509Certificate[] xcs, String string) throws CertificateException {
			
		}

		public void checkServerTrusted(X509Certificate[] xcs, String string) throws CertificateException {
		}

		public X509Certificate[] getAcceptedIssuers() {
			return null;
		}
	};
	
	
	public static HttpClient getInstance() throws KeyManagementException, NoSuchAlgorithmException {
		HttpClient client = new DefaultHttpClient();
		SSLContext ctx = SSLContext.getInstance("SSL");
		//SSLContext ctx = SSLContext.getInstance("TLS");
		ctx.init(null, new TrustManager[] { trustManager }, null);
		SSLSocketFactory ssf = new SSLSocketFactory(ctx);
		// 忽略掉HostName的比较，否则访问部分地址可能会报异常
		ssf.setHostnameVerifier(SSLSocketFactory.ALLOW_ALL_HOSTNAME_VERIFIER);
		ClientConnectionManager ccm = client.getConnectionManager();
		SchemeRegistry sr = ccm.getSchemeRegistry();
		sr.register(new Scheme("https", 443, ssf));
		client = new DefaultHttpClient(ccm, client.getParams());
		return client;
	}
	
	/**
	 * String url = "https://gw.api.tbsandbox.com/router/rest?access_token=6202723ef75c646474c9beef7605ba6ZZ432c453e2ef6003592950033&method=taobao.user.get&v=2.0&fields=user_id,nick,sex,seller_credit,buyer_credit,type,has_more_pic,item_img_num,item_img_size,prop_img_num,prop_img_size,auto_repost,promoted_type,status,alipay_bind,consumer_protection,avatar,liangpin,sign_food_seller_promise,has_shop,is_lightning_consignment,has_sub_stock,is_golden_seller,vip_info,magazine_subscribe,vertical_market,online_gaming&format=json";
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
		//HttpClient httpclient = new DefaultHttpClient();
		HttpClient httpclient = null;
		try {			
			httpclient = HttpClientSSLHelper.getInstance();
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
			resultStr = "get_url_error";
			log.error("get url=[" + url + "] error, error msg=[" + e.getMessage() + "]");
		} finally {
			if(httpclient != null){
				httpclient.getConnectionManager().shutdown();
			}
			
		}
		
		return resultStr;
	}
}
