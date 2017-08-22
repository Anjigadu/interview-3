package com.dreamworks.restworks.interview.dp;

import java.util.HashSet;
import java.util.Set;

public class FindingDuplciatesInArray {

	
	public static void main(String[] args){
		
		int[] arr = {1,2,3,1,3,6,6};
		
		findDuplicateNumbers(arr);
	}
	
	public static void findDuplicateNumbers(int[] arr) {
		
		// (1) O(n^2)
		// (2) Sorting and check => O(nlogn) : quick sort, merge, heap
		// (3) HashTable => number -> count : O(n)
		
		if(arr==null) {
			return;
		}
			 
		Set<Integer> dataSet = new HashSet<Integer>();
		
		for(int i=0;i<arr.length;i++) {
			if(dataSet.contains(arr[i])) {			
				System.out.print(arr[i] + " ");
			}
			else{
				dataSet.add(arr[i]);
			}				
		}		
	}
	
	
	
}
