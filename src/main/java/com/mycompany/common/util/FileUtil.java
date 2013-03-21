package com.mycompany.common.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

import org.apache.commons.io.IOUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class FileUtil {

    private static final Log log = LogFactory.getLog(FileUtil.class);

    public static synchronized void moveFile(File srcFile, File directory) {

        renameFile(srcFile, new File(directory, srcFile.getName()));
    }

    public static synchronized void renameFile(File srcFile, File newFile) {

        // 不存在退出
        if (srcFile.exists()) {
            // 文件名相同退出
            if (srcFile.equals(newFile)) {
                return;
            }

            try {
                org.apache.commons.io.FileUtils.forceMkdir(newFile.getParentFile());
            } catch (Exception e) {
            	log.warn("mkdir conflict error, but nothing! ["+ newFile.getParentFile() + "] ");
            }

            org.apache.commons.io.FileUtils.deleteQuietly(newFile);
            try {
                org.apache.commons.io.FileUtils.moveFile(srcFile, newFile);
            } catch (IOException e) {
                log.error("move file [" + srcFile.getAbsolutePath() + "] error", e);
            }
            org.apache.commons.io.FileUtils.deleteQuietly(srcFile);

        }
    }

    public static synchronized void moveFiles(List<File> srcFiles,
            File directory) {

        for (File file : srcFiles) {
            moveFile(file, directory);
        }
    } 
    
    
	public static String getContent(File file){
		String resultStr = "";
		if(file == null || !file.exists()){
			return resultStr;
		}
		BufferedReader reader = null;
		try{
			StringBuffer strBuf = new StringBuffer("");
			FileInputStream inStream = new FileInputStream(file);
			reader = new BufferedReader(new InputStreamReader(inStream));
			//读内容
			String line = "";
			while((line = reader.readLine()) != null){
				strBuf.append(line);
			}
			
			resultStr = strBuf.toString();
		}catch(Exception e){
			log.error("read file error,msg=["+e.getMessage()+"]");
		}finally{
			IOUtils.closeQuietly(reader);
		}
		return resultStr;
	}
}
