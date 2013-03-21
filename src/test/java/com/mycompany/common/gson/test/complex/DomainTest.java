package com.mycompany.common.gson.test.complex;

import org.apache.commons.lang.StringUtils;
import org.junit.Test;

public class DomainTest {

	@Test
	public void testUrl(){
			//ftp://www.mycompany
			String url = "mms://www.mycompany";
			String[] split = StringUtils.split(url, ":/");
			if (split.length > 1) {
				System.out.println(split[1]);
			} else {
				System.out.println(url);
			}
	}
}
