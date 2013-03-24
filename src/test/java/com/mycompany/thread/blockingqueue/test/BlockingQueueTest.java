package com.mycompany.thread.blockingqueue.test;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class BlockingQueueTest {

	public static void main(String[] args) {
		
		//创建一个容易为1的BlockingQueue
		BlockingQueue<String> bq = new ArrayBlockingQueue<String>(1);
		
		//启动3个生产者线程
		new Producer(bq).start();
		new Producer(bq).start();
		new Producer(bq).start();
		
		//启动一个消费者线程
		new Consumer(bq).start();
	}
}
