package com.dreamworks.restworks.interview.sort;

public class BubbleSort {

	
	public static int[] bubbleSort(int[] data) {
		
		// how many times to compare & value to deduct from j
		for(int i=0; i< data.length-1;i++) {
			//System.out.println("processing i th:" + i);
			
			// modified bubble sort ==> to stop processing if array is sorted already
			// ==> this makes Best case of Bubble Sort to O(n) (if all sorted already)
			boolean isSorted= true;
			
			// for each loop, from where to where
			for(int j=0; j< data.length-1-i;j++) {
				if(data[j] > data[j+1]) {
					int temp = data[j];
					data[j] = data[j+1];
					data[j+1] = temp;
					
					isSorted = false;					
				}
			}
			
			if(isSorted){
				return data;
			}
		}		
		return data;		
	}
	

	public static void main(String[] args) {
		//int[] testData = {8,4,2,1,5,6,7};
		int[] testData = {1,2,3,4,5,6,7,8};
		
		bubbleSort(testData);
		
		for(int i: testData) {
			System.out.print(i + " ");
		}
		
	}
	
}
