package com.dreamworks.restworks.interview.tree.heap;

public interface iHeap {

	void add(int v);
	int remove();
	int peek();

	boolean isEmpty();
	int size();
}
