package com.firecode.datastructuretest.tree;

/**
 * 红黑树
 * 特点：
 * 1，根节点是黑色。
 * 2，节点不是红色就是黑色。
 * 3，每个叶子节点是黑色。 [注意：这里叶子节点，是指为空的叶子节点！]。
 * 4，如果一个节点是红色的，则它的子节点必须是黑色的（节点是黑色，子节点必须是红色）。
 * 5，从一个节点到该节点的子孙节点的所有路径上包含相同数目的黑节点。（确保没有一条路径会比其他路径长出俩倍。因而，红黑树是相对是接近平衡的二叉树）
 * @see https://www.cnblogs.com/skywang12345/p/3624343.html
 * @author JIANG
 * @param <T>
 */
@SuppressWarnings("unused")
public class RBTree<T> {
	
	
	private RBTNode<T> root;     // 根结点
	
    /**
     * 左旋（左旋转）：
     * 将当前节点移动到其左孩子节点的位置，右孩子移动到当前节点的位置（主要看这个）。
     * 
     * 当前节点的左孩子移动到当前节点的右孩子的左孩子位置，
     * 当前节点的右孩子的左孩子移动到当前节点的右孩子的右孩子位置。
     * 当前节点的右孩子的右孩子移动到当前节点的右孩子位置。
     * 
     * 对红黑树的节点(x)进行左旋转：
     *    左旋前                                                                        左旋后
     *     
     *      px                              px
     *     /                               /
     *    x                               y                
     *   / \                             / \
     *  lx  y                           x   ry     
     *     / \                         / \
     *   ly  ry                      lx  ly
     * 
     */
	private void leftRotate(RBTNode<T> x) {
	    // 设置x的右孩子为y
	    RBTNode<T> y = x.right;

	    // 将 “y的左孩子” 设为 “x的右孩子”；
	    // 如果y的左孩子非空，将 “x” 设为 “y的左孩子的父亲”
	    x.right = y.left;
	    if (y.left != null)
	        y.left.parent = x;

	    // 将 “x的父亲” 设为 “y的父亲”
	    y.parent = x.parent;

	    if (x.parent == null) {
	        this.root = y;            // 如果 “x的父亲” 是空节点，则将y设为根节点
	    } else {
	        if (x.parent.left == x)
	            x.parent.left = y;    // 如果 x是它父节点的左孩子，则将y设为“x的父节点的左孩子”
	        else
	            x.parent.right = y;    // 如果 x是它父节点的左孩子，则将y设为“x的父节点的左孩子”
	    }
	    // 将 “x” 设为 “y的左孩子”
	    y.left = x;
	    // 将 “x的父节点” 设为 “y”
	    x.parent = y;
	}
	
	/** 
	 * 右旋（右旋转）：
	 * 将当前节点移动到其右孩子节点的位置，左孩子移动到当前节点的位置（主要看这个）。
	 * 
	 * 当前节点的右孩子移动到当前节点的右孩子的右孩子位置，
	 * 当前节点的左孩子的右孩子移动到当前节点的右孩子的左孩子位置。
	 * 当前节点的左孩子的左孩子移动到当前节点的左孩子位置。
	 * 
	 * 对红黑树的节点(y)进行右旋转：
     *       右旋前                                                           右旋后
     *       
     *         py                         py
     *        /                          /
     *       y                          x                  
     *      / \                        / \                    
     *     x   ry                     lx  y  
     *    / \                            / \                
     *   lx  rx                        rx  ry
	 * 
	 */
	private void rightRotate(RBTNode<T> y) {
	    // 设置x是当前节点的左孩子。
	    RBTNode<T> x = y.left;

	    // 将 “x的右孩子” 设为 “y的左孩子”；
	    // 如果"x的右孩子"不为空的话，将 “y” 设为 “x的右孩子的父亲”
	    y.left = x.right;
	    if (x.right != null)
	        x.right.parent = y;

	    // 将 “y的父亲” 设为 “x的父亲”
	    x.parent = y.parent;

	    if (y.parent == null) {
	        this.root = x;            // 如果 “y的父亲” 是空节点，则将x设为根节点
	    } else {
	        if (y == y.parent.right)
	            y.parent.right = x;    // 如果 y是它父节点的右孩子，则将x设为“y的父节点的右孩子”
	        else
	            y.parent.left = x;    // (y是它父节点的左孩子) 将x设为“x的父节点的左孩子”
	    }

	    // 将 “y” 设为 “x的右孩子”
	    x.right = y;

	    // 将 “y的父节点” 设为 “x”
	    y.parent = x;
	}
	

	private static class RBTNode<T> {
		Color color;          // 颜色
        T key;                // 关键字(键值)
        RBTNode<T> left;      // 左孩子
        RBTNode<T> right;     // 右孩子
        RBTNode<T> parent;    // 父结点
        
		public RBTNode() {
			super();
		}
		
		public RBTNode(Color color, T key, RBTNode<T> left, RBTNode<T> right, RBTNode<T> parent) {
			super();
			this.color = color;
			this.key = key;
			this.left = left;
			this.right = right;
			this.parent = parent;
		}
		
		public Color getColor() {
			return color;
		}
		public void setColor(Color color) {
			this.color = color;
		}
		public T getKey() {
			return key;
		}
		public void setKey(T key) {
			this.key = key;
		}
		public RBTNode<T> getLeft() {
			return left;
		}
		public void setLeft(RBTNode<T> left) {
			this.left = left;
		}
		public RBTNode<T> getRight() {
			return right;
		}
		public void setRight(RBTNode<T> right) {
			this.right = right;
		}
		public RBTNode<T> getParent() {
			return parent;
		}
		public void setParent(RBTNode<T> parent) {
			this.parent = parent;
		}
	}
	
	/**
	 * 颜色
	 * @author JIANG
	 */
	public static enum Color{
		RED,BLACK;
	}

}
