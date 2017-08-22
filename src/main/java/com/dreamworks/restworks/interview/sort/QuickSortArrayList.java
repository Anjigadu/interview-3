package com.dreamworks.restworks.interview.sort;

import java.util.ArrayList;
import java.util.List;

public class QuickSortArrayList {

	
	public static void main(String[] args) {
		
		//int [] testData = new int[] {1,2,8,9,5,4,3,7,6};
		
		List<Integer> listInt = new ArrayList();
		listInt.add(1);
		listInt.add(8);
		listInt.add(9);
		listInt.add(5);
		listInt.add(4);
		
		QuickSortArrayList.quicksort(listInt);
		
		for(int i : listInt) {
			System.out.print(i + " ");
		}
	
	}
	
	public static List<Integer> quicksort(List<Integer> numbers) {
		if(numbers.size() <2) {
			return numbers;
		}
		
		quicksort(0, numbers.size()-1,numbers);		
		return numbers;
	}
	
	private static void quicksort(int left, int right, List<Integer> numbers){
		
		int i = left;
		int j = right;
		
		final Integer pivot = numbers.get((left+right)/2);
		
		while(i<=j) {
			
			// <= ==> does not work
			if(numbers.get(i) < pivot) {
				i++;
			}
			
			if(numbers.get(j) > pivot) {
				j--;
			}
			
			if(i<=j) {
				exchange(i,j,numbers);
				i++;
				j--;
			}			
		}
		
		if(left < j) {
			quicksort(left,j, numbers);
		}
		
		if(right >i) {
			quicksort(i,right,numbers);
		}		
	}
	
	public static void exchange(int i, int j, List<Integer> numbers) {
		int temp = numbers.get(i);
		numbers.set(i, numbers.get(j));
		numbers.set(j,  temp);
	}
	
}
