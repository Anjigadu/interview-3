package com.dreamworks.restworks.interview.sort;

public class QuickSort {

	int [] numbers;
	
	public void sort(int[] values){
		
		if(values==null || values.length==0) {
			return;
		}		
		numbers = values;
		quickSort(0, values.length-1);
	}
	
	private void quickSort(int left, int right)
	{		
		int i = left, j=right;
		
		int pivot = numbers[left + (right-left)/2];
	
		while (i<=j) { 
			
			while(numbers[i] < pivot) {
				i++;
			}
			
			while(numbers[j] > pivot) {
				j--;
			}
			
			if(i <= j) {			
				exchange(i,j);
				i++;
				j--;
			}			
		}		
		
		if(left < j) {
			quickSort(left,j);
		}
		
		if(right>i) {
			quickSort(i,right);
		}		
	}
	
	
	private void exchange(int i, int j) {		
		int temp = numbers[i];
		numbers[i] = numbers[j];
		numbers[j] = temp;		
	}
	
	public static void main(String[] args) {
		//int [] testData = new int[] {1,2,8,9,5,4,3,7,6};
		int [] testData = new int[] {5,6,3,9,1,7,2};
		
		QuickSort qs = new QuickSort();	
		qs.sort(testData);
		
		for(int i : qs.numbers) {
			System.out.print(i + " ");
		}
		
	}
	
	
}
