package com.dreamworks.restworks.interview.tree.binarytree.old;


public class MaxSumPath {

	public int maxSumPath(Node node) {
	
		if(node==null) {
			return 0;
		}
		else if(node.left ==null && node.right ==null) {
			return node.value;
		}
		else if(node.left==null){
			return Math.max(node.value, node.value + maxSumPath(node.left));
		}
		else if(node.right==null){
			return Math.max(node.value, node.value + maxSumPath(node.right));
		}
		else{
			int maxSum= node.value;
			int leftSum = maxSumPath(node.left);
			int rightSum = maxSumPath(node.right);
			
			if(leftSum>0) {
				maxSum+=leftSum;
			}
			if(rightSum>0) {
				maxSum+=rightSum;
			}			
			return maxSum;
		}
	}
	
	
	private class Node{
		private int value;
		private Node left;
		private Node right;

		Node(int value) {
			this.value = value;
		}
	}

	public static void main(String[] args) {
		
		
		
		
	}
	
	
	
	
}
