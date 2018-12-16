package com.firecode.datastructuretest;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

import com.firecode.datastructuretest.map.ConcurrentXHashMap;

public class MapTest extends BaseTest {

	@Test
	public void test1() {
		Map<String, String> map = new ConcurrentXHashMap<>();
		map.put("1", "1");
		map.put("2", "2");
		p(map);
	}
	
	public void test2(){
		Map<String,String> map = new HashMap<>();
		map.put("1", "1");
		map.put("2", "2");
		p(map);
	}

}
