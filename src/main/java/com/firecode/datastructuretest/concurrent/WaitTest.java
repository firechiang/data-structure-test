package com.firecode.datastructuretest.concurrent;

import java.util.concurrent.TimeUnit;

/**
 * wait,notify,Thread.sleep 简单测试
 * wait           使线程无限等待（注意：在等待的过程中会释放锁，其它线程可访问）
 * notify         唤醒线程继续执行（注意：在唤醒的过程中不会释放锁）
 * Thread.sleep   使线程有限等待（注意：在等待的过程中不会释放锁，其它线程不可访问）
 * 
 * 一个对象或类某个同步方法被锁住以后，其它函数是否可调用，如果其它函数是同步函数则，不可调用，，如果是非同步函数则，可调用。
 * 注意：一个对象或类只有一把锁
 * @author JIANG
 */
public class WaitTest {
	
	static Lock lock = new Lock();
	
	public static void main(String[] args) throws InterruptedException {
		new Thread(()-> {
			//lock.sleep();
			lock.waitX(true);
		}).start();
		
		TimeUnit.SECONDS.sleep(1);
		
		new Thread(()-> {
			lock.normal();
			lock.waitX(false);
			lock.sleep();
		}).start();
	}
	
	
	public static class Lock {
		
		public synchronized void sleep() {
			try {
				TimeUnit.SECONDS.sleep(100000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.err.println("sleep执行了");
		}
		
		public synchronized void waitX(boolean isWait) {
			if(isWait){
				try {
					this.wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			System.err.println("waitX执行了");
		}
		
		public void normal() {
			System.err.println("normal执行了");
		}
	}
}
