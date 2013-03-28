package com.mycompany.common.test;

import java.net.InetSocketAddress;
import java.util.Map;
import java.util.Set;

import net.rubyeye.xmemcached.MemcachedClient;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringJUnit4ClassRunner.class)  
@ContextConfiguration(locations="classpath:applicationContext.xml")
@TransactionConfiguration(transactionManager="transactionManager", defaultRollback=false)
@Transactional
//@ContextConfiguration(locations = {"classpath:spring/applicationContext.xml"})
public class SpringTest {  

	@Autowired
	MemcachedClient memcachedClient;
	
	@Test
	public void testMemcachedClient() throws Exception{
		String key = "myhello";
		memcachedClient.set(key, 2, "myhello_val");
		
		//Thread.sleep(3000);
		System.out.println(memcachedClient.get(key));
		//memcachedClient.delete(key);
		System.out.println(memcachedClient.get(key));
		
		Map<InetSocketAddress,Map<String,String>> result = memcachedClient.getStats();
//		Map<InetSocketAddress,Map<String,String>> result = memcachedClient.getStatsByItem("items");
		if(result != null){
			Set<Map.Entry<InetSocketAddress,Map<String,String>>> set =  result.entrySet();
			for(Map.Entry<InetSocketAddress,Map<String,String>> entry : set){
				System.out.println(entry.getValue());
			}
		}
	}
}
