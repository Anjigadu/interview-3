package com.dreamworks.restworks.interview.search;

public class PartialSortedBinarySearch {

	public static int getMin(int[] nums) {

		if(nums==null) {
			return Integer.MIN_VALUE;
		}
		
		int left = 0;
		int right = nums.length -1;
				
		while(left < right) {
			int mid = (left+right) /2;			
			System.out.println("left:" + left + ", m:" + mid  + ", right:" + right);
			System.out.println("nums[left]:" + nums[left] + ", nums[m]:" + nums[mid]  + ", nums[right]:" + nums[right]);

			if(nums[left] < nums[right]){
				return nums[left];
			}			
			else if(nums[mid] == nums[left]) {
				left = mid+1;
			}			
			else if(nums[mid] > nums[left] ) {
				left = mid +1;
			}
			else{
				right = mid;
			}			
		}
		
		System.out.println("left->" + left);
		
		return nums[left];
	}
	
 
	public static void main(String[] args) {

		int arr[] = {5,1,2,3,4};
//		int arr[] = {1,2,3,4,5};
//		int arr[] = {7,8,9,10,1,2,3,4,5};
//		int arr[] = {7,8,9,10,10,10,10,10,1,2,2,2,3,4,5};
			
		System.out.println("Min value: " + getMin(arr));
	
	}
	
}
