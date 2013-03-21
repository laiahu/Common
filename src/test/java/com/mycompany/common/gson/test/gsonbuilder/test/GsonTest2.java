package com.mycompany.common.gson.test.gsonbuilder.test;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
  
public class GsonTest2 {  
  
    public static void main(String[] args) {  
        User user = new User();  
        user.setId(1001L);  
        user.setName("zhenlging");  
        User next = new User();  
        next.setId(1002L);  
        next.setName("yangyang");  
        user.setNext(next);  
          
        GsonBuilder builder = new GsonBuilder();  
  
        //不转换没有@Expose注解的字段  
        builder.excludeFieldsWithoutExposeAnnotation();  
        Gson gson = builder.create();  
          
        //将对象转换为JSON字符串  
        String sUserString = gson.toJson(user);  
        System.out.println(sUserString);  
          
        User user2 = gson.fromJson(sUserString, User.class);  
        System.out.println("USER_ID: " + user2.getId() + "    USER_NAME:" + user2.getNext().getName());  
          
    }  
      
}  