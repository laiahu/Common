package com.mycompany.common.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * 可参考:Struts框架中的org.apache.struts.util.TokenProcessor
 * @author 
 *
 */
public class TokenProcessor {
   final static String TOKEN_KEY = "org.mycompany.token";
   private static TokenProcessor instance = new TokenProcessor();
   
   private TokenProcessor(){
	   
   }
   
   public static TokenProcessor getInstance(){
	   return instance;
   }
   
   private long previous;  //最近一次生成令牌环的时间戳
   
   //判断请求参数中的令牌值班是否有效
   public synchronized boolean isTokenValid(HttpServletRequest request){
	   //得到请求的session对象
	   HttpSession session = request.getSession(false);
	   if(session == null){
		   return false;
	   }
	   //从session中取出令牌值
	   String saved = (String)session.getAttribute(TOKEN_KEY);
	   if(saved == null){
		   return false;
	   }
	   
	   //清除session中的令牌值
	   resetToken(request);
	   
	   String token = request.getParameter(TOKEN_KEY);
	   if(token == null){
		   return false;
	   }
	   return saved.equals(token);
	   
	   
   }
   
   //清除session中的令牌值	
   public synchronized void resetToken(HttpServletRequest request){
	   HttpSession session = request.getSession(false);
	   if(session == null){
		   return ;
	   }
	   session.removeAttribute(TOKEN_KEY);
   }
   
   //产生一个新的令牌值班，保存到session中
   public synchronized void saveToken(HttpServletRequest request){
	   HttpSession session = request.getSession();
	   String token = generateToken(request);
	   if(token != null){
		   session.setAttribute(TOKEN_KEY, token);
	   }
   }
   
   //根据用户会话和当前的系统埋单生成一个唯一的的令牌
   public synchronized String generateToken(HttpServletRequest request){
	   HttpSession session = request.getSession();
	   try{
		   byte[] id = session.getId().getBytes();
		   long current = System.currentTimeMillis();
		   if(current == previous){
			   current++;
		   }
		   previous = current;
		   byte[] now = new Long(current).toString().getBytes();
		   
		   MessageDigest md = MessageDigest.getInstance("MD5");
		   md.update(id);
		   md.update(now);
		   return toHex(md.digest());
	   }catch(NoSuchAlgorithmException e){
		   return null;
	   }
   }
   
   //将一个字节数组转换为一个十六进制数字的字符串
   private String toHex(byte buffer[]){
	   StringBuffer sb = new StringBuffer(buffer.length*2);
	   for(int i=0; i < buffer.length; i++){
		   sb.append(Character.forDigit((buffer[i] & 0xf0) >> 4,16));
		   sb.append(Character.forDigit(buffer[i] & 0x0f, 16));
	   }
	   return sb.toString();
   }
   
   //从session中得到令牌值班，如果session中没有保存令牌值，则生成一个新的令牌值值
   public synchronized String getToken(HttpServletRequest request){
	   HttpSession session = request.getSession(false);
	   if(session == null){
		   return null;
	   }
	   String token = (String)session.getAttribute(TOKEN_KEY);
	   if(token == null){
		   token = generateToken(request);
		   if(token != null){
			   session.setAttribute(TOKEN_KEY, token);
			   return token;
		   }else{
			   return null;
		   }
		   
	   }else{
		   return token;
	   }
   }
}
