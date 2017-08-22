package com.dreamworks.restworks.interview.sort;

public class QSort {

	int[] numbers;
	
	public QSort(int[] numbers){
		this.numbers = numbers;
	}
	
	public void sort() {
		
		int left = 0;
		int right = numbers.length -1;
		
		quickSort(0, right);
		
		
	}
	
	public void quickSort(int left, int right) {
		
		int mid = (left+right)/2;
		
		int pivot = numbers[mid];
		
		int i = left;
		int j = right;

		while(i<=j) {
			while(numbers[i]<pivot) {
				i++;
			}
			
			while(numbers[j] >pivot) {
				j--;
			}

			if(i<=j) {
				exchange(i,j);
				i++;
				j--;
			}
		}
		
		if( j>left) {
			quickSort(left,j);
		}
		if(i < right) {
			quickSort(i,right);
		}
		

	}
	
	public void exchange(int i, int j) {
		int temp = numbers[i];
		numbers[i] = numbers[j];
		numbers[j] = temp;
	}
	
	
}
