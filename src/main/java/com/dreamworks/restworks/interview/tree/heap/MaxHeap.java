package com.dreamworks.restworks.interview.tree.heap;

public class MaxHeap {

	// heap starting from index 1 (not 0)
	private int[] Heap;
	private int size;
	private int maxsize;
	
	private static final int FRONT =1;
	
	public MaxHeap(int maxsize) {
		this.maxsize = maxsize;
		this.size = 0;
		Heap = new int[this.maxsize +1];
		Heap[0] = Integer.MAX_VALUE;
	}
	
	private int parent (int pos) {
		return pos /2;
	}
	
	private int leftChild (int pos) {
		return 2*pos;
	}
	
	private int rightChild (int pos) {
		return 2*pos +1;
	}
	
	private void heapify(int pos){
		
		
		
	}
	
}
