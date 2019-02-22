package com.firecode.datastructuretest.list;

import java.util.List;

import org.junit.Test;

import com.firecode.datastructuretest.BaseTest;

public class TestList extends BaseTest{

	
	@Test
	@SuppressWarnings("rawtypes")
	public void test() {
		List list = new ArrayList(1);
		list.add("123");
		list.add("124");
		list.add("125");
		list.add("126");
		list.add("127");
		list.add("128");
		list.remove(2);
		List jdkList = new java.util.ArrayList<Object>();
		jdkList.add("aaa");
		jdkList.add("bbb");
		jdkList.add("ccc");
		System.err.println(list);
		System.err.println(list.size());
	}
	
	@Test
	public void test2() {
		Object[] object = {};
		int max = Math.max(10, 1);
		System.err.println(max);
	}

}
