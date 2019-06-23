package com.firecode.datastructuretest.concurrent;

import java.util.concurrent.atomic.AtomicBoolean;

/**
 * 原子变量简单操作
 * @author JIANG
 *
 */
public class AtomicTest {
	
	static AtomicBoolean ab = new AtomicBoolean(false);
	
	public static void main(String[] args) {
		// 如果值是true，我们就修改成false，返回是否修改成功
		boolean compareAndSet = ab.compareAndSet(true, false);
		System.err.println(compareAndSet);
	}

}
