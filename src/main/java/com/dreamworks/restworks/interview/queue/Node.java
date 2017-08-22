package com.dreamworks.restworks.interview.queue;

public class Node {

	protected int data;
	protected Node next;
	
	public Node (int data, Node next) {
		this.data = data;
		this.next = next;
	}
	
	public Node() {
		this.next = null;
		this.data =0;
	}
	
	public int getData() {
		return data;
	}
	
	public void setData(int data) {
		this.data = data;
	}
	
	public Node getNext() {
		return next;
	}
	
	public void setNext(Node next) {
		this.next = next;
	}
	
}
