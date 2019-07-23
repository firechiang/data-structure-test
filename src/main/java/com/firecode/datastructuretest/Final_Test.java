package com.firecode.datastructuretest;

import org.springframework.util.ReflectionUtils;
/**
 * Final关键字标识属性，使用反射修改其值问题
 * @author JIANG
 */
public class Final_Test {
	// String非new关键字初始赋值以后，反射不可修改，其它非基础数据类型都可以修改
	public final String name2 = "name2";
	// 使用反射可修改
	public final String name1 = new String("name1");
	// 使用反射可修改，除基础数据类型以外
	public final Integer age  = 1;
	// 构造器赋值使用反射可修改，除基础数据类型以外
	public final String name3;
	
	
	public Final_Test(String name){
		this.name3 = name;
	}
	
	public String getName1() {
		return name1;
	}
	
	public String getName2() {
		return name2;
	}
	
	public String getName3() {
		return name3;
	}
	public Integer getAge() {
		return age;
	}

	public static void main(String[] args) {
		Final_Test a = new Final_Test("name3");
		System.err.println(a.getName1());
		System.err.println(a.getName2());
		System.err.println(a.getName3());
		ReflectionUtils.doWithFields(Final_Test.class, (field)-> {
			field.setAccessible(true);
			if(field.getName().equals("age")){
				field.set(a, 3);
			}else{
				field.set(a, "a");
			}
			//System.err.println(field.get(a));
		});
		System.err.println("----------------------------修改后------------------------");
		System.err.println(a.getName1());
		System.err.println(a.getName2());
		System.err.println(a.getName3());
		System.err.println(a.getAge());
	}
}
