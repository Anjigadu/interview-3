package com.dreamworks.restworks.interview.LinkedStack;

public class LinkedStack<T> {

	private Node<T> top;
	
	public void push(T data) {
		//top = new Node(T data, top);
	}
	
	private class Node<T>{
		private T data;
		private Node<T> next;
		
		private Node(T data, Node<T> next){
			this.data = data;
			this.next = next;
		}		
	}
}
