package com.mycompany.thread.test;

import java.util.concurrent.locks.ReentrantLock;

public class Account {

	//定义锁对象
	private final ReentrantLock lock = new ReentrantLock();
	
	private String accountNo;
	private double balance;
	
	public Account(){
		
	}
	
	public Account(String accountNo,double balance){
		this.accountNo = accountNo;
		this.balance = balance;
	}
	
	
	
	public String getAccountNo() {
		return accountNo;
	}

	public void setAccountNo(String accountNo) {
		this.accountNo = accountNo;
	}

	public double getBalance() {
		return balance;
	}


	//提供一个线程安全的draw()方法来完成任务取钱操作
	public void draw(double drawAmount){
		//加锁
		lock.lock();
		try{
			if(balance >= drawAmount){
				System.out.println(Thread.currentThread().getName()+" 取钱成功！吐出钞票："+drawAmount);
			
				try{
					Thread.sleep(1);
				}catch(InterruptedException ex){
					ex.printStackTrace();
				}
				balance -= drawAmount;
				System.out.println(" 余额为:"+balance);
			}else{
				System.out.println(Thread.currentThread().getName()+" 取钱失败!余额不足!");
			}
		}finally{
			//修改完成,释放锁
			lock.unlock();
		}
	}
	
	//省略hashCode()和equals()方法
}
