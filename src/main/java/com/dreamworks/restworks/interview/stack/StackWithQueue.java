package com.dreamworks.restworks.interview.stack;

import java.util.LinkedList;
import java.util.Queue;

public class StackWithQueue {

	Queue<Integer> q1 = new LinkedList<>();
	Queue<Integer> q2 = new LinkedList<>();

	public void push(Integer value) {
		if(q1.isEmpty() && q2.isEmpty()) {
			q1.add(value);
		}
		else if(!q1.isEmpty()){
			q1.add(value);
		}
		else{
			q2.add(value);
		}
	}

	public Integer pop(){
		if(q1.isEmpty() && q2.isEmpty()) {
			return null;
		}
		else if(!q1.isEmpty()){
			while(q1.size() >1) {
				q2.add(q1.remove());
			}
			return q1.remove();
		}
		else{
			while(q2.size() >1) {
				q1.add(q2.remove());
			}
			return q2.remove();
		}
	}

	public static void main(String[] args) {

		// check if this is best implementation or not
		
		StackWithQueue q = new StackWithQueue();

		q.push(1);
		q.push(2);
		q.push(3);
		System.out.println("popped:" + q.pop());
		System.out.println("popped:" + q.pop());
		q.push(4);
		q.push(5);
		System.out.println("popped:" + q.pop());
		System.out.println("popped:" + q.pop());

	}


}
