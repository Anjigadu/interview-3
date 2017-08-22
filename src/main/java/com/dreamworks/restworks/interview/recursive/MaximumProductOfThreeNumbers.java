package com.dreamworks.restworks.interview.recursive;

import java.util.Arrays;

public class MaximumProductOfThreeNumbers {

	
	public static int getMaximumProduct(int[] nums) throws Exception {
		
		if(nums!=null && nums.length >=3) {
			Arrays.sort(nums);
			
			for(int n : nums) {
				System.out.println(n);
			}
			
			int maxProductOf3 = nums[nums.length-1] *  nums[nums.length-2] *  nums[nums.length-3];
			return maxProductOf3;
		}
		else {
			 throw new Exception("invalid input (either null or array with less than 3 elements");
		}
	}
	
	public static void main(String[] args) {
		
		int[] testNums = new int[] {5,2,3,1,6};	
		testNums = new int[] {1,6};	
		
		try {
			System.out.println("Answer:" + getMaximumProduct(testNums));
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}	
		
	}
	
}
