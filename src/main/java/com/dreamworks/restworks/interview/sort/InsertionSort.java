package com.dreamworks.restworks.interview.sort;

public class InsertionSort {

	
	public static int[] insertionSort(int[] data) {
		
		for(int i=1; i <data.length;i++) {
			
			int curValue = data[i];
			int j = i-1;
			
			while(j>=0 && data[j] > curValue) {
				data[j+1] = data[j];
				j--;
			}
			data[j+1] = curValue;
		}
		
		return data;
	}

	public static void main(String[] args) {
		
		int[] testData = new int[]{3,1,8,9,7,5,2,4};
		
		insertionSort(testData);
		
		for(int i : testData) {
			System.out.print(i + " ");
		}		
	}	
}
