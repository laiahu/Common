package com.mycompany.util.test;

import org.junit.Test;

import com.google.gson.Gson;
import com.mycompany.common.gson.test.taobao.vo.UserGetResponse;
import com.mycompany.common.util.HttpClientSSLHelper;

public class HttpClientSSLTest {

	@Test
	public void testPost(){
		String url = "https://gw.api.tbsandbox.com/router/rest?access_token=6202723ef75c646474c9beef7605ba6ZZ432c453e2ef6003592950033&method=taobao.user.get&v=2.0&fields=user_id,nick,sex,seller_credit,buyer_credit,type,has_more_pic,item_img_num,item_img_size,prop_img_num,prop_img_size,auto_repost,promoted_type,status,alipay_bind,consumer_protection,avatar,liangpin,sign_food_seller_promise,has_shop,is_lightning_consignment,has_sub_stock,is_golden_seller,vip_info,magazine_subscribe,vertical_market,online_gaming&format=json";
		
		String jsonStr = HttpClientSSLHelper.sendPost(url);
		System.out.println(jsonStr);
		//{"user_get_response":{"user":{"alipay_bind":"bind","auto_repost":"limited","buyer_credit":{"good_num":0,"level":0,"score":0,"total_num":0},"consumer_protection":true,"has_more_pic":true,"has_shop":true,"has_sub_stock":true,"is_golden_seller":false,"is_lightning_consignment":false,"item_img_num":5,"item_img_size":512,"liangpin":false,"magazine_subscribe":false,"nick":"sandbox_mytest8","online_gaming":false,"promoted_type":"authentication","prop_img_num":24,"prop_img_size":1024,"seller_credit":{"good_num":0,"level":0,"score":0,"total_num":0},"sign_food_seller_promise":false,"status":"normal","type":"C","user_id":3592950033,"vertical_market":"3C,shoes"}}}
		
		//错误的返回
		//String url = "https://gw.api.tbsandbox.com/router/rest?access_token=6202723ef75c646474c9beef7605ba6ZZ432c453e2ef6003592950033&method=taobao.user.get&v=2.0&fields=user_id,nick,sex,seller_credit,buyer_credit,type,has_more_pic,item_img_num,item_img_size,prop_img_num,prop_img_size,auto_repost,promoted_type,status,alipay_bind,consumer_protection,avatar,liangpin,sign_food_seller_promise,has_shop,is_lightning_consignment,has_sub_stock,is_golden_seller,vip_info,magazine_subscribe,vertical_market,online_gaming&nick=bandbox_mytest8&format=json";
		//{"error_response":{"code":50,"msg":"Remote service error","sub_code":"isv.user-not-exist:invalid-nick","sub_msg":"根据用户昵称:bandbox_mytest8查询不到对应的用户信息"}}

	}
	
	@Test
	public void testFromJson(){
		String jsonStr = "{\"user_get_response\":{\"user\":{\"alipay_bind\":\"bind\",\"auto_repost\":\"limited\",\"buyer_credit\":{\"good_num\":0,\"level\":0,\"score\":0,\"total_num\":0},\"consumer_protection\":true,\"has_more_pic\":true,\"has_shop\":true,\"has_sub_stock\":true,\"is_golden_seller\":false,\"is_lightning_consignment\":false,\"item_img_num\":5,\"item_img_size\":512,\"liangpin\":false,\"magazine_subscribe\":false,\"nick\":\"sandbox_mytest8\",\"online_gaming\":false,\"promoted_type\":\"authentication\",\"prop_img_num\":24,\"prop_img_size\":1024,\"seller_credit\":{\"good_num\":0,\"level\":0,\"score\":0,\"total_num\":0},\"sign_food_seller_promise\":false,\"status\":\"normal\",\"type\":\"C\",\"user_id\":3592950033,\"vertical_market\":\"3C,shoes\"}}}";
		Gson gson = new Gson();
		UserGetResponse userGetResponse = gson.fromJson(jsonStr, UserGetResponse.class);
		System.out.println(userGetResponse.getUserGetResponse().getUser());
		
	}
}
