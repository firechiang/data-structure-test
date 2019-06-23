package com.firecode.datastructuretest.concurrent;

import java.util.concurrent.Exchanger;

/**
 * 线程间交换数据简单实用
 * @author JIANG
 */
public class ExchangerTest {
	
	public static void main(String[] args) {
		
        Exchanger<String> exchanger = new Exchanger<>();
        
        new Thread(()->{
        	String data = "a";
        	try {
				System.out.println("我传递数据: "+data+"，我接收到数据："+ exchanger.exchange(data));
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
        }).start();
        
        new Thread(()-> {
        	String data = "b";
        	try {
        	    System.out.println("我传递数据: "+data+"，我接收到数据："+ exchanger.exchange(data));
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
        }).start();
	}
	
}


