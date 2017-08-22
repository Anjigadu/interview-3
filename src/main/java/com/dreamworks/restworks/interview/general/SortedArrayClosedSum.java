package com.dreamworks.restworks.interview.general;

import java.security.InvalidParameterException;

public class SortedArrayClosedSum {

	public static int closetSum(int[] nums, int x) {
	
		if(nums==null || nums.length<2) {
			throw new InvalidParameterException();
		}
		int l=0;
		int r= nums.length -1;
		
		int minDiff = Integer.MAX_VALUE;

		int solution_l=0;
		int solution_r=0;
		
		while(l<r) {
			if(Math.abs(nums[l] + nums[r] -x) < minDiff) {

				minDiff = Math.abs(nums[l] + nums[r] -x);
				solution_l = l;
				solution_r = r;
			}
			
			if(nums[l] + nums[r] < x) {
				l++;
			}
			else{
				r--;
			}
		}
		
		return nums[solution_l] + nums[solution_r];
	}
	
	
	public static void main(String[] args) {
		
		int[] nums = {1,2,4,5,8,9,10};
		
		int solution = closetSum(nums, 14);
		System.out.println("Closest Sum is :" + solution);
	}
	
}
