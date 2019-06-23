package com.firecode.datastructuretest.concurrent;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * 线程池简单使用
 * Executors工具类创建线程池（注意：实际生产当中不建议使用，因为它没有限制队列的数量，可能会导致内存溢出）
 * @author JIANG
 */
public class ThreadPoolExecutorTest extends ThreadPoolExecutor {
	
	public ThreadPoolExecutorTest(int corePoolSize, int maximumPoolSize, long keepAliveTime, TimeUnit unit,
			BlockingQueue<Runnable> workQueue, ThreadFactory threadFactory, RejectedExecutionHandler handler) {
		super(corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue, threadFactory, handler);
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// CPU 数量
		int coreProcessors = Runtime.getRuntime().availableProcessors();
		/** 
		 * 创建线程池（建议生产使用）
		 * 
		 * @param corePoolSize     核心线程数
		 * @param maximumPoolSize  最大线程数（CPU密集型计算建议使用 CPU核数加1或乘以2；IO密集型计算建议使用 CPU核数除以(1-0.9)，0.9是阻塞系数一般是0.8到0.9之间）
		 * @param keepAliveTime    线程空闲了，多久之后将其回收
		 * @param unit             线程空闲了，多久之后将其回收的时间单位
		 * @param workQueue        线程队列（建议使用有界队列）
		 * @param threadFactory    线程工厂
		 * @param handler          当线程队列满了的时候我们的拒绝策略（注意：如果线程队列是无界队列的话，是不会执行拒绝策略的）
		 * 
		 */
		ThreadPoolExecutor pool = new ThreadPoolExecutor(coreProcessors,
				                                         coreProcessors * 2, 
				                                         60, 
				                                         TimeUnit.SECONDS, 
				                                         new ArrayBlockingQueue<>(100),
				                                         Executors.defaultThreadFactory(),
				                                         (Runnable r, ThreadPoolExecutor executor)->{
				                                             System.err.println("当线程队列满了，拒绝了");
		                                                 });
		System.err.println(pool);
		// 关闭线程池
		pool.shutdown();
	}

	/**
	 * 线程池里面的线程开始执行前执行
	 */
	@Override
	protected void beforeExecute(Thread t, Runnable r) {
		System.err.println("线程开始执行");
	}

	/**
	 * 线程池里面的线程执行完成后执行
	 */
	@Override
	protected void afterExecute(Runnable r, Throwable t) {
		System.err.println("线程执行结束");
	}
	
}
