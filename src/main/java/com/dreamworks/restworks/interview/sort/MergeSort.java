package com.dreamworks.restworks.interview.sort;

public class MergeSort {

	int[] nums;
	int[] aux;
	
	public void mergeSort(int[] nums) {
		
		if(nums==null || nums.length==1){
			return;
		}		
		this.nums = nums;
		aux = new int[nums.length];
		
		mergeSort(0,nums.length-1);
			
	}
	
	
	
	private void mergeSort(int left, int right) {

		if(left < right) {
			int mid = (left + right)/2;

			mergeSort(left,mid);
			mergeSort(mid+1,right);
			merge(left,mid,right);
		}
	}

	private void merge(int left, int mid, int right) {
		
		// Copy value
		for(int i=left; i <=right; i++) {
			aux[i] = nums[i];
		}
		
		int i = left;
		int j = mid +1;
		
		// index 
		int k = left;
		
		while(i<=mid && j <=right) {
			if(aux[i] < aux[j]) {
				nums[k] = aux[i];
				i++;
			}
			else{
				nums[k] = aux[j];
				j++;
			}
			k++;
		}
		
		// only need to copy samller ones
		//
		// e.g.,    1 5  2 3
		//          1 2  3 (5)
		// e.g.,    4 5  2 3
		//          2 3  (4 5)
		// e.g.,    1 4  3  5
		//          1 3  4
		
		
		while(i<=mid) {
			nums[k] = aux[i];
			i++;
			k++;
		}	
		/*
		while(j<=right) {
			nums[k] = aux[j];
			j++;
			k++;
		}	
		*/			

	}
	

	public static void mergeSortStatic(int[] nums, int left, int right, int[] aux) {
		
		if(left < right) {
			int mid = (left + right)/2;

			mergeSortStatic(nums, left, mid, aux);
			mergeSortStatic(nums, mid+1,right,aux);
			mergeStatic(nums,left, mid,right,aux);
		}
	}

	public static void mergeStatic(int[] nums, int left, int mid, int right, int[] aux) {
		

		// Copy value
		for(int i=left; i <=right; i++) {
			aux[i] = nums[i];
		}

		int i = left;
		int j = mid+1;
		
		int count=0;
		while(i<=mid && j <= right) {
			
			if(aux[i] < aux[j]) {
				nums[count] = aux[i];
				i++;
			}
			else{
				nums[count] = aux[j];
				j++;
			}	
			count++;
		}
		
		if(i<mid){
			while(i<=mid) {
				nums[count] = aux[i];
				i++;
			}
 		}
		else{
			while(j<=right) {
				nums[count] = aux[j];
				j++;
			}
		}		
	}
	
	
	
	public static void main(String[] args) {
		
		int[] nums = {1,5,9,10,4,2,3,7};
		//int[] nums = {1,2,3,4,5,6,7,8};
		
		//int[] nums = {1,2};
		
		
		MergeSort sort = new MergeSort();
		sort.mergeSort(nums);
		
		for(int i : sort.nums) {
			System.out.print(i + " ");
		}
		
		int[] nums2 = {1,5,9,10,4,2,3,7};
		
		int [] aux = new int[nums2.length];
		
		mergeSortStatic(nums2, 0, nums2.length-1, aux);
		
		System.out.println("Static");
		for(int i : nums2) {
			System.out.print(i + " ");
		}
		
	}
	
	
}
