package com.mycompany.nio.test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

import org.junit.Test;

public class NioTest {

	@Test
	public void test(){
		String charsetStr = System.getProperty("file.encoding");
		System.out.println("charsetStr="+charsetStr);
		String fileStr = "E:\\myfile\\meiya\\mytest.txt";
		File file = new File(fileStr);
		try{
			FileInputStream in = new FileInputStream(file);
			FileChannel fileChannel = in.getChannel();
			//MappedByteBuffer buffer = fileChannel.map(FileChannel.MapMode.READ_ONLY, 0, file.length());
			ByteBuffer buffer = ByteBuffer.allocate(64);
			while(fileChannel.read(buffer) != -1){
				buffer.flip(); //锁定buffer的空白区
				Charset charset = Charset.forName("GBK");
				CharsetDecoder decoder = charset.newDecoder();
				
				CharBuffer cbuff = decoder.decode(buffer);
				System.out.println(cbuff);
				
				//将Buffer初始化，为下一次读取数据做准备				
				buffer.clear();
			}
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
	}
	
	
	@Test
	public void testCopy(){
		String fileStr = "E:\\myfile\\mytest.txt";
		String outFileStr = "E:\\myfile\\cp_mytest.txt";
		File file = new File(fileStr);
		FileChannel fileChannel =  null;
		FileChannel outFileChannel =  null;
		try{
			FileInputStream in = new FileInputStream(file);
			FileOutputStream out = new FileOutputStream(outFileStr);
			fileChannel = in.getChannel();
			outFileChannel = out.getChannel();
			//MappedByteBuffer buffer = fileChannel.map(FileChannel.MapMode.READ_ONLY, 0, file.length());
			ByteBuffer buffer = ByteBuffer.allocate(64);
			while(fileChannel.read(buffer) != -1){
				buffer.flip(); //锁定buffer的空白区
		
				
				
				outFileChannel.write(buffer); //已经写完了.
				System.out.println("position="+buffer.position() +" limit="+buffer.limit() + " capacity="+buffer.capacity());
			
				
			
//				Charset charset = Charset.forName("GBK");
//				CharsetDecoder decoder = charset.newDecoder();
//				
//				CharBuffer cbuff = decoder.decode(buffer);
//				System.out.println(cbuff);
				
				
				//将Buffer初始化，为下一次读取数据做准备				
				buffer.clear();
				//System.out.println("after: position="+buffer.position() +" limit=" + buffer.limit()+" capacity="+buffer.capacity());
			}
		}catch(Exception e){
			System.out.println(e.getMessage());
		}finally{
			try{
				if(fileChannel != null){
					fileChannel.close();
				}
				if(outFileChannel != null){
					outFileChannel.close();
				}
			}catch(Exception e){				
			}
		}
	}
	
	
	@Test
	public void testCharset(){
		Properties props = System.getProperties();
		Set<Map.Entry<Object,Object>> set = props.entrySet();
		for(Map.Entry<Object,Object> entry: set){
			System.out.println(entry.getKey() +" value="+entry.getValue());
		}
	}
}
