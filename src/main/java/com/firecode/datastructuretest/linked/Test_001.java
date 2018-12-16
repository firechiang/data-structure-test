package com.firecode.datastructuretest.linked;

/**
 * @author JIANG
 */
public class Test_001 {
	
	public static void main(String[] args) {
		Node node5 = new Node("5",null);
		Node node4 = new Node("4",node5);
		Node node3 = new Node("3",node4);
		Node node2 = new Node("2",node3);
		Node node1 = new Node("1",node2);
		iteratorPrint(node1);
		System.err.println("");
		iteratorPrint(sortReverse1(node1));
	}
	
	
	/**
	 * 逆序,从倒数第二个开始向前翻转
	 * @param node
	 * @return
	 */
	private static Node sortReverse1(Node node){
		//链表的最后一个
		if(null == node || null == node.getNext()){
			return node;
		}
		//递归取得最后一个
		Node lastNode = sortReverse1(node.getNext());
		//从倒数第二个取得最后一个，设置下一个为倒数第二个，依次向前翻转。
        node.getNext().setNext(node);  
        //将倒数第二个的下一个置空
        node.setNext(null);  
        //返回最后一个
        return lastNode; 
	}
	
	
	/**
	 * 迭代打印
	 * @param node
	 */
	private static void iteratorPrint(Node node){
		Node firstNode = node;
		while(firstNode.getNext() != null){
			System.err.print(firstNode.getName()+",");
			firstNode = firstNode.getNext();
		}
		System.err.print(firstNode.getName());
	}
	
	/**
	 * 单向链表节点
	 * @author JIANG
	 */
	@SuppressWarnings("unused")
	private static class Node {
		
		private String name;
		
		private Node next;
		

		public Node() {
			super();
		}
		
		public Node(String name, Node next) {
			super();
			this.name = name;
			this.next = next;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public Node getNext() {
			return next;
		}

		public void setNext(Node next) {
			this.next = next;
		}
		
	}

}
