package com.practice;

/**
 * 
 * @author Prashant
 * This class is used to create BST tree.
 * Class provides implementation of InOrder,PreOrder and PostOrder traversal.
 * It also provides implementation to search for a particular element in the tree. 
 *
 */
class Node{
	Node left;
	Node right;
	int value;
	
	public Node(int value) {
		this.left = this.right = null;
		this.value = value;
	}
}

public class BST {
	Node root;
	
	public void insert(int val) {
		root = insertToTree(root,val);
	}
	
	private Node insertToTree(Node root, int val) {
		if(root == null) {
			root = new Node(val);
			return root;
		}
		
		if(val > root.value)
			root.right = insertToTree(root.right, val);
		else 
			root.left = insertToTree(root.left, val);
		
		return root;
	}
	
	private void printInOrder() {
		System.out.println("InOrder traversal");
		traverseInOrder(root);
	}

	private void traverseInOrder(Node root) {
		if(root!=null) {
			traverseInOrder(root.left);
			System.out.println(root.value);
			traverseInOrder(root.right);
		}
	}

	private void printPreOrder() {
		System.out.println("PreOrder traversal");
		traversePreOrder(root);
	}

	private void traversePreOrder(Node root) {
		if(root!=null) {
			System.out.println(root.value);
			traversePreOrder(root.left);
			traversePreOrder(root.right);
		}
	}
	
	private void printPostOrder() {
		System.out.println("PostOrder traversal");
		traversePostOrder(root);
	}

	private void traversePostOrder(Node root) {
		if(root!=null) {
			traversePostOrder(root.left);
			traversePostOrder(root.right);
			System.out.println(root.value);
		}
	}
	
	private boolean contains(int val) {
		Node eleNode = checkValExist(root,val);
		if(eleNode!=null)
			return true;
		else
			return false;
	}
	
	private Node checkValExist(Node root, int val) {
		if(root == null || root.value == val) {
			return root;
		}
		
		if(val > root.value)
			return checkValExist(root.right,val);
		return checkValExist(root.left,val);
	}

	public static void main(String[] args) {
		BST bst = new BST();
		bst.insert(40);
		bst.insert(10);
		bst.insert(20);
		bst.insert(11);
		bst.insert(80);
		bst.insert(60);
		bst.insert(75);
		bst.insert(50);
		bst.printPreOrder();
		bst.printInOrder();
		bst.printPostOrder();
		System.out.println(bst.contains(50));
	}

}
