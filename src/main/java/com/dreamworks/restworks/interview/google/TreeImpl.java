package com.dreamworks.restworks.interview.google;

import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Queue;

//Write a class implementing this interface:
//
//interface Tree {
//void addNode(String key, String parent, Runnable notify);
//
///** Return direct children of supplied key. */
//List<String> getChildren(String key);
//
///**
// * Remove the specified node and all its children, deeply. The notify
// * callback for each node is called in breadth-first order.
// */
//void removeSubtree(String key);
//}


public class TreeImpl implements Tree{

	Node root;

	@Override
	public void removeSubtree(java.lang.String key) {
		// TODO Auto-generated method stub

	} 

	@Override
	public List<String> getChildren(String key) {
	
		List<String> listChildren = new ArrayList<String>();
		
		for(Node node : findNodeWithKey(key).children) {
			listChildren.add(node.key);
		}
		return listChildren;
	}


	private Node findNodeWithKey(String key) {

		Node focusNode = root;
		
		Queue<Node> q = new LinkedList<Node>();
		q.add(focusNode);

		while(!q.isEmpty()) {
			Node curNode = q.remove();
			if(curNode.key == key) {  
				return curNode;               
			}
			else{
				for(Node n : curNode.children) {
					q.add(n);
				}
			}
		}
		throw new NoSuchElementException();
	}

	@Override
	public void addNode(String key, String parent, Runnable notify){

		if(parent!=null) {
			Node focusNode = root;
			Queue<Node> q = new LinkedList<Node>();
			q.add(focusNode);
			Node parentNode = null;
			
			while(!q.isEmpty()) {
				Node curNode = q.remove();
				if(curNode.key == parent) {
					parentNode = curNode;
					break;
				}
				else{
					for(Node n : curNode.children) {
						q.add(n);
					}
				}
			}

			if(parentNode==null) 
				throw new NoSuchElementException();

			// updating the children of the parent
			parentNode.children.add(new Node(key,parent,notify));
		}
		else{
			throw new InvalidParameterException();
		}
	}

	private class Node{
		private String key;
		private String parent;
		private List<Node> children;
		private Runnable notify;  

		public Node(String key, String parent, Runnable notify) {
			this.key = key;
			this.parent = parent;
			this.notify = notify;
		}
	}

	private class NodeEventHandler implements Runnable{
		@Override
		public void run() { 
			System.out.println("Node deleted");
		}
	}

}
