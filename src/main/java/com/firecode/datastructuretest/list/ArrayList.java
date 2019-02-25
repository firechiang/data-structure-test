package com.firecode.datastructuretest.list;

import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Set;

/**
 * @author JIANG
 */
public class ArrayList implements List{
	
	private Object[] contentElement;
	private int size;
	
	public ArrayList(){
		this(8);
	}
	
	public ArrayList(int size){
		this.contentElement = new Object[size];
	}

	@Override
	public int size() {
		
		return this.size;
	}

	@Override
	public boolean isEmpty() {
		
		return size == 0;
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
		
		return contentElement;
	}

	@Override
	public Object[] toArray(Object[] a) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean add(Object e) {
		if(this.contentElement.length == size) {
			int newSize = this.size * 2;
			this.contentElement = Arrays.copyOf(this.contentElement, newSize);
		}
		this.contentElement[size++] = e;
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
		if(index >= size){
			throw new RuntimeException("下标越界："+index);
		}
		return contentElement[index];
	}

	@Override
	public Object set(int index, Object element) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void add(int index, Object element) {
		// TODO Auto-generated method stub
	}

	@Override
	public Object remove(int index) {
		if(index >= size){
			throw new RuntimeException("下标越界："+index);
		}
        Object oldValue = this.contentElement[index];
        int numMoved = size - index - 1;
        //删除的不是最后一个
        if (numMoved > 0){
        	/**
        	 * this.contentElement   原始数组
        	 * index+1                                        开始copy位置
        	 * this.contentElement   新数组
        	 * index                 开始填充位置
        	 * numMoved              copy数量
        	 **/
            System.arraycopy(this.contentElement, index+1, this.contentElement, index,numMoved);
        }
        this.contentElement[--size] = null;
        return oldValue;
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

}
