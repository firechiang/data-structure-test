package com.firecode.datastructuretest.concurrent;

import java.lang.reflect.Field;

import sun.misc.Unsafe;

/**
 * @author JIANG
 */
@SuppressWarnings("restriction")
public class UnsafeTest {
	
	public static void main(String[] args) throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException {
		Unsafe unsafe = getUnsafe();
		System.err.println(unsafe);
	}
	
	public static Unsafe getUnsafe() throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException{
		Field field = Unsafe.class.getDeclaredField("theUnsafe");
		// 可获取带有私有构造器对象的实例
		field.setAccessible(true);
		return (Unsafe)field.get(null);
	}
	
	

}
