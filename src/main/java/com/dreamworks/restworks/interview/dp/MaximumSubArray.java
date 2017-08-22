package com.dreamworks.restworks.interview.dp;

public class MaximumSubArray {

		
	//----------------------------------------------------
	// returns the maximum value including the i th value 
	//----------------------------------------------------
	public static int maxSubArrayValue_recursive(int [] arr, int i) {		

		// base 
		if(i==0) {
			return arr[i];
		}
		else{
			return Math.max(maxSubArrayValue_recursive(arr, i-1) + arr[i], arr[i]);
		}
	}
	
	public static int maxSubArrayValue_dp(int [] arr) {
	
		int [] result = new int[arr.length];
		
		// base
		result[0] = arr[0];
		
		for(int i=1; i < arr.length; i++) {
			result[i] = Math.max(result[i-1] + arr[i], arr[i]);
		}
		
		int max = result[0];
		for(int i=1; i < result.length; i++) {
			if(max < result[i]){
				max = result[i];
			}
		}
		return max;
	}
	
	public static void main(String[] arg) {
		int[] arr = {1,2,-3,-4,2,7,-2,3};		
		//int[] arr = {1};		
		
		System.out.println("Max seq value (recursive):" + maxSubArrayValue_dp(arr));
		
		System.out.println("Max seq value (recursive):" + maxSubArrayValue_recursive(arr,arr.length-1));
		
	}
	
	
	
}
