package com.mycompany.common.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.apache.commons.io.IOUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class ConfigurableContants {

	private static final String DEFAULT_VALUE = "";

	private static final Log log = LogFactory.getLog(ConfigurableContants.class);

	private static final Properties p = new Properties();

	static {
		init("/system.properties");
	}

	private static void init(String propertyFileName) {
		InputStream inputStream = null;
		try {
			inputStream = ConfigurableContants.class.getResourceAsStream(propertyFileName);
			p.load(inputStream);
		} catch (IOException e) {
			log.error("load " + propertyFileName + " into Contants error");
		} finally {
			IOUtils.closeQuietly(inputStream);
		}
	}

	public static String getProperty(String key, String defaultValue) {
		return p.getProperty(key, defaultValue);
	}

	public static String getProperty(String key) {
		return getProperty(key, DEFAULT_VALUE);
	}

}
