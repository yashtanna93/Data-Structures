package yash.mydatastructure;

public class MyBinaryTree {
	private MyBinaryTree left;
	private MyBinaryTree right;
	private int p;
	
	public MyBinaryTree (int n) {
		p = n;
	}
	
	public int getValue () {
		return p;
	}
	
	public MyBinaryTree getLeftTree() {
		return left;
	}
	
	public MyBinaryTree getRightTree() {
		return right;
	}
	
	public void insert(int n) {
		if(n <= p) {
			if(left == null) {
				left = new MyBinaryTree(n);
			} else {
				left.insert(n);
			}
			
		} else {
			if(right == null) {
				right = new MyBinaryTree(n);
			} else {
				right.insert(n);
			}
		}
	}
}