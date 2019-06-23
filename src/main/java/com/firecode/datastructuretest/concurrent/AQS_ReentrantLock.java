package com.firecode.datastructuretest.concurrent;

import java.util.concurrent.locks.ReentrantLock;

/**
 * AbstractQueuedSynchronizer（简称 AQS）锁的简介
 * AQS两大核心
 * 1，AQS维护了一个 Volatile int state(资源共享状态)
 * 2，一个FIFO（先进先出）线程等待队列（多线程争用资源被阻塞时会进入此队列）
 * 
 * AQS两大资源共享方式
 * 1，Exclusive（独占的，只有一个线程能执行，其它需等待）
 * 2，Share（共享的，多个线程可同时执行，最后释放）
 * 
 * AQS的提供的函数简介
 * isHeldExclusively()                      该线程是否正在独占资源
 * tryAcquire() / tryRelease()              独占的方式获取资源和释放资源（成功返回true失败返回false）
 * tryAcquireShared() / tryReleaseShared()  共享的方式获取资源和释放资源（返回大于0的表示还有可用资源，小于0或等于0表示没有可用资源）
 * 
 * 
 * ReentrantLock 重入锁为例，state 初始值为0，表示未锁定状态，A线程lock时，会调用 tryAcquire() 函数独占该锁并将 state + 1，
 * 其它线程再调用 tryAcquire() 时就会失败，该线程就会进入队列进行等待，直到A线程调用 unlock() 函数使 state = 0（释放）为止，其它线程才有机会获取该锁，
 * 当然在A线程释放锁之前，A线程自己是可以重复获取此锁的（state 会累加）这个就是重入的概念（注意：获取多少次就要释放多少次，这样才能保证state能回到0的状态）
 * 
 * @author JIANG
 */
public class AQS_ReentrantLock {
	
	// true公平锁的方式（先等待先执行），fale非公平锁的方式
	static ReentrantLock lock = new ReentrantLock(true);
	
	public static void main(String[] args) {
		try{
			if(lock.tryLock()){
				System.err.println("执行");
			}
		}finally{
			lock.unlock();
		}
		
	}

}
