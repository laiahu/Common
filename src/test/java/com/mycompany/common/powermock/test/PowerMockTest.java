package com.mycompany.common.powermock.test;


import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import com.mycompany.common.service.MyService;
import com.mycompany.common.util.SystemTime;
import com.mycompany.common.util.TimeSource;

@RunWith(PowerMockRunner.class)
@PrepareForTest( { MyService.class })
public class PowerMockTest {
//http://code.google.com/p/powermock/
//学习：http://code.google.com/p/powermock/wiki/MockitoUsage13
//http://code.google.com/p/powermock/source/browse/trunk/modules/module-test/easymock/junit4-test/src/test/java/samples/junit4/singleton/MockStaticTest.java	
	@Test
    public void testMockStatic() throws Exception{
		// mock all the static methods in a class called "Static"
		PowerMockito.mockStatic(System.class);
        // use Mockito to set up your expectation
        when(System.currentTimeMillis()).thenReturn(201204L);
        System.out.println(System.currentTimeMillis());    

        assertEquals(201204L, System.currentTimeMillis());
        
	}
	
	
	@Test
    public void testService() throws Exception{
		final long time = 201204L;
		SystemTime.setTimeSource(new TimeSource() {			
			public long millis() {
				return time;
			}
		});
        MyService service = new MyService();        
        assertEquals(time, service.getTime());       
	}
	
	//这种方法更好
	@Test
    public void testUseSystem() throws Exception{
		PowerMockito.mockStatic(System.class);
        // use Mockito to set up your expectation
        when(System.currentTimeMillis()).thenReturn(201204L);
        MyService service = new MyService();        
        assertEquals(201204L, service.getTimeUseSystem());       
	}
	
}
