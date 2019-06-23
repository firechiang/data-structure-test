package com.firecode.datastructuretest.concurrent;

import java.util.concurrent.TimeUnit;

/**
 * volatile 关键字的作用
 * 1，多线程间的可见性
 * 2，阻止指令重排序
 * @author JIANG
 */
public class VolatileTest {
	// 没加 volatile 关键字，程序会一直处于等待状态
	//（注意：代码里面不能含有 synchronized 关键字代码，包括调用JDK里面的代码。因为 synchronized 关键字代码会同步主内存）
	public static int a = 0;
	// 加上 volatile 关键字后程序会在 1 秒后停止
	//public static volatile int a = 0;
	
	public static void main(String[] args) throws InterruptedException {
		// 线程1
		new Thread(()->{
			while(true){
				if(a > 0){
					System.exit(0);
				}
			}
		}).start();
		
		TimeUnit.SECONDS.sleep(1);
		
		// 线程2
		new Thread(()->{
			for(int i=0;i<5;i++){
				a = i;
			}
		}).start();
	}
}
