package com.firecode.datastructuretest.map;

import java.util.Objects;

import org.junit.Test;

import com.firecode.datastructuretest.BaseTest;

public class TestHashMap extends BaseTest {
	
	@Test
	public void test1(){
		new java.util.HashMap();
		System.err.println(Objects.hashCode("1"));
		System.err.println(Objects.hashCode("2"));
		System.err.println(Objects.hashCode("1") ^ Objects.hashCode("2"));
	}
}
