
public class TreeAlgorithms {

	public static int min(BinaryTreeNode<Integer> node) {

		// Left as a programming project
		if (node == null)
        	return Integer.MAX_VALUE;
    
    	int minLeft = min(node.getLeft());
    	int minRight = min(node.getRight());
    
    	return Math.min(node.getData(), Math.min(minLeft, minRight));

	}

	public static int countLeafs(BinaryTreeNode<Integer> node) {

		// Left as a programming project
		if (node == null)
        	return 0;
    
    	if (node.getLeft() == null && node.getRight() == null)
        	return 1;
    
    	return countLeafs(node.getLeft()) + countLeafs(node.getRight());

	}

	public static int height(BinaryTreeNode<Integer> node) {

		// Left as a programming project
		if (node == null)
        	return -1;
    
    	int leftHeight = height(node.getLeft());
    	int rightHeight = height(node.getRight());
    
    	return 1 + Math.max(leftHeight, rightHeight);

	}

	private static LinkedBinaryTree<Integer> buildTree() {

		LinkedBinaryTree<Integer> leftTree;
		LinkedBinaryTree<Integer> rightTree;

		// construct the left subtree of the binary tree
		LinkedBinaryTree<Integer> t1 = new LinkedBinaryTree<Integer>(1);
		LinkedBinaryTree<Integer> t2 = new LinkedBinaryTree<Integer>(3);
		LinkedBinaryTree<Integer> t3 = new LinkedBinaryTree<Integer>(2, t1, t2);
		t1 = new LinkedBinaryTree<Integer>(5);
		leftTree = new LinkedBinaryTree<Integer>(4, t3, t1);

		// construct the right subtree of the binary tree
		t1 = new LinkedBinaryTree<Integer>(9);
		t2 = new LinkedBinaryTree<Integer>(10, t1, null);
		t3 = new LinkedBinaryTree<Integer>(7);
		rightTree = new LinkedBinaryTree<Integer>(8, t3, t2);

		return new LinkedBinaryTree<Integer>(6, leftTree, rightTree);

	}

	public static void main(String[] args) {

		LinkedBinaryTree<Integer> tree = buildTree();
		System.out.println(tree);

		// Testing min
		if (min(tree.getRoot()) == 1 && min(tree.getRoot().getLeft()) == 1 && min(tree.getRoot().getRight()) == 7)
			System.out.println("Min value test passed");
		else
			System.out.println("Min value test failed");
		

		// Testing count leafs
		if (countLeafs(tree.getRoot()) == 5 && countLeafs(tree.getRoot().getLeft()) == 3
				&& countLeafs(tree.getRoot().getRight()) == 2) 
			System.out.println("Count leafs test passed");
		else 
			System.out.println("Count leafs test failed");
		
		// Testing height
		if (height(tree.getRoot()) == 3 && height(tree.getRoot().getLeft()) == 2
				&& height(tree.getRoot().getRight().getLeft()) == 0)
			System.out.println("Height test passed");
		else
			System.out.println("Height test failed");

	}

}