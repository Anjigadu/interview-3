package com.dreamworks.restworks.interview.graph;

import java.util.Stack;

public class Dijkstra {
	
	int[][] matrix;
	int[] dist;
	int[] prev;
	int src;
	int size;
	boolean[] bSettled;
	
	static int MAX = Integer.MAX_VALUE;
	static int NONE = -1;

	// (instance method based) --------------------------------------------------
	
	public void dijeckstraShortestPath(int[][] matrix, int src){
		if(matrix==null)
			return;
		
		this.matrix = matrix;
		this.src = src;
		
		size = matrix.length;		
		dist = new int[size];
		prev = new int[size];
		
		bSettled = new boolean[size];
		
		//initialize
		for(int i=0; i< size; i++){
			dist[i] = MAX;
			prev[i] = NONE;
		}
		
		// base
		dist[src] =0;
		
		// size -1 : because nothing need to be dont for last remaining (unsettled) node
		for(int i=0; i < size-1; i++) {
		
			// (1) Select current min dist node from unsettled
			int u = findMinDistNode();
			bSettled[u] = true;
			
			for(int v=0; v< size; v++){
				if(!bSettled[v] && matrix[u][v]!=0 && matrix[u][v] + dist[u] < dist[v]) {
					dist[v] = matrix[u][v] + dist[u];
					prev[v] = u;
				}
			}
		}
	}
	
	// min distNode (from unsettled)
	public int findMinDistNode() {

		int minDistance = Integer.MAX_VALUE;
		int minDistNode = -1;
		for(int i=0; i < bSettled.length; i++) {
			if(!bSettled[i] && dist[i] < minDistance) {
				minDistance = dist[i];
				minDistNode = i;
			}
		}
		return minDistNode;
	}
	
	public void printShortestPathToDist(int dest){
		
		int index = dest;
		Stack<Integer> stack = new Stack<Integer>();
		while(index!=-1) {		
			stack.push(index);			
			index = prev[index];
		}
		
		while(!stack.isEmpty()){
			System.out.print(stack.pop() + " ");
		}
		System.out.println("");
	}
	
	public void printMinDist(){

		for(int i=0; i< dist.length;i++) {
			System.out.println(i+"  ==>  "+dist[i]);
		}			
	}
	// (end) (instance method based) --------------------------------------------------
	 
	
	
	
	
	// static method based
	public static void dijeckstraShortestPathRouting(int[][] matrix, int src){
		if(matrix==null)
			return;
		
		int size = matrix.length;
		
		int[] dist = new int[size];
		int[] prev = new int[size];
		
		boolean[] bSettled = new boolean[size];
		
		int MAX = Integer.MAX_VALUE;
		int NONE = -1;
		
		//initialize
		for(int i=0; i< size; i++){
			dist[i] = MAX;
			prev[i] = NONE;
		}
		
		dist[src] =0;
		
		// size -1 : because nothing need to be dont for last remaining (unsettled) node
		for(int i=0; i < size-1; i++) {
		
			// (1) Select current min dist node from unsettled
			int u = findMinDistNode(bSettled,dist);
			bSettled[u] = true;
			
			for(int v=0; v< size; v++){
				if(!bSettled[v] && matrix[u][v]!=0 && matrix[u][v] + dist[u] < dist[v]) {
					dist[v] = matrix[u][v] + dist[u];
					prev[v] = u;
				}
			}
		}
		
		// print minDist
		printMinDist(dist);
				
		for(int i=1; i < dist.length; i++) {
			printPathToDist(prev, 0, i);
		}
		
	}
	
	private static int findMinDistNode(boolean[] bSettled, int[] dist) {

		int minDistance = Integer.MAX_VALUE;
		int minDistNode = -1;
		for(int i=0; i < bSettled.length; i++) {
			if(!bSettled[i] && dist[i] < minDistance) {
				minDistance = dist[i];
				minDistNode = i;
			}
		}
		return minDistNode;
	}
	
	
	// printShortestPath to each node		
	public static void printMinDist(int[] dist){

		for(int i=0; i< dist.length;i++) {
			System.out.println(i+"  ==>  "+dist[i]);
		}			
	}

	// printShortestPath to each node		
	public static void printPathToDist(int[] prev, int src, int dest){
		
		int index = dest;
		Stack<Integer> stack = new Stack<Integer>();
		while(index!=-1) {		
			stack.push(index);			
			index = prev[index];
		}
		
		while(!stack.isEmpty()){
			System.out.print(stack.pop() + " ");
		}
		System.out.println("");
	}
	
	public static void main(String[] args){
		/* 
		int matrix[][] = new int[][]{{0, 4, 0, 0, 0, 0, 0, 8, 0},
              {4, 0, 8, 0, 0, 0, 0, 11, 0},
              {0, 8, 0, 7, 0, 4, 0, 0, 2},
              {0, 0, 7, 0, 9, 14, 0, 0, 0},
              {0, 0, 0, 9, 0, 10, 0, 0, 0},
              {0, 0, 4, 14, 10, 0, 2, 0, 0},
              {0, 0, 0, 0, 0, 2, 0, 1, 6},
              {8, 11, 0, 0, 0, 0, 1, 0, 7},
              {0, 0, 2, 0, 0, 0, 6, 7, 0}
             };
             */
             
       	  int matrix[][] = new int[][]{{0, 5, 2, 0},
       		{5, 0, 3, 1},
       		{2, 3, 0, 2},
       		{0, 1, 2, 0}};
       	      
             Dijkstra d = new Dijkstra();
             d.dijeckstraShortestPath(matrix,0);
     
             Dijkstra.dijeckstraShortestPathRouting(matrix,0);             
	}
		
}
