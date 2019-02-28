package com.firecode.datastructuretest.linked;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

/**
 * @author JIANG
 */
public class LinkedList implements List {
	
	/**
	 * 数据为空的头节点
	 */
	private Node first = new Node();
	
	private int size;

	@Override
	public int size() {
		
		return size;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean contains(Object o) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Iterator iterator() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object[] toArray() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object[] toArray(Object[] a) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean add(Object e) {
		add(size,e);
		return true;
	}

	@Override
	public boolean remove(Object o) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean containsAll(Collection c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean addAll(Collection c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean addAll(int index, Collection c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean removeAll(Collection c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean retainAll(Collection c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void clear() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Object get(int index) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object set(int index, Object element) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 *  @param index    插入的位置
	 *  @param element  数据
	 */
	@Override
	public void add(int index, Object element) {
		//永远的头节点
		Node p = first;
		//找到插入位置的上一个节点
		for(int i=0;i<index;i++){
			p = p.next;
		}
		Node newNode = new Node(element);
		/** 
		 *  ______      ______       ______
		 * |   1  |    |   2  |     |   3  |
		 * |______|    |______|     |______|
		 *          
		 *          ^
		 *          |  插入 
		 *        ______
		 *       |myNode| 
		 *       |______|
		 *      
		 *  第一部：头节点的下一个就是我的下一个 
		 *  第二部：头节点的下一个就是我  
		 **/
		newNode.next = p.next;
		p.next = newNode;
		size++;
	}
	
	public static void main(String[] args) {
		LinkedList list = new LinkedList();
		list.add("1");
		list.add("2");
		System.err.println(list);
	}

	@Override
	public Object remove(int index) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int indexOf(Object o) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int lastIndexOf(Object o) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public ListIterator listIterator() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ListIterator listIterator(int index) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List subList(int fromIndex, int toIndex) {
		// TODO Auto-generated method stub
		return null;
	}
	
	private static class Node {
		
		private Object data;
		
		private Node next;
		
		public Node() {
			this(null,null);
		}
		
		public Node(Object data){
			this(data,null);
		}

		public Node(Object data, Node next) {
			super();
			this.data = data;
			this.next = next;
		}
	}
	
}
