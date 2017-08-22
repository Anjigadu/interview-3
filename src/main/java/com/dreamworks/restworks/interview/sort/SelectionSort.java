package com.dreamworks.restworks.interview.sort;

public class SelectionSort {

	public static int[] selectionSort(int[] data) {
		
		for(int i=0; i<data.length-1; i++) {
			
			int curIndex = i;
			
			for(int j=i+1; j<data.length;j++) {

				// Descending
				//if(data[curIndex] < data[j]) {
				
				// ascending
				if(data[curIndex] > data[j]) {
					curIndex = j;
				}
			}

			int maxValue = data[curIndex];
			
			data[curIndex] = data[i];
			data[i] = maxValue;
		}
		return data;
	}
	
	public static void main(String[] args) {
		int[] testData = new int[] {8,1,2,7,9,5,4,3};
		
		selectionSort(testData);
		
		for(int i : testData) { 
			System.out.print(i + " ");
		}
	}
	
	
}
