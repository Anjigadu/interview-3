package com.dreamworks.restworks.interview.queue;

import java.util.Stack;

public class QueueWithStacks {

	// Queue i = new LinkedList<>();
	Stack<Integer> in = new Stack<>();
	Stack<Integer> out = new Stack<>();
	
	public void enqueue(int value) {
		in.push(value);
	}
	
	public Integer dequeue() {
		if(out.isEmpty()) {
			if(!in.isEmpty()) {
				while(!in.isEmpty()) {
					out.push(in.pop());
				}
				return out.pop();
			}
			return null;
		}
		else{
			return out.pop();
		}
	}
	
	public static void main(String[] args) {
		
		QueueWithStacks q = new QueueWithStacks();
		
		q.enqueue(1);
		q.enqueue(2);
		q.enqueue(3);
		System.out.println("dequeued:" + q.dequeue());
		System.out.println("dequeued:" + q.dequeue());
		q.enqueue(4);
		q.enqueue(5);
		System.out.println("dequeued:" + q.dequeue());
		System.out.println("dequeued:" + q.dequeue());

	}
	
}
