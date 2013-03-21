package com.mycompany.common.gson.test.gsonbuilder.test;

import java.util.HashMap;  
import java.util.Map;  
  
import com.google.gson.Gson;  
import com.google.gson.GsonBuilder;  
import com.google.gson.reflect.TypeToken;  
  
public class MapTest {  
  public static void main(String[] args) {  
      
      User user1 = new User();  
      user1.setId(1001L);  
      user1.setName("zhengling");  
      User user2 = new User();  
      user2.setId(1002L);  
      user2.setName("yangyang");  
      Map<String, User> userMap = new HashMap<String,User>();  
      userMap.put("user1", user1);  
      userMap.put("user2", user2);  
        
      GsonBuilder builder = new GsonBuilder();  
      Gson gson = builder.create();  
      String sUserMap = gson.toJson(userMap, new TypeToken<Map<String,User>>(){}.getType());  
      System.out.println(sUserMap);  
        
      //创建Type,Type属于java.lang.reflect.Type  
      //Type type = new TypeToken<Map<String, User>>(){}.getType();  
       
      Map<String,User> userMap2 = gson.fromJson(sUserMap, new TypeToken<Map<String, User>>() {}.getType());  
      System.out.println(userMap2.get("user1").getName());  
}  
}  