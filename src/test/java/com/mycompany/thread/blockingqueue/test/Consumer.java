package com.mycompany.thread.blockingqueue.test;

import java.util.concurrent.BlockingQueue;

public class Consumer extends Thread{

	private BlockingQueue<String> bq;
	
	public Consumer(BlockingQueue<String> bq){
		this.bq = bq;
	}
	
	public void run(){
		while(true){
			System.out.println(getName()+" 消费者准备消集合元素!");
			try{
				Thread.sleep(200);
				//尝试取出元素,如果队列已空，则线程被阻塞
				bq.take();
			}catch(Exception ex){
				ex.printStackTrace();
			}
			System.out.println(getName()+" 消费完成"+bq);
		}
	}
}
