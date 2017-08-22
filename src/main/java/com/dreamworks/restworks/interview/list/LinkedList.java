package com.dreamworks.restworks.interview.list;

public class LinkedList {
	
	Node head;

	private class Node{
		private int value;
		private Node next;
		
		private Node(int value, Node next) {
			this.value = value;
			this.next = next;
		}
	}

	public void addNode(int value){

		if(head==null) {
			head = new Node(value, null);
		}
		else{
			Node curNode = head;
			while(curNode.next!=null) {
				curNode = curNode.next;
			}
			curNode.next = new Node(value,null);
		}		
	}

	public void addNode(Node node){

		if(head==null) {
			head = node;
		}
		else{
			Node curNode = head;
			while(curNode.next!=null) {
				curNode = curNode.next;
			}
			curNode.next = node;
		}		
	}

	public void printLinkedList() {
		Node node = head;

		while(node!=null) {
			System.out.print(node.value + " ");
			node = node.next;
		}
	}

	//-----------------------------------
	// (Q) Remove n-th from End of list
	//-----------------------------------
	
	public void removeNthFromEnd(int n) {
		Node node = head;
		Node targetNode=null;
		
		int k=0;
		while(node.next!=null) {
			k++;
			node = node.next;
			if(targetNode!=null) {
				targetNode = targetNode.next;
			}
			if(k==n-1) {
				targetNode = head;
			}			
		}
		
		targetNode.value = targetNode.next.value;
		targetNode.next = targetNode.next.next;		
	}
	
	//--------------------------------
	// (Q) Reverse a Linked List
	//--------------------------------
	public void reverseLinkedList(){

		Node node = head;
		Node prevNode = null;

		while(node!=null){

			Node nextNode = node.next;
			
			node.next = prevNode;

			prevNode = node;			
			node = nextNode;
		}

		head = prevNode;		
	}
	
	//--------------------------------

	public static void main(String[] args) {

		LinkedList ln = new LinkedList();
		ln.addNode(5);
		ln.addNode(4);
		ln.addNode(3);
		ln.addNode(2);
		ln.addNode(1);

		System.out.println("linked list");
		ln.printLinkedList();		

		ln.reverseLinkedList();

		System.out.println("\nrevered");
		ln.printLinkedList();

		System.out.println("\nRemove 3rd from the end");
		ln.removeNthFromEnd(3);
		ln.printLinkedList();


	}
	


}
