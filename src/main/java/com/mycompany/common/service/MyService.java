package com.mycompany.common.service;

import com.mycompany.common.util.SystemTime;

public class MyService {

	public long getTime(){
		return SystemTime.asMillis();
	}
	
	public long getTimeUseSystem(){
		return System.currentTimeMillis();
	}
}
