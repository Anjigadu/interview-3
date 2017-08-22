package com.dreamworks.restworks.interview.tree.binarytree;

import java.util.LinkedList;
import java.util.NoSuchElementException;
import java.util.Queue;
import java.util.Stack;
import java.util.concurrent.atomic.AtomicInteger;

import org.apache.commons.lang3.mutable.MutableInt;

public class BinarySearchTree {

	Node root;
	
	public void insert(int val){

		if(root==null) {
			root = new Node(val);
		}
		else{
			Node focusNode = root;
			while(true) {
				if(focusNode.value > val) {
					if(focusNode.left==null) {
						focusNode.left = new Node(val);
						return;  // <-----
					}
					else{
						focusNode = focusNode.left;
					}
				}
				else{
					if(focusNode.right==null) {
						focusNode.right = new Node(val);
						return;  // <-----
					}
					else{
						focusNode = focusNode.right;
					}
				}
			}
		}
	}

	//--------------------------------
	// insert using recursion
	//--------------------------------
	public void insert(Node focusNode, int val) {

		if(focusNode==null) {
			focusNode = new Node(val);
		}
		else{
			if(focusNode.value > val){
				if(focusNode.left==null) {
					focusNode.left = new Node(val);
					return;
				}
				else{
					insert(focusNode.left, val);
				}
			}
			else{
				if(focusNode.right==null) {
					focusNode.right = new Node(val);
					return;
				}
				else{
					insert(focusNode.right, val);
				}
			}
		}		
	}

	private class Node{
		private int value;
		private Node left;
		private Node right;

		private Node(int value) {
			this.value = value;
		}
	}

	
	
	//--------------------------------------------------------------------------------------
	// (Q) k-th largest	
	// ==> reverse in-order traversal
	//--------------------------------------------------------------------------------------	
	// Time complexity: The code first traverses down to the rightmost node 
	//                  - which takes O(h) time, 
	//                  then traverses k elements 
	//                  - in O(k) time.
	//                  Therefore overall time complexity is O(h + k).	
	//--------------------------------------------------------------------------------------
	public void kthlargestValue(Node node, AtomicInteger count, int k) {

		if(node==null) {
			return;
		}
		
		kthlargestValue(node.right, count, k);
		count.incrementAndGet();
		
		if(count.get() ==k) {
			System.out.println("K (" + count + ") th, value:" + node.value);
		}
		
		kthlargestValue(node.left, count, k);		
	}
	
	
	public void kthlargestValue(Node node, int k) {
		AtomicInteger count = new AtomicInteger(0); 
		kthlargestValue(node, count, k);
	}
	
	//--------------------------------------------------------------------------------------
	// (Q) k-th smallest
	//--------------------------------------------------------------------------------------
	
	public void kthSmallest(Node node, int k) {
		AtomicInteger iValue = new AtomicInteger(0); 
		kthSmallest(node, iValue, k);

	}
	
	public void kthSmallest(Node node, AtomicInteger c, int k) {
		
		if(node==null)
			return;
		
		kthSmallest(node.left, c, k);
		c.incrementAndGet();
		if(c.intValue() == k) {
			System.out.println("k(" + k +") th smallest value:" + node.value);
			return;
		}
		kthSmallest(node.right, c, k);	
	}
	

	public Integer kthSmallestReturn(Node node, int k) {
		AtomicInteger iValue = new AtomicInteger(0); 
		MutableInt mi = new MutableInt();
		kthSmallestWithReturn(node, iValue, mi, k);

		return mi.intValue();
	}
	
	// version 2 with value to return as MutableInt
	public void kthSmallestWithReturn(Node node, AtomicInteger c, MutableInt mi, int k) {
		
		if(node==null)
			return;
		
		kthSmallestWithReturn(node.left, c, mi, k);
		c.incrementAndGet();
		if(c.intValue() == k) {
			System.out.println("k(" + k +") th smallest value:" + node.value);
			mi.setValue(node.value);
			return;
		}
		kthSmallestWithReturn(node.right, c, mi,k);	
	}
	
	

	public static Integer kthSmallestWithStack2(Node root, int k) {

		Stack<Node> stack = new Stack<>();
		Node node = root;		
		int result = 0;

		while(node!=null || !stack.isEmpty()) {

			if(node!=null) {
				stack.push(node);
				node = node.left;
			}
			else{
				node = stack.pop();
				k--;
				if(k==0){
					return node.value;
				}
				node = node.right;
			}
		}
		return result;
	}
	
	
	//---------------------------------------------------------------
	// K-th smallest using Stack, return value !!!
	//---------------------------------------------------------------	
	public static Integer kthSmallestWithStack(Node root, int k) {
		
		Stack<Node> stack = new Stack<>();
		Node node = root;		
		int result = 0;
		
		while(node!=null || !stack.isEmpty()) {
			
			if(node!=null) {
				stack.push(node);
				node = node.left;
			}
			else{
				Node n = stack.pop();
				k--;
				if(k==0){
					result =  n.value;
					break;
				}
				node = n.right;				
			}
		}
		return result;		
	}
	
	
	
	
	

	//--------------------------------------------------------------------------------------
	// (Q) Tree Traversal (recursive) : Pre, in, Post, BFS
	//--------------------------------------------------------------------------------------

	public void preOrderTraverse(Node node){

		if(node==null){
			return;
		}

		System.out.print(node.value + " ");
		preOrderTraverse(node.left);
		preOrderTraverse(node.right);
	}


	public void inOrderTraverse(Node node){

		if(node==null){
			return;
		}

		inOrderTraverse(node.left);
		System.out.print(node.value + " ");
		inOrderTraverse(node.right);
	}


	public void postOrderTraverse(Node node){

		if(node==null){
			return;
		}

		postOrderTraverse(node.left);
		postOrderTraverse(node.right);
		System.out.print(node.value + " ");	
	}

	public void breadthFirstTraverse(Node node){

		Queue<Node> q = new LinkedList<Node>();

		q.add(node);

		while(!q.isEmpty()){

			Node cNode = q.remove();
			System.out.print(cNode.value + " ");

			if(cNode.left !=null) {
				q.add(cNode.left);
			}
			if(cNode.right!=null) {
				q.add(cNode.right);				
			}			
		}	
	}
	
	
	
	//---------------------------------------------------------------------
	// Reverse BFS (or reverse level order: bottom to top, left to right)
	// O(n) using stack and queue
	//---------------------------------------------------------------------
    // initialize : put the root node into the queue
	
	// While Queue is not empty 
	// (0) dequeue a node, and for this node
	// (1) put it into the stack
	// (2) put right child and left child in order into the queue
	
	public void reverseBreadthFirstTraverse(Node node){

		Stack<Node> stack = new Stack<>();		
		Queue<Node> q = new LinkedList<>();
		
		q.add(node);
		
		while(!q.isEmpty()) {
			
			Node n = q.remove();			
			stack.push(n);
						
			if(n.right!=null) {
				q.add(n.right);				
			}

			if(n.left !=null) {
				q.add(n.left);
			}	
		}

		while(!stack.isEmpty()) {
			System.out.print(stack.pop().value + " ");
		}		
	}
	
	// O(n^2) : for skewed tree
	void levelOrder(Node root) 
	{
		int h = height(root);
		System.out.println("Height of the tree:" + h);
		int i;
		for (i = 1; i <=h ; i++) 
			//THE ONLY LINE DIFFERENT FROM NORMAL LEVEL ORDER
		{
			// System.out.println("\n-Print level:" + i );            
			printGivenLevel(root, i);
		}
	}
	
	 /* Function to print REVERSE level order traversal a tree*/
	// O(n^2) : for skewed tree
    void reverseLevelOrder(Node root) 
    {
        int h = height(root);
        System.out.println("Height of the tree:" + h);
        int i;
        for (i = h; i >= 1; i--) 
        //THE ONLY LINE DIFFERENT FROM NORMAL LEVEL ORDER
        {
            // System.out.println("\n-Print level:" + i );            
            printGivenLevel(root, i);
        }
    }
  
    /* Print nodes at a given level */
    void printGivenLevel(Node node, int level) 
    {
        if (node == null)
            return;
        if (level == 1)
            System.out.print(node.value + " ");
        else if (level > 1) 
        {
            printGivenLevel(node.left, level - 1);
            printGivenLevel(node.right, level - 1);
        }
    }
  

	
	//--------------------------------------------------------------------------------------
	// (Q) Tree Traversal (recursive) : Pre, in, Post, BFS
	//--------------------------------------------------------------------------------------
	
	public int get2ndLargest()  {
		
		if(root==null) {
			throw new NoSuchElementException();
		}
		
	    Node focusNode = root;
	    Node parentNode = null;
	    
	    while(focusNode.right!=null){
	    	parentNode = focusNode;
	    	focusNode = focusNode.right;	    	
	    }
		
	    // if this is leaf node
	    // ==> parent is the 2nd largest
	    
	    if(focusNode.left==null) {
	    	return parentNode.value;
	    }
	    
	    // Else if it has left child, right most tree from left child is the 2nd largetst
	    else{
	    	focusNode = focusNode.left;
	    	while(focusNode.right!=null) {
	    		focusNode = focusNode.right;
	    	}
	    	return focusNode.value;	    	
	    }
	    
	    // or 2nd to the last from in-order traversal is the 2nd largest
	    // ==> how can we store that?
	    // ==> try reverse in-order traversal !! 
	}
	

	
	//--------------------------------------------------------------------------------------
	// (Q) Check if tree is balanced
	//--------------------------------------------------------------------------------------
	// if any of the node has more than 1 difference in height between left and right child

	public boolean isBalanced(Node node) {

		if(node == null) {
			return true;
		}

		if(Math.abs(height(node.left) - height(node.right)) > 1) {
			return false;
		}
		else{
			return isBalanced(node.left) && isBalanced(node.right);
			
		}
	}

	
	public int height(Node node) {
		if(node ==null) {	
			return 0;
		}

		int height = Math.max(height(node.left), height(node.right)) +1;
		return height;				
	}

	//---------------------------------------------------------------------------------------------
	// (Q) Find Next Node from in-order traversal
	//    (if it has Parent node information)
	//    - if right child exist
	//         -> right child's left most child
	//    - if right child does not exist
	//         -> move up following parent tree as long as current node is parent's right child
	//            (when it becomes the left child of parent, it means parent is next node to print)
	//
	//    ==> didn't add solution code here because there is no parent pointer in current node
	//---------------------------------------------------------------------------------------------


	//---------------------------------------------------------------------------------------------
	// (Q) Find Max Sum Path !!! 
	// (return max_single, and stor max_top in res object)
	//---------------------------------------------------------------------------------------------
	//http://www.geeksforgeeks.org/find-maximum-path-sum-in-a-binary-tree/
    // This function returns overall maximum path sum in 'res'
    // And returns max path sum going through root.
	//---------------------------------------------------------------------------------------------
	
	
	int findMaxPath(Node node, Res res)
    {
        // Base Case
        if (node == null)
            return 0;
 
        // l and r store maximum path sum going through left and
        // right child of root respectively
        int l = findMaxPath(node.left, res);
        int r = findMaxPath(node.right, res);
        
        // Calculate the value when current node is not root of the path
        // the value returned in this method
        int max_single = Math.max(Math.max(l, r) + node.value,
                                  node.value);
          
        // Get the max value when current node is root of the max path
        // and stores it in res 
        int max_top = Math.max(max_single, l + r + node.value);
 
        // update max
        res.val = Math.max(res.val, max_top);
 
        return max_single;
    }

    // An object of Res is passed around so that the
    // same value can be used by multiple recursive calls.
    private class Res {
    	private int val;
    }
    
    // Returns maximum path sum in tree with given root
    int findMaxPathSum(Node node) {
 
        // Initialize result
        // int res2 = Integer.MIN_VALUE;
        Res res = new Res();
        res.val = Integer.MIN_VALUE;
 
        // Compute and return result
        findMaxPath(node, res);
        return res.val;
    }

  
    //---------------------------------------------------------------------------------------------
	// (Q) check if it is full binary tree or not
	//---------------------------------------------------------------------------------------------
	// => full binary tree : all node has two childs or no child
    // http://www.geeksforgeeks.org/check-whether-binary-tree-full-binary-tree-not/
 	//---------------------------------------------------------------------------------------------
	
    public static boolean isFullBinaryTree(Node node) {
    	    	
    	if(node.left==null && node.right ==null) {
    		return true;
    	}
    	else if(node.left!=null && node.right !=null) {			
    		return isFullBinaryTree(node.left) && isFullBinaryTree(node.right);    	
    	}
    	return false;
    }
  
    //---------------------------------------------------------------------------------------------
  	// (Q) Bottom nodes of the tree (all the leaf nodes from left to right)
  	//---------------------------------------------------------------------------------------------
  	
    public static void bottomView(Node node) {
     
    	if(node==null) 
    		return;
    	
    	if(node.left==null && node.right==null) {
    		System.out.print(node.value + " ");
    	}
    	
    	bottomView(node.left);
    	bottomView(node.right);    	
    	
    }
       

    
    //---------------------------------------------------------------------------------------------
  	// (Q) Binary Tree Validator
  	//---------------------------------------------------------------------------------------------  	
    public static boolean isBinaryTree(Node node){
    	    	
    	boolean bLeft = true;
    	boolean bRight = true;
    	
    	if(node.left!=null){
    		bLeft = node.left.value < node.value && isBinaryTree(node.left);
    	}
    	if(node.right!=null){
    		bRight = node.right.value > node.value && isBinaryTree(node.right);
    	}

    	// base ==> node.left and node.right are both null
    	
    	return bLeft && bRight;    	
    }
        
    
    //---------------------------------------------------------------------------------------------
  	// (Q) Lowest Common Ancestor of two number
  	//---------------------------------------------------------------------------------------------  	
   
    
    public static int lowestCommonAncestor(Node node, int a, int b){
    	
    	int low = a < b ? a :b;
    	int high = a == low ? b : a;
    	 
    	while(node!=null) {
    		if(node.value < high && node.value > low) {    		
    			return node.value;    		
    		}
    		else if (node.value > high) {
    			if(node.left!=null) {
    				node = node.left;
    			}
    		}
    		else if (node.value < low) {
    			node = node.right;    	
    		}    	
    	}
    	
    	//return -1;
    	throw new NoSuchElementException();
    }
    
    
    
    
	public static void main(String[] args) {

		BinarySearchTree bTree = new BinarySearchTree();

		//bTree.insert(-5);
		bTree.insert(5);
		bTree.insert(2);
		bTree.insert(3);		
		bTree.insert(7);
		bTree.insert(4);
		bTree.insert(8);
		bTree.insert(6);
		
//		bTree.insert(20);
//		bTree.insert(8);		
//		bTree.insert(22);
//		bTree.insert(5);
//		bTree.insert(3);
//		bTree.insert(4);
//		bTree.insert(25);
//		bTree.insert(10);
//		bTree.insert(14);
		
		
		System.out.println("Balanced ==> " + bTree.isBalanced(bTree.root));

		System.out.println("\n\n* Pre-order (DFS) traversal");
		bTree.preOrderTraverse(bTree.root);

		System.out.println("\n\n* In-Order traversal");
		bTree.inOrderTraverse(bTree.root);

		System.out.println("\n\n* Post-order traversal");
		bTree.postOrderTraverse(bTree.root);

		System.out.println("\n\n* BFS-order traversal");
		bTree.breadthFirstTraverse(bTree.root);

		System.out.println("\n\n* 2nd largetst from Tree");
		int secondLargest = bTree.get2ndLargest();
		System.out.println("2nd largest value: " + secondLargest);
		
		System.out.println("\n\n* level order traversal");
		bTree.levelOrder(bTree.root);
		
		System.out.println("\n\n* reverse level order traversal");
		bTree.reverseLevelOrder(bTree.root);
		
		System.out.println("\n\n* reverse level order traversal (Queue And Stack)");
		bTree.reverseBreadthFirstTraverse(bTree.root);
	
		System.out.println("\n\n* k (3th) th largest value");
		bTree.kthlargestValue(bTree.root, 3);
		
		System.out.println("\n\n* k (2th) th smallest value");
		bTree.kthSmallest(bTree.root, 2);
		
		System.out.println("\n\n* k (2th) th smallest value (w/ return)");
		int returnedKThSmallest = bTree.kthSmallestReturn(bTree.root, 2);
		System.out.println("=> returned kth smallest:" + returnedKThSmallest);

		
		System.out.println("\n\n* k (2th) th smallest value (w/ stack & return)");
		int resultedKthUsingStak = kthSmallestWithStack(bTree.root,2);
		System.out.println("=> returned kth smallest (stack):" + resultedKthUsingStak);
		
		resultedKthUsingStak = kthSmallestWithStack2(bTree.root,2);
		System.out.println("=> returned kth smallest (stack2):" + resultedKthUsingStak);

		
		System.out.println("\n\n* Max Sum Path Value");
		
		int maxSum = bTree.findMaxPathSum(bTree.root);
		System.out.println("==>" + maxSum);
		
		System.out.println("\n\n* is Full Binary Tree: " + isFullBinaryTree(bTree.root));
		
		
		System.out.println("\n\n* Bottom View of the Tree: ");
		bottomView(bTree.root);
		
		System.out.println("\n\n* Is Binary Tree: " + isBinaryTree(bTree.root));
		
	}

}
