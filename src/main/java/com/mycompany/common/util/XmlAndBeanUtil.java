package com.mycompany.common.util;

import java.io.IOException;
import java.io.StringWriter;

import org.apache.commons.betwixt.io.BeanWriter;
 
 
public class XmlAndBeanUtil {

	/**
	 * 将对象转换为xml字符串
	 */
	public static String object2XmlString(Object object) {
		String xmlString = null;
		// 创建一个输出流，将用来输出Java转换的XML文件
		StringWriter outputWriter = new StringWriter();
		// 输出XML的文件头
		//outputWriter.write("<?xml version='1.0' ?>\n");
		// 创建一个BeanWriter实例，并将BeanWriter的输出重定向到指定的输出流
		BeanWriter beanWriter = new BeanWriter(outputWriter);
		// 配置BeanWriter对象
		beanWriter.getXMLIntrospector().getConfiguration().setAttributesForPrimitives(false);
		beanWriter.getBindingConfiguration().setMapIDs(false);
		beanWriter.setWriteEmptyElements(false);
		
		try {
			beanWriter.write(object);
		} catch (Exception e) {
			e.printStackTrace();
		}
		xmlString = outputWriter.toString();
		// 关闭输出流
		try {
			outputWriter.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return xmlString;
	}
        
 

}


