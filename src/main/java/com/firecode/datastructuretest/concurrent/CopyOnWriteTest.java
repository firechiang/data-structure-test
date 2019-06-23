package com.firecode.datastructuretest.concurrent;

import java.util.concurrent.CopyOnWriteArrayList;

/**
 * CopyOnWrite容器（写时复制），推荐读多写少使用，且元素个数较少。
 * 每添加一个元素，先将原数组复制到一个新的数组，然后将元素添加到新数组，最后将新数组替换原数组
 * @author JIANG
 *
 */
public class CopyOnWriteTest {
	
	public static void main(String[] args) {
		CopyOnWriteArrayList<String> cow = new CopyOnWriteArrayList<>();
		/**
		 * 每添加一个元素，先将原数组复制到一个新的数组，然后将元素添加到新数组，最后将新数组替换原数组
		 */
		cow.add("测试");
		System.err.println(cow);
 	}

}
