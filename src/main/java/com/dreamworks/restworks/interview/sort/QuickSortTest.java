package com.dreamworks.restworks.interview.sort;

public class QuickSortTest {

	public static void quickSort(int[] num) {
				
		int left = 0;
		int right = num.length-1;		
		quickSort(num, left, right);
	}
	
	public static void quickSort(int[] num, int left, int right){
		
		int pivot = num[left + (right-left)/2];
		
		int i = left;
		int j = right;
		
		while(i<=j) {
			
			while(num[i] < pivot) {
				i++;
			}

			while(num[j] > pivot) {
				j--;
			}

			if(i<=j) {
				exchange(num, i,j);
				i++;
				j--;
			}
			
			System.out.print("i:" + i + ", j:" + j);
			System.out.println("");

			for(int k: num) {
				System.out.print(k + " ");
			}
			System.out.println("");
			
		}
		
		if(left <j) {
			quickSort(num,left, j);
		}
		
		if(right >i) {
			quickSort(num, i,right);
		}		
	}

	public static void exchange(int[] num, int i, int j){		
		int temp = num[i];
		num[i] = num[j];
		num[j] = temp;		
	}
	
	public static void main(String[] args) {
		
		//int[] num = {7,9,10,5,4,8,2};
		
		int[] num = {5,1,2};
		
		quickSort(num);
		
		for(int i : num) {
			System.out.print(i + " ");
		}
	}
}
