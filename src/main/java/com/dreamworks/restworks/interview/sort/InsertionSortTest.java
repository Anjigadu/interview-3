package com.dreamworks.restworks.interview.sort;

public class InsertionSortTest {

	public static void insertionSort(int[] num){
		
		for(int i=1;i<num.length; i++) {
			
			int curValue = num[i];
			int j = i-1;
			
			while(j>=0 && num[j] > curValue) {
				num[j+1] = num[j];
				j--;
			}
			num[j+1] = curValue;
		}
	}

	public static void main(String[] args) {
		
		int[] testData = new int[]{15,1,8,9,7,5,2,4};
		
		insertionSort(testData);
		
		for(int i : testData) {
			System.out.print(i + " ");
		}		
	}	
	
}
