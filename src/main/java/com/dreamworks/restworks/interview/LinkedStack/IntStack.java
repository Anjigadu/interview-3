package com.dreamworks.restworks.interview.LinkedStack;

public class IntStack {

	private Node top;
	
	public void push(int item) {
		top = new Node(item, top);
	}

	public int pop() {

		if(top!=null) {
			int data = top.data;
			top = top.next;

			return data;
		}
		return -1; // or throw exception!
	}
	
		
	private class Node{
		private int data;
		private Node next;
		
		private Node(int data, Node next){
			this.data = data;
			this.next = next;			
		}
	}
	
	
}
