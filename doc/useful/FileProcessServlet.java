package com.meiya.mysei.fileprocess.servlet;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.io.IOUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.meiya.mysei.fileprocess.util.ConfigurableContants;
import com.meiya.mysei.fileprocess.util.DateUtil;
import com.meiya.mysei.fileprocess.util.FileUtil;
import com.meiya.mysei.fileprocess.util.RespResultOutputUtil;
import com.meiya.mysei.fileprocess.util.XmlAndBeanUtil;
import com.meiya.mysei.fileprocess.vo.XmlResultVO;

public class FileProcessServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	private Log log = LogFactory.getLog(FileProcessServlet.class);
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		boolean isMultipart = ServletFileUpload.isMultipartContent(request);
		if (!isMultipart) {
			log.error("表单数据格式不是multipart/form-data，或者非法提交");
			return ;
		}		
		
		// Create a factory for disk-based file items
		DiskFileItemFactory factory = new DiskFileItemFactory();
		// Set factory constraints
		int yourMaxMemorySize = 1024*1024*1024;
		factory.setSizeThreshold(yourMaxMemorySize);
		
		//factory.setRepository(fileTempDirFile);

		// Create a new file upload handler
		ServletFileUpload upload = new ServletFileUpload(factory);

		// Set overall request size constraint
		//upload.setSizeMax(yourMaxRequestSize);
		
		String outputStr = "defaultStr";
		//返回的结果
		Date curDate = new Date();
		XmlResultVO xmlResultVO = new XmlResultVO();
		String name = ""; 
		String receiveTime = DateUtil.date2String(curDate, DateUtil.PATTERN_STANDARD);
		String responseTime = "";
		String contentType = "";
		String content = "";
		
		// Parse the request
		try{
			List items = upload.parseRequest(request);			
			Iterator itr = items.iterator();
			while (itr.hasNext()) {// 循环处理表单元素
				FileItem item = (FileItem) itr.next();	
				if(!item.isFormField()){ //上传文件
					 String fieldName = item.getFieldName();
					 String srcFileName = item.getName();
					 
					 contentType = item.getContentType();
					 boolean isInMemory = item.isInMemory();
					 long sizeInBytes = item.getSize();
					 
					 if(sizeInBytes > 0){ //有上传文件
						 name = srcFileName;
						 File saveFile = processUploadFile(item);
					 
						 //扫描 结果目录文件是否存在标识
						 boolean isExist = false;
						 if(saveFile != null){
							 String scanFileName = srcFileName + ".txt";  //源文件名+".txt"
							 String scanFileTargetDir = ConfigurableContants.getProperty("scan.target.file.dir");
							 File scanFile = new File(scanFileTargetDir, scanFileName);	
							 
							 int tryMaxTimes = Integer.parseInt(ConfigurableContants.getProperty("try.max.times"));
							 int millis = Integer.parseInt(ConfigurableContants.getProperty("every.time.try.interval.in.milliseconds"));  //1000*3;  //10s
							
							 while(!isExist && tryMaxTimes > 0 ){
								 tryMaxTimes--;
								 if(!scanFile.exists()){
									 Thread.sleep(millis);
								 }else{
									 isExist = true;
								 }
							 }	
							 
							 if(isExist){ //返回字符串xml字符串
								 content = FileUtil.getContent(scanFile);
							 }
							 responseTime = DateUtil.date2String(curDate, DateUtil.PATTERN_STANDARD);
							 
						 }
						 
						 log.info("isExist=["+isExist+"]"+ "fieldName=["+fieldName+"] "+"srcFileName=["+srcFileName+"] contentType=["+contentType+"] isInMemory=["+isInMemory+"] sizeInBytes=["+sizeInBytes+"]");
						 
					 }
					 
					 
				}
			}
		}catch(Exception e){
			log.error("error msg=["+e.getMessage()+"]");
			return;
		}
		
		//返回xml字符串
		xmlResultVO.setName(name);
		xmlResultVO.setReceiveTime(receiveTime);
		xmlResultVO.setResponseTime(responseTime);
		xmlResultVO.setContentType(contentType);
		xmlResultVO.setContent(content);
		
		String xmlStr = XmlAndBeanUtil.object2XmlString(xmlResultVO);
		log.info("xmlStr=["+xmlStr+"]");
		RespResultOutputUtil.outputStrToResponse(xmlStr, response);
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doGet(req, resp);
	}

	
	private File processUploadFile(FileItem item){
		InputStream inStream = null;
		FileOutputStream outputStream = null;
		File tempFile = null;
		File saveFile = null;
		
		String srcFileName = item.getName();
		String saveFileName = srcFileName;
		String tempFileName = saveFileName + ".tmp";

		try {
			// 临时目录
			String tempDirStr = ConfigurableContants.getProperty("file.upload.temp.dir");
			File tempDirFile = new File(tempDirStr);
			if (!tempDirFile.exists()) {
				tempDirFile.mkdirs();
			}

			inStream = item.getInputStream();

			tempFile = new File(tempDirStr, tempFileName);
			outputStream = new FileOutputStream(tempFile);
			IOUtils.copy(inStream, outputStream);
		} catch (Exception e) {
			log.error("processUploadFile fail,msg=[" + e.getMessage() + "]");
			tempFile = null;
		} finally {
			IOUtils.closeQuietly(inStream);
			IOUtils.closeQuietly(outputStream);			
		}
		// 保存最终的文件名
		if (tempFile != null) {
			String saveDirStr = ConfigurableContants.getProperty("file.upload.save.dir");
			saveFile = new File(saveDirStr, saveFileName);
			FileUtil.renameFile(tempFile, saveFile);
		}
		
		return saveFile;
	}
	
	

}
