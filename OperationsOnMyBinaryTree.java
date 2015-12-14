import java.util.Scanner;
import yash.mydatastructure.MyBinaryTree;

class OperationsOnMyBinaryTree {
	
	static int getSize(MyBinaryTree T) {
		int size = 0;
		if(T == null) {
			return 0;
		}
		size = getSize(T.getLeftTree()) + 1 + getSize(T.getRightTree());
		return size;
	}
	
	static int getMaximumDepth(MyBinaryTree T) {
		if(T == null) {
			return 0;
		}
		int leftDepth = getMaximumDepth(T.getLeftTree());
		int rightDepth = getMaximumDepth(T.getRightTree());
		if(leftDepth > rightDepth) {
			return leftDepth + 1; 
		} else {
			return rightDepth + 1;
		}
	}
	// Could be done better using stack or queue
	//will implement once finished implementing stack or queue
	static int getMinimumDepth(MyBinaryTree T) {
		if(T == null) {
			return 0;
		}
		if(T.getLeftTree() == null && T.getRightTree() == null) {
			return 1;
		}
		if(T.getLeftTree() == null) {
			return getMinimumDepth(T.getRightTree()) + 1;
		}
		if(T.getRightTree() == null) {
			return getMinimumDepth(T.getLeftTree()) + 1;
		}
		return Math.min(getMinimumDepth(T.getRightTree()), 
						getMinimumDepth(T.getLeftTree())) + 1;
	}
	
	static int getMaxValue(MyBinaryTree T) {
		if(T.getRightTree()==null) {
			return T.getValue();
		} else {
			return getMaxValue(T.getRightTree());
		}
	}
	
	static int getMinValue(MyBinaryTree T) {
		if(T.getLeftTree()==null) {
			return T.getValue();
		} else {
			return getMinValue(T.getLeftTree());
		}
	}
	
	static void printPreOrder(MyBinaryTree T) {
		if(T == null) {
			return;
		}
		System.out.print(T.getValue() + " ");
		printPreOrder(T.getLeftTree());
		printPreOrder(T.getRightTree());
	}
	
	static void printInOrder(MyBinaryTree T) {
		if(T == null) {
			return;
		}
		printInOrder(T.getLeftTree());
		System.out.print(T.getValue()  + " ");	
		printInOrder(T.getRightTree());
	}
	
	static void printPostOrder(MyBinaryTree T) {
		if(T == null) {
			return;
		}
		printPostOrder(T.getLeftTree());
		printPostOrder(T.getRightTree());
		System.out.print(T.getValue()  + " ");	
	}
	
	public static void main(String[] args) {
		int input;
		MyBinaryTree btree = null;
		Scanner s = new Scanner(System.in);
		do {
			System.out.println("------------------------------------------------");
			System.out.println("Select the operation to be performed ...");
			System.out.println("1.Insert value into the tree");
			System.out.println("2.Get Size of the current tree");
			System.out.println("3.Get Maximum depth of the tree");
			System.out.println("4.Get Minimum depth of the tree");
			System.out.println("5.Get Maximum value in the tree");
			System.out.println("6.Get Minimum value in the tree");
			System.out.println("7.Print tree in Pre-order traversal");
			System.out.println("8.Print tree in In-order traversal");
			System.out.println("9.Print tree in Post-order traversal");
			System.out.println("0.Exit");
			System.out.println("------------------------------------------------");
			System.out.print("Enter the input: ");
			input = s.nextInt();
			switch(input) {
				case 0:
					System.exit(0);
				case 1:
					System.out.print("Enter the value to insert: ");
					int value = s.nextInt();
					if(btree == null) {
						btree = new MyBinaryTree(value);
					} else {
						btree.insert(value);
					}
					break;
				case 2:
					System.out.println("Size of the tree is " + getSize(btree));
					break;
				case 3:
					System.out.println("Maximum Depth of the tree is " + getMaximumDepth(btree));
					break;
				case 4:
					System.out.println("Minimum Depth of the tree is " + getMinimumDepth(btree));
					break;
				case 5:
					try {
						if(btree == null) {
							throw new NullPointerException();
						}
						System.out.println("Maximum value in the tree is " + getMaxValue(btree));
					} catch (NullPointerException ex) {
						System.out.println("Exception: Tree cannot be empty");
					}
					break;
				case 6:
					try {
						if(btree == null) {
							throw new NullPointerException();
						}
						System.out.println("Minimum value in the tree is " + getMinValue(btree));
					} catch (NullPointerException ex) {
						System.out.println("Exception: Tree cannot be empty");
					}
					break;
				case 7:
					try {
						if(btree == null) {
								throw new NullPointerException();
							}
						System.out.print("PreOrder Traversal - ");
						printPreOrder(btree);
						System.out.println();
					} catch (NullPointerException ex) {
						System.out.println("Exception: Tree cannot be empty");
					}
					break;
				case 8:
				try {
						if(btree == null) {
								throw new NullPointerException();
							}
						System.out.print("InOrder Traversal - ");
						printInOrder(btree);
						System.out.println();
					} catch (NullPointerException ex) {
						System.out.println("Exception: Tree cannot be empty");
					}
					break;
				case 9:
				try {
						if(btree == null) {
								throw new NullPointerException();
							}
						System.out.print("PostOrder Traversal - ");
						printPostOrder(btree);
						System.out.println();
					} catch (NullPointerException ex) {
						System.out.println("Exception: Tree cannot be empty");
					}
					break;
			}
		} while (input!=0);
	}
}