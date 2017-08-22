package com.dreamworks.restworks.interview.tree.binarytree;


public class RandomNumberBinaryTree {

	private Node root;

	private class Node{
		private int value;
		private Node left;
		private Node right;

		private Node(int value) {
			this.value = value;
		}
	}
	
	
	public void setup() {
		
		root = new Node(7);		
		root.right = new Node(5);
				
		Node node6 = new Node(6);
		root.left = node6;
		
		Node node8 = new Node(8);
		Node node4 = new Node(4);
		node6.left = node8;
		node6.right = node4;
		
		Node node3 = new Node(3);

		node8.left = node3;
		
		Node node1 = new Node(1);
		Node node2 = new Node(2);
		
		node4.left = node1;
		node4.right = node2;	
	}
	
	
	public int findLowestCommonAncestor(Node node, int a, int b){

		if(node==null){
			return -1;
		}
		if(node.value == a || node.value == b) {
			return node.value;
		}
		
		int left = findLowestCommonAncestor(node.left,a,b);
		int right = findLowestCommonAncestor(node.right,a,b);
			
		if((left == a || left ==b) && (right == a || right ==b)) {
			System.out.println("Node:" + node.value);
			return node.value;
		}
		else if((left == a || left ==b) ) {
			return left;
		}
		else if((left == a || left ==b) && (right == a || right ==b)) {
			return right;
		}
		else if(left!=-1) {
			return left;
		}
		else if(right!=-1) {
			return right;
		}
		return -1;
	}
		
	
	
	
	public static void main(String[] args) {
	
		RandomNumberBinaryTree bTree = new RandomNumberBinaryTree();
		bTree.setup();
		
		int lcm = bTree.findLowestCommonAncestor(bTree.root, 1, 8);	
		System.out.println("Returned lcm:" + lcm);	
		
		System.out.println("Bool Based --------");	
	
	}
}
