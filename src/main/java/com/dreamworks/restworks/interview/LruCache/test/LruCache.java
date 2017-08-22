package com.dreamworks.restworks.interview.LruCache.test;

import java.util.HashMap;
import java.util.Map;

public class LruCache {

	static class Node{
		private String key;
		private Integer value;
		
		private Node next;
		private Node prev;

		private Node(String key, Integer value){
			this.key = key;
			this.value = value;
		}		
	}

	// need to store node, if only store value
	// ==> map cannot be used to find out the node which has pointer to prev and next
	
	Map<String, Node> map = new HashMap<>();

	Node front;
	Node rear;
	
	int capacity = 10;
	
	public void set(String key, Integer value) {
		
		if(map.containsKey(key)) {
			
			Node n = map.get(key);
			n.value = value;
			
			remove(n);
			setHead(n);
			
		}
		else{
			if(capacity == map.size()) {
				map.remove(rear.key);
	            remove(rear);  
    		}
			
			
		}
		
	}

	public void remove(Node node) {
		if(node.prev!=null) {
			node.prev.next = node.next;
		}
		else{
			front = node;
		}
		
		if(node.next!=null) {
			node.next.prev = node.prev;
		}
		else{
			rear = node;
		}	
	}
	
	public void setHead(Node node) {
		
		
		
	}


}
