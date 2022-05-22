package com.rahul.practice.datastructure;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;


interface MyBSTInterface<T extends Number> {

	/*
	 * The first insertion is the root node of a BST. Then based on the data, we
	 * perform recursive insert operations either in the left or right subtree
	 */
	void insert(T value);

	/*
	 * Start with the root and keep moving left or right based on the data that is
	 * either less than or greater than the node data recursively
	 */
	boolean search(T value);

	/*
	 * The smallest element of a BST is the left-most node, which does not has the
	 * left child.
	 */
	T findMin();

	/*
	 * the maximum element is the right-most node, which does not have right child
	 */
	T findMax();

	// Depth first Search: InOrder, PreOrder, PostOrder

	/*
	 * 1) Visit the root node 2) Traverse the left subtree in Preorder 3) Traverse
	 * the right subtree in Preorder
	 */
	void preOrder();

	/*
	 * 1) Traverse the left subtree in inorder. 2) Visit the root. 3) Traverse the
	 * right subtree in Inorder.
	 */
	void inOrder();

	/*
	 * 1) Traverse the left subtree in Postorder. 2) Traverse the right subtree in
	 * Postorder. 3) Visit the root.
	 */
	void postOrder();

	/*
	 * In breadth first search algorithm, we are traversing the binary tree breadth
	 * wise (instead of depth wise)
	 */
	void levelOrder();

	// Method to count leaf nodes
	Integer countLeaf();

	/*
	 * Function to convert binary tree into linked list by altering the right node
	 * and making left node NULL
	 */
	void flatten();

	/*
	 * Function to find the height of BST using string for DFS(Recursive) or
	 * BFS(Iterative)
	 */
	Integer height(String approach);

	/*
	 * Function to find out level having max sum using breadth first search algo.
	 */
	void maxSumLevel();

	/*
	 * Function to find the total sum of nodes
	 */
	Integer totalSum();

	/*
	 * Function to get the size or number of nodes of a BST
	 */
	Integer size();

	// Method to count non-leaf nodes
	Integer countNonLeaf();

	// Method to count non-leaf having only one child nodes
	Integer countNonLeafOneChild();

	// Method to print left view of BST
	void printLeftView();

	// Method to print right view of BST
	void printRightView();

	// Function to check leaf nodes of binary tree are at same level
	Boolean isLeavesAtSameLevel();

	// Function to find the level of node having key as argument
	Integer levelOfNodeInBTree(Integer key);

	/*
	 * The number of nodes at any level gives the width of binary tree
	 */
	// Function to find maximum width of binary tree using BFS
	Integer maxWidth();

	// Function to print binary tree in reverse order
	void printReverse();

	// Function to print spiral or Zigzag binary tree traversal
	void printSpiral();

	// The lowest common ancestor between two nodes n1 and n2 is defined as the
	// lowest node in T that has both n1 and n2 as descendants (where we allow a
	// node to be a descendant of itself).
	void findLCA(Integer node1, Integer node2);
}

class MyBST<T extends Number> implements MyBSTInterface<Integer> {

	class Node {
		Integer key;
		Node left;
		Node right;

		Node(Node left, Integer key, Node right) {
			this.left = left;
			this.key = key;
			this.right = right;
		}

		Node(Integer key) {
			this.key = key;
			this.left = null;
			this.right = null;
		}

		public Integer getKey() {
			return key;
		}

		public Node getLeft() {
			return left;
		}

		public Node getRight() {
			return right;
		}

		public void setKey(Integer key) {
			this.key = key;
		}

		public void setLeft(Node left) {
			this.left = left;
		}

		public void setRight(Node right) {
			this.right = right;
		}
	}

	private Node root;

	MyBST() {
		this.root = null;
	}

	@Override
	public void insert(Integer key) {
		root = insert(root, key);
	}

	private Node insert(Node tempRoot, Integer key) {

		if (tempRoot == null) {
			tempRoot = new Node(key);
		} else {
			if (tempRoot.getKey().compareTo(key) > 0) {
				tempRoot.setLeft(insert(tempRoot.getLeft(), key));
			} else if (tempRoot.getKey().compareTo(key) < 0) {
				tempRoot.setRight(insert(tempRoot.getRight(), key));
			}
		}
		return tempRoot;

	}

	@Override
	public boolean search(Integer key) {

		if (root == null) {
			System.out.println("UnderFlow:");
			return false;
		}

		return search(root, key);
	}

	private boolean search(Node tempRoot, Integer key) {
		boolean flag = false;

		if (tempRoot == null) {
			System.out.println("Not Found");
			return false;
		}
		if (tempRoot.getKey().equals(key)) {
			flag = true;
		} else {
			if (tempRoot.getKey().compareTo(key) > 0) {
				flag = search(tempRoot.getLeft(), key);
			} else if (tempRoot.getKey().compareTo(key) < 0) {
				flag = search(tempRoot.getRight(), key);
			}
		}
		return flag;
	}

	@Override
	public Integer findMin() {
		Integer min = null;
		if (root == null) {
			System.out.println("UnderFlow:");
			return min;
		}
		return findMin(root);
	}

	private Integer findMin(MyBST<T>.Node tempRoot) {

		// loop to left most leaf
		while (tempRoot.getLeft() != null) {
			tempRoot = tempRoot.getLeft();
		}
		return tempRoot.getKey();
	}

	@Override
	public Integer findMax() {
		Integer min = null;
		if (root == null) {
			System.out.println("UnderFlow:");
			return min;
		}
		return findMax(root);
	}

	private Integer findMax(MyBST<T>.Node tempRoot) {

		// loop to right most leaf/node
		// while (tempRoot.getRight() != null) {
		// tempRoot = tempRoot.getRight();
		// }
		// return tempRoot.getKey();

		return tempRoot.getRight() == null ? tempRoot.key : findMax(tempRoot.getRight());
	}

	@Override
	public void preOrder() {
		if (root == null) {
			System.out.println("UnderFlow:");
			return;
		}
		preOrder(root);
	}

	private void preOrder(MyBST<T>.Node tempRoot) {

		if (tempRoot != null) {
			System.out.print("(" + tempRoot.getKey() + ") ");
			preOrder(tempRoot.getLeft());
			preOrder(tempRoot.getRight());
		}
	}

	public List<Integer> preOrderNonRecursive() {
		return preOrderNonRecursive(root);
	}

	public List<Integer> preOrderNonRecursive(Node tempRoot) {
		List<Integer> result = new ArrayList<>();
		if (tempRoot == null) {
			return result;
		}
		Stack<Node> s = new Stack<>();
		s.push(tempRoot);
		while (!s.isEmpty()) {
			Node node = s.pop();
			result.add(node.getKey());
			if (node.getRight() != null) {
				s.push(node.getRight());
			}
			if (node.getLeft() != null) {
				s.push(node.getLeft());
			}
		}
		return result;
	}

	@Override
	public void inOrder() {

		if (root == null) {
			System.out.println("UnderFlow:");
			return;
		}
		inOrder(root);
	}

	private void inOrder(MyBST<T>.Node tempRoot) {
		// if (tempRoot != null) {
		// inOrder(tempRoot.getLeft());
		// System.out.print("(" + tempRoot.getKey() + ") ");
		// inOrder(tempRoot.getRight());
		// }
		Stack<Node> stack = new Stack<>();
		Node curNode = tempRoot;

		while (curNode != null || !stack.isEmpty()) {
			while (curNode != null) {
				stack.push(curNode);
				curNode = curNode.getLeft();

			}
			curNode = stack.pop();
			System.out.print(curNode.getKey());

			curNode = curNode.getRight();
		}
	}

	@Override
	public void postOrder() {
		if (root == null) {
			System.out.println("UnderFlow:");
			return;
		}
		postOrder(root);
	}

	private void postOrder(MyBST<T>.Node tempRoot) {
		// if (tempRoot != null) {
		// postOrder(tempRoot.getLeft());
		// postOrder(tempRoot.getRight());
		// System.out.print("(" + tempRoot.getKey() + ") ");
		// }
		Stack<Node> stackOne = new Stack<>();
		Stack<Node> stackTwo = new Stack<>();
		stackOne.push(tempRoot);
		while (!stackOne.isEmpty()) {
			Node node = stackOne.pop();
			stackTwo.push(node);
			if (node.getLeft() != null) {
				stackOne.push(node.getLeft());
			}
			if (node.getRight() != null) {
				stackOne.push(node.getRight());
			}
		}

		while (!stackTwo.isEmpty()) {
			System.out.print(stackTwo.pop().key);
		}

	}

	@Override
	public Integer countLeaf() {
		if (root == null) {
			return 0;
		}

		// if left and right of the node is null, it is leaf node
		return countLeaf(root);

	}

	private Integer countLeaf(MyBST<T>.Node tempRoot) {

		// for recursion only
		if (tempRoot == null) {
			return 0;
		}

		if (tempRoot.getLeft() == null && tempRoot.getRight() == null) {
			return 1;
		} else {
			return countLeaf(tempRoot.getLeft()) + countLeaf(tempRoot.getRight());
		}
	}

	@Override
	public void flatten() {
		flatten(root);

	}

	public void flatten(Node tempRoot) {

		if (tempRoot == null)
			return;

		if (tempRoot.left == null && tempRoot.right == null)
			return;

		// If tempRoot.left children exists then we have to make it tempRoot.right
		// (where node is root)
		if (tempRoot.left != null) {

			// Move left recursively
			flatten(tempRoot.left);

			// Store the tempRoot.right in tempNode
			Node tempNode = tempRoot.right;
			tempRoot.right = tempRoot.left;
			tempRoot.left = null;

			// Find the position to insert the stored value
			Node curr = tempRoot.right;
			while (curr.right != null) {
				curr = curr.right;
			}

			// Insert the stored value
			curr.right = tempNode;
		}

		// Now call the same function for tempRoot.right
		flatten(tempRoot.right);

	}

	@Override
	public void levelOrder() {
		if (root == null) {
			System.out.println("UnderFlow:");
			return;
		}
		levelOrder(root);

	}

	private void levelOrder(MyBST<T>.Node tempRoot) {
		Queue<Node> queue = new LinkedList<Node>();
		queue.offer(root);

		while (!queue.isEmpty()) {
			Node node = queue.poll();
			System.out.printf("%d ", node.key);
			if (node.left != null) {
				queue.offer(node.left);
			}
			if (node.right != null) {
				queue.offer(node.right);
			}
		}

	}

	@Override
	public Integer height(String approach) {
		Integer height = new Integer(0);
		if (approach.equalsIgnoreCase("DFS")) {
			height = heightUsingDFS(root);
		} else if (approach.equalsIgnoreCase("BFS")) {
			height = heightUsingBFS(root);
		} else {
			System.out.println("Only DFS and BFS approach is allowed");
		}
		return height;
	}

	private Integer heightUsingDFS(MyBST<T>.Node tempRoot) {
		if (tempRoot == null) {
			return 0;
		}

		Integer leftHeight = heightUsingDFS(tempRoot.getLeft());
		Integer rightHeight = heightUsingDFS(tempRoot.getRight());

		return Math.max(leftHeight, rightHeight) + 1;
	}

	private Integer heightUsingBFS(MyBST<T>.Node tempRoot) {

		if (tempRoot == null) {
			return 0;
		}

		Queue<Node> queue = new LinkedList<Node>();
		queue.offer(tempRoot);

		// level delimiter
		queue.offer(null);
		Integer height = 0;

		while (!queue.isEmpty()) {
			Node node = queue.poll();
			if (node == null) {
				if (!queue.isEmpty()) {
					// add again level delimiter to increase height
					queue.offer(null);
				}
				height++;
			} else {
				if (node.getLeft() != null) {
					queue.offer(node.getLeft());
				}
				if (node.getRight() != null) {
					queue.offer(node.getRight());
				}
			}
		}
		return height;
	}

	@Override
	public void maxSumLevel() {
		Node tempRoot = root;
		if (tempRoot == null) {
			System.out.println("UnderFlow:");
			return;
		}
		maxSumLevel(root);
	}

	private void maxSumLevel(MyBST<T>.Node tempRoot) {

		Queue<Node> queue = new LinkedList<>();

		queue.offer(tempRoot);

		// level delimiter
		queue.offer(null);

		Integer maxSum = 0;
		Integer maxLevel = 0;
		Integer localSum = 0;
		Integer localLevel = 0;

		while (!queue.isEmpty()) {
			Node node = queue.poll();
			// Level change
			if (node == null) {

				if (!queue.isEmpty()) {
					// level delimiter
					queue.offer(null);
				}

				if (localSum > maxSum) {
					maxSum = localSum;
					maxLevel = localLevel;
				}

				// prepare for next level calculation
				localSum = 0;
				localLevel++;

			} else {
				if (node.getLeft() != null) {
					queue.offer(node.getLeft());
				}
				if (node.getRight() != null) {
					queue.offer(node.getRight());
				}
				localSum += node.key;
			}
		}
		System.out.println("MaxSum: " + maxSum + " Level:" + maxLevel);
	}

	@Override
	public Integer totalSum() {
		if (root == null) {
			System.out.println("UnderFlow:");
			return 0;
		}
		return totalSum(root);
	}

	private Integer totalSum(MyBST<T>.Node tempRoot) {
		Queue<Node> queue = new LinkedList<>();
		queue.offer(tempRoot);
		Integer totalSum = 0;

		while (!queue.isEmpty()) {
			Node node = queue.poll();
			if (node != null) {
				totalSum += node.key;
			}

			if (node.getLeft() != null) {
				queue.offer(node.getLeft());
			}

			if (node.getRight() != null) {
				queue.offer(node.getRight());
			}
		}
		return totalSum;
	}

	@Override
	public Integer size() {
		if (root == null) {
			System.out.println("UnderFlow:");
			return 0;
		}
		return size(root);
	}

	private Integer size(MyBST<T>.Node tempRoot) {
		Queue<Node> queue = new LinkedList<>();
		queue.offer(tempRoot);
		Integer nodes = 0;

		while (!queue.isEmpty()) {
			Node node = queue.poll();

			if (node.getLeft() != null) {
				queue.offer(node.getLeft());
			}
			if (node.getRight() != null) {
				queue.offer(node.getRight());
			}
			nodes++;
		}
		return nodes;
	}

	@Override
	public Integer countNonLeaf() {
		if (root == null) {
			System.out.println("UnderFlow:");
			return 0;
		}
		return countNonLeaf(root);
	}

	// see countLeaf for recursive approach
	private Integer countNonLeaf(MyBST<T>.Node tempRoot) {

		Queue<Node> queue = new LinkedList<>();
		queue.offer(tempRoot);
		Integer nonLeaf = 0;

		while (!queue.isEmpty()) {
			Node node = queue.poll();
			if (node.getLeft() != null && node.getRight() != null) {
				nonLeaf++;
				queue.offer(node.getLeft());
				queue.offer(node.getRight());
			}
		}

		return nonLeaf;
	}

	@Override
	public Integer countNonLeafOneChild() {
		if (root == null) {
			System.out.println("UnderFlow:");
			return 0;
		}
		return countNonLeafOneChild(root);
	}

	private Integer countNonLeafOneChild(MyBST<T>.Node tempRoot) {
		Queue<Node> queue = new LinkedList<>();
		queue.offer(tempRoot);
		Integer nonLeafOneChild = 0;

		while (!queue.isEmpty()) {
			Node node = queue.poll();
			if (node.getLeft() == null && node.getRight() != null) {
				nonLeafOneChild++;
				queue.offer(node.getRight());
			}

			if (node.getLeft() != null && node.getRight() == null) {
				nonLeafOneChild++;
				queue.offer(node.getLeft());
			}

			if (node.getLeft() != null && node.getRight() != null) {
				queue.offer(node.getLeft());
				queue.offer(node.getRight());
			}
		}
		return nonLeafOneChild;
	}

	@Override
	public void printLeftView() {
		if (root == null) {
			System.out.println("UnderFlow:");
			return;
		}

		printLeftView(root);
	}

	private void printLeftView(MyBST<T>.Node tempRoot) {

		Queue<Node> queue = new LinkedList<>();
		queue.offer(tempRoot);
		// level delimiter
		// queue.offer(null);

		while (!queue.isEmpty()) {
			int size = queue.size();
			int levelNodes = 0;

			while (levelNodes++ < size) {
				Node node = queue.poll();

				// if this is the first node of the current level, print it
				if (levelNodes == 1) {
					System.out.print(node.key + " ");
				}

				if (node.getLeft() != null) {
					queue.offer(node.getLeft());
				}

				if (node.getRight() != null) {
					queue.offer(node.getRight());
				}
			}
		}
	}

	@Override
	public void printRightView() {
		if (root == null) {
			System.out.println("UnderFlow:");
			return;
		}
		printRightView(root);
	}

	private void printRightView(MyBST<T>.Node tempRoot) {
		Queue<Node> queue = new LinkedList<>();
		queue.offer(tempRoot);
		queue.offer(null);

		while (!queue.isEmpty()) {
			int size = queue.size();
			for (int i = 0; i < queue.size(); i++) {
				Node node = queue.poll();

				// Last elemnt of each level
				if (i == size - 1) {
					System.out.println(node.getKey());
				}

				if (node.getLeft() != null) {
					queue.offer(node.getLeft());
				}

				if (node.getRight() != null) {
					queue.offer(node.getRight());
				}
			}
		}
	}

	@Override
	public Boolean isLeavesAtSameLevel() {
		if (root == null) {
			System.out.println("UnderFlow:");
			return false;
		}
		return isLeavesAtSameLevel(root);
	}

	private Boolean isLeavesAtSameLevel(MyBST<T>.Node tempRoot) {
		Queue<Node> queue = new LinkedList<>();
		queue.offer(tempRoot);

		// level delimiter
		queue.offer(null);
		Integer currentLevel = new Integer(0);
		Integer prevLeafLevel = new Integer(0);
		Boolean leafFound = false;

		while (!queue.isEmpty()) {

			Node node = queue.poll();

			// Level change
			if (null == node) {
				if (!queue.isEmpty()) {
					// level delimiter
					queue.offer(null);
				}
				currentLevel++;
			} else {
				if (node.getLeft() == null && node.getRight() == null) {

					// first leaf found
					if (!leafFound) {
						prevLeafLevel = currentLevel;
						leafFound = true;
					} else if (prevLeafLevel != currentLevel) {
						return false;
					}
				}

				if (node.getLeft() != null) {
					queue.offer(node.getLeft());
				}

				if (node.getRight() != null) {
					queue.offer(node.getRight());
				}
			}
		}
		return true;
	}

	@Override
	public Integer levelOfNodeInBTree(Integer key) {
		if (root == null) {
			System.out.println("UnderFlow:");
			return -1;
		}
		return levelOfNodeInBTree(root, key);
	}

	private Integer levelOfNodeInBTree(MyBST<T>.Node tempRoot, Integer key) {
		Queue<Node> queue = new LinkedList<>();
		queue.offer(tempRoot);

		// level delimiter
		queue.offer(null);

		Integer currentLevel = new Integer(0);

		while (!queue.isEmpty()) {
			Node node = queue.poll();

			// level increment/change
			if (node == null) {
				if (!queue.isEmpty()) {
					// level delimiter
					queue.offer(null);
					currentLevel++;
				}
			} else {
				if (node.getKey().compareTo(key) == 0) {

					return currentLevel;
				}
				if (node.getLeft() != null) {
					queue.offer(node.getLeft());
				}
				if (node.getRight() != null) {
					queue.offer(node.getRight());
				}
			}
		}
		return -1;
	}

	@Override
	public Integer maxWidth() {
		if (root == null) {
			System.out.println("UnderFlow:");
			return -1;
		}
		return maxWidth(root);
	}

	private Integer maxWidth(MyBST<T>.Node tempRoot) {
		Queue<Node> queue = new LinkedList<>();
		queue.offer(tempRoot);

		// level delimiter
		queue.offer(null);
		Integer currentLevelNodes = new Integer(1);
		Integer maxNodes = new Integer(1);

		while (!queue.isEmpty()) {
			Node node = queue.poll();
			// level increment/change
			if (node == null) {
				if (!queue.isEmpty()) {
					queue.offer(null);
				}

				if (maxNodes.compareTo(currentLevelNodes) < 0) {
					maxNodes = currentLevelNodes;
				}
				currentLevelNodes = new Integer(0);
			} else {

				if (node.getLeft() != null) {
					queue.offer(node.getLeft());
					currentLevelNodes++;
				}
				if (node.getRight() != null) {
					queue.offer(node.getRight());
					currentLevelNodes++;
				}
			}
		}
		return maxNodes;
	}

	@Override
	public void printReverse() {
		if (root == null) {
			System.out.println("UnderFlow:");
			return;
		}

		printReverse(root);

	}

	private void printReverse(MyBST<T>.Node tempRoot) {
		Queue<Node> queue = new LinkedList<>();
		Stack<Node> stack = new Stack<>();

		queue.offer(tempRoot);
		while (!queue.isEmpty()) {
			Node node = queue.poll();
			stack.push(node);

			if (node.getLeft() != null) {
				queue.offer(node.getLeft());
			}

			if (node.getRight() != null) {
				queue.offer(node.getRight());
			}
		}
		while (!stack.isEmpty()) {
			System.out.print(stack.pop().getKey() + " ");

		}
	}

	@Override
	public void printSpiral() {
		if (root == null) {
			System.out.println("UnderFlow:");
			return;
		}
		printSpiral(root);
	}

	private void printSpiral(MyBST<T>.Node tempRoot) {

		if (tempRoot == null) {
			System.out.println("Tree is empty");
			return;
		}

		Stack<Node> stackOne = new Stack<Node>();
		Stack<Node> stackTwo = new Stack<Node>();
		stackOne.push(tempRoot);
		while (!stackOne.isEmpty() || !stackTwo.isEmpty()) {
			// insert right to left in stack
			while (!stackOne.isEmpty()) {
				Node node = stackOne.pop();
				System.out.print(node.key + " ");
				if (node.right != null) {
					stackTwo.push(node.right);
				}
				if (node.left != null) {
					stackTwo.push(node.left);
				}
			}
			System.out.println(" # ");
			// insert left to right in stack
			while (!stackTwo.isEmpty()) {
				Node node = stackTwo.pop();
				System.out.print(node.key + " ");
				if (node.left != null) {
					stackOne.push(node.left);
				}
				if (node.right != null) {
					stackOne.push(node.right);
				}
			}
			System.out.println("");
		}
	}

	@Override
	public void findLCA(Integer node1, Integer node2) {
		if (root == null) {
			System.out.println("UnderFlow:");
			return;
		}

		finalLeastCommonAncestor(root, node1, node2);

	}

	private Node finalLeastCommonAncestor(Node tempNode, Integer node1, Integer node2) {
		// Base case
		if (tempNode == null)
			return null;

		// If either n1 or n2 matches with root's key,(Note that if a key is
		// ancestor of other, then the ancestor key becomes LCA
		if (tempNode.key == node1 || tempNode.key == node2)
			return tempNode;

		// Look for keys in left and right subtrees
		Node left_lca = finalLeastCommonAncestor(tempNode.left, node1, node2);
		Node right_lca = finalLeastCommonAncestor(tempNode.right, node1, node2);

		// If both of the above calls return Non-NULL, then one key
		// is present in once subtree and other is present in other,
		// So this node is the LCA
		if (left_lca != null && right_lca != null)
			return tempNode;

		// Otherwise check if left subtree or right subtree is LCA
		return (left_lca != null) ? left_lca : right_lca;

	}

}

public class MyTreeTest {
	public static void main(String args[]) {
		MyBST<Integer> myTree = new MyBST<Integer>();
		/*
		 * level-0:6 level-1:4,8 level-2:3,5,7,9
		 */

		myTree.insert(new Integer(6));
		myTree.insert(new Integer(8));
		myTree.insert(new Integer(4));
		myTree.insert(new Integer(7));
		myTree.insert(new Integer(3));
		myTree.insert(new Integer(5));
		myTree.insert(new Integer(9));

		System.out.println("Search-7:" + myTree.search(new Integer(7)));
		System.out.println("FindMin:" + myTree.findMin());
		System.out.println("FindMax:" + myTree.findMax());
		System.out.println("PreOrder:");
		myTree.preOrder();
		System.out.println("\nInOrder:");
		myTree.inOrder();
		System.out.println("\nPostOrder:");
		myTree.postOrder();
		System.out.println("\nCountLeaf:" + myTree.countLeaf());
		System.out.println("PreOrderWithoutRecursion:" + myTree.preOrderNonRecursive());
		System.out.println("LevelOrder:");
		myTree.levelOrder();
		System.out.println("\nHeight using DFS approach:");
		System.out.println(myTree.height("DFS"));
		System.out.println("Height using BFS approach:");
		System.out.println(myTree.height("BFS"));
		System.out.println("MaxSumLevel:");
		myTree.maxSumLevel();
		System.out.println("TotalSum: " + myTree.totalSum());
		System.out.println("TotalNodes: " + myTree.size());
		System.out.println("CountNonLeaf: " + myTree.countNonLeaf());
		System.out.println("CountNonLeafOneChild: " + myTree.countNonLeafOneChild());
		System.out.println("PrintLeftView: ");
		myTree.printLeftView();
		System.out.println("\nLevelOfNodeInBTree: " + myTree.levelOfNodeInBTree(new Integer(7)));
		System.out.println("IsLeavesAtSameLevel: " + myTree.isLeavesAtSameLevel());
		System.out.println("MaxWidth: " + myTree.maxWidth());
		System.out.println("PrintReverse: ");
		myTree.printReverse();

		System.out.println("\nFlatten:");
		myTree.flatten();
		System.out.println("InOrder:");
		myTree.inOrder();
		myTree.printSpiral();

	}
}
