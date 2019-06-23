package com.firecode.datastructuretest.concurrent;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.Future;
import java.util.concurrent.RecursiveTask;

/**
 * 数据截取分段并行计算然后合并
 * 
 * 1，继承 RecursiveAction 用于没有返回结果的任务。
 * 2，继承 RecursiveTask   用于有返回结果的任务。
 * 
 * 下面这个程序是将1+2+3+4+5+6拆分成1+2；3+4；5+6三个部分进行子程序进行计算最后合并
 * @author JIANG
 */
public class ForkJoinTest extends RecursiveTask<Integer> {
	private static final long serialVersionUID = 1L;
	// 阈值
	private static final int THRESHOLD = 2;
	private int start;
	private int end;

	public ForkJoinTest(int start, int end) {
		this.start = start;
		this.end = end;
	}

	@Override
	protected Integer compute() {
		int sum = 0;
		// 判断任务是否足够小
		boolean canCompute = (end - start) <= THRESHOLD;
		if (canCompute) {
			// 如果小于阈值，就进行运算
			for (int i = start; i <= end; i++) {
				sum += i;
			}
		} else {
			// 如果大于阈值，就再进行任务拆分
			int middle = (start + end) / 2;
			// 才分计算分段1
			ForkJoinTest leftTask = new ForkJoinTest(start, middle);
			// 才分计算分段2
			ForkJoinTest rightTask = new ForkJoinTest(middle + 1, end);
			// 执行子任务
			leftTask.fork();
			rightTask.fork();
			// 等待子任务执行完，并得到执行结果
			int leftResult = leftTask.join();
			int rightResult = rightTask.join();
			// 合并子任务
			sum = leftResult + rightResult;

		}
		return sum;
	}
	
	public static void main(String[] args) throws InterruptedException, ExecutionException {
		// 执行池
		ForkJoinPool forkJoinPool = new ForkJoinPool();
		// 任务
		ForkJoinTest task = new ForkJoinTest(1, 6);
		// 执行任务
		Future<Integer> result = forkJoinPool.submit(task);
		// 打印执行结果
		System.err.println(result.get());
	}

}
