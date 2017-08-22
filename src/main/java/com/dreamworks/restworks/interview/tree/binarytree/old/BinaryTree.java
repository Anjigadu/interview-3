package com.dreamworks.restworks.interview.tree.binarytree.old;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class BinaryTree {

	private Node root;
	
	public void addNode(int key, String name) {

		Node newNode = new Node(key,name);
		
		if(root == null) {
			root = newNode;
		}
		else{
			Node focusNode = root;
			
			while(true) {
				
				if(key < focusNode.key) {
					if(focusNode.leftChild == null) {
						focusNode.leftChild = newNode;
						return;
					}
					else{
						focusNode = focusNode.leftChild;						
					}
				}

				else{
					
					if(focusNode.rightChild == null) {
						focusNode.rightChild = newNode;
						return;
					}
					else{
						focusNode = focusNode.rightChild;
					}				
				}
			}
		}
	}
	
	/**
	 * Recursive Version of Node insert
	 *
	 *
	 * Initial start 
	 * Created a new node from the value, and start comparison with root node and new node
	 *
	 * Search Condition
	 * if node is > or < than new Node's value (key)
	 * 
	 * End Condition 
	 * if left or right child node is null ==> add it
	 * 
	 * 
	 * @param focusNode
	 * @param newNode
	 */
	public void addNodeTo(Node focusNode, Node newNode) {
	
		if(focusNode.key < newNode.key) {
			if(focusNode.leftChild == null) {
				focusNode.leftChild = newNode;
				return;
			}
			else{
				addNodeTo(focusNode.leftChild, newNode);
			}
		}
		else{
			if(focusNode.rightChild ==null) {
				focusNode.rightChild = newNode;
				return;
			}
			else {
				addNodeTo(focusNode.rightChild,newNode);
			}
		}	
	}
	
	
	
	public void addNodeVer2(int key, String name) {

		Node newNode = new Node(key,name);
		
		if(root == null) {
			root = newNode;
		}
		else{
			
			addNodeTo(root, newNode);
			
			Node focusNode = root;
//			Node parent;
			
			while(true) {
				
				/*
				parent = focusNode;
				
				if(key < focusNode.key) {
					focusNode = focusNode.leftChild;
					if(focusNode == null) {
						parent.leftChild = newNode;
						return;
					}
				}
				*/
				if(key < focusNode.key) {
					if(focusNode.leftChild == null) {
						focusNode.leftChild = newNode;
						return;
					}
					else{
						focusNode = focusNode.leftChild;						
					}
				}

				else{
					
					if(focusNode.rightChild == null) {
						focusNode.rightChild = newNode;
						return;
					}
					else{
						focusNode = focusNode.rightChild;
					}				
				}
			}
		}
	}
	
	
	
	public Node getRoot(){
		return root;
	}
	
	public void inOrderTraverseTree(Node focusNode) {
		if(focusNode!=null) {
			inOrderTraverseTree(focusNode.leftChild);

			System.out.println(focusNode);
			
			inOrderTraverseTree(focusNode.rightChild);
		}
	}

	public void inOrderTraverseTree(Node focusNode, List<Node> listNode) {
		if(focusNode!=null) {
			inOrderTraverseTree(focusNode.leftChild);
			listNode.add(focusNode);			
			inOrderTraverseTree(focusNode.rightChild);
		}
	}
	
	// recursive version
	public void preOrderTraverseTree(Node focusNode) {
		if(focusNode!=null) {

			System.out.println(focusNode);
			
			preOrderTraverseTree(focusNode.leftChild);
			
			preOrderTraverseTree(focusNode.rightChild);
		}
	}
	
	
	// Iterative version	
	public void preOrderTraverseTreeIterative(Node focusNode){
		if(focusNode==null) {
			return;
		}
		
		Stack<Node> stack = new Stack<>();
		stack.push(focusNode);
		
		while(!stack.empty()) {
			Node n = stack.pop();
			System.out.println(n);
			
			if(n.rightChild!=null) {
				stack.push(n.rightChild);
			}
			if(n.leftChild!=null) {
				stack.push(n.leftChild);
			}			
		}		
	}
	

	// Iterative version	
	public void breadthFirstTraverseTreeIterative(Node focusNode){
		if(focusNode==null) {
			return;
		}

		Queue<Node> queue = new LinkedList<Node>();

		queue.add(focusNode);

		while(!queue.isEmpty()) {

			Node node = queue.remove();				
			System.out.print(node.key + " ");

			if(node.leftChild!=null) {
				queue.add(node.leftChild);
			}
			if(node.rightChild!=null) {
				queue.add(node.rightChild);
			}				
		}
	}
	
	
	
	
	public void postOrderTraverseTree(Node focusNode) {
		if(focusNode!=null) {
			
			postOrderTraverseTree(focusNode.leftChild);
			
			postOrderTraverseTree(focusNode.rightChild);
			
			System.out.println(focusNode);

		}
	}
	
	public Node findNode(int key) {
		
		Node focusNode = root;
		
		while(focusNode.key!= key) {
			if(key <focusNode.key) {
				focusNode = focusNode.leftChild;
			}
			else{
				focusNode = focusNode.rightChild;
			}
			if(focusNode ==null) {
				return null;
			}
		}		
		return focusNode;
	}
	
	public Node findMaxNode() {
		
		Node focusNode = root;
		
		if(focusNode!=null) {
			while(focusNode.rightChild!=null) {
				focusNode = focusNode.rightChild;
			}			
		}
		return focusNode;
	}
	
	public Node findMinNode() {
		
		Node focusNode = root;
		
		if(focusNode!=null) {
			while(focusNode.leftChild!=null) {
				focusNode = focusNode.leftChild;
			}			
		}
		return focusNode;
	}
	
	public Node findMinNode(Node root) {
		
		Node focusNode = root;
		
		if(focusNode!=null) {
			while(focusNode.leftChild!=null) {
				focusNode = focusNode.leftChild;
			}			
		}
		return focusNode;
	}
	
	
	
	public void removeNode (int key) {

		root = deleteRec(root, key);
	}
	
	/**
	 * Search for the value, and if it is smaller than focusNode, move to leftchild, else if greater than focusNode, move to right 
	 * if value matches, 
	 * (1) search for the node with min value from the right subtree and replace the value of current focusNode 
	 * (2) delete the Node with min value from the right subtree
	 * 
	 * @param focusNode
	 * @param key
	 * @return
	 */
	public Node deleteRec(Node focusNode, int key) {

		if(focusNode ==null) {
			return focusNode;
		}
		
		if(key < focusNode.key) {
			focusNode.leftChild = deleteRec(focusNode.leftChild,key);
		}
		else if(key > focusNode.key) {
			focusNode.rightChild = deleteRec(focusNode.rightChild, key);
		}
		else{
			Node minNode = findMinNode(focusNode.rightChild);

			focusNode.key = minNode.key;
			minNode.rightChild = deleteRec(focusNode.rightChild, focusNode.key);
		}
		
		return focusNode;		
	}
	
		
	public static void main(String[] args){
		BinaryTree bTree = new BinaryTree();
		
		bTree.addNode(50, "CEO");
		bTree.addNode(25, "VP");
		bTree.addNode(15, "Office manager");
		bTree.addNode(30, "Secretary");
		bTree.addNode(75, "Sales manager");
		bTree.addNode(85, "Salesman 1");
		
		//                  50
		//            25         75
		//        15     30          85
		
		// In-Order    : 15 25 30 50 75 85
		// (sorted)
		
		// Post-order  : 15 30 25 85 75 50
		
		// Preorder    : 50 25 15 30 75 85
		// (DFS)
		
		// Breadthfirst: 50 25 75 15 30 85
		// (BFS)
		
		
		
		System.out.println("\n* In-order");
		bTree.inOrderTraverseTree(bTree.root);
		
		System.out.println("\n* Preorder");
		bTree.preOrderTraverseTree(bTree.root);

		System.out.println("\n* Preorder(iterative w/ stack)");
		bTree.preOrderTraverseTreeIterative(bTree.root);

		System.out.println("\n* Post-order");
		bTree.postOrderTraverseTree(bTree.root);
		
		System.out.println("\n* findNode(30)");
		bTree.findNode(30);
		
		System.out.println("\n* breadth first traversal");
		bTree.breadthFirstTraverseTreeIterative(bTree.root);
		
		
		
		
		/*
		List<Node> listNode = new ArrayList<Node>();
		
		bTree.inOrderTraverseTree(bTree.root, listNode);
		
		for(Node node: listNode) {
			System.out.println(node);
		}
		*/
		
		
	}
	
}
