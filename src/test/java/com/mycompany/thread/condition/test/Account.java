package com.mycompany.thread.condition.test;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class Account {

	//定义锁对象
	private final ReentrantLock lock = new ReentrantLock();
	private final Condition cond = lock.newCondition();
	
	private String accountNo;
	private double balance;
	//标识账户中是否已有存款的旗标
	private boolean flag = false;
	
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

	//国为账户余额不允许修改,所以只为balance提供get方法
	public double getBalance() {
		return balance;
	}
	
	//取钱
	public void draw(double drawAmount){
		lock.lock();
		try{
			if(!flag){
				cond.await();
			}else{
				//执行取钱操作
				System.out.println(Thread.currentThread().getName() + " 取钱:"+drawAmount);
				balance -= drawAmount;
				System.out.println("账户余额为:"+balance);
				//将标识账户中是否已有存款的旗标 设为false
				flag = false;
				//唤醒其他线程
				cond.signalAll();
			}
		}catch(InterruptedException ex){
			ex.printStackTrace();
		}finally{ //使用finally来释放锁
			lock.unlock();
		}
	}
	
	//存钱
	public void deposit(double depositAmount){
		lock.lock();
		try{
			//如果flag为真,表明账户中已经有人存钱进去,存钱方法阻塞
			if(flag){
				cond.await();
			}else{ 
				//执行存款操作
				System.out.println(Thread.currentThread().getName() +" 存款:"+depositAmount);
				
				balance += depositAmount;
				System.out.println("账户余额为:"+balance);
				//将表示账户是否已有存款的旗标设为true
				flag = true;
				cond.signalAll();
			}
			
		}catch(InterruptedException ex){
			ex.printStackTrace();
		}finally{
			lock.unlock();
		}
	}
	
	//此外省略了hashCode和equals方法
}
