package com.dreamworks.restworks.interview.amazon;

import java.util.Arrays;

public class PythagoreanTriplet {

	public static boolean hasPythagoreanTriplet(int[] arr) {

		if(arr==null || arr.length <3) {
			return false;
		}

		int n = arr.length;

		// (1) Sort array => O(nlogn)
		Arrays.sort(arr);

		// (2) Calculate Square Value (^2) => O(n)
		for(int i=0; i< arr.length;i++) {
			arr[i] = arr[i]*arr[i];
		}

		// (3) for each c^2 value, try to find a^2 and b^2 
		//     using meet in middle algorithm ==> O(n^2)
		for(int i=n-1;i>=2;i--) {

			int left = 0;
			int right = i-1;

			while(left <right) {
				if(arr[left] + arr[right] == arr[i]) {
					System.out.println("* Found Pythagorean Triplet: " + (int)Math.sqrt(arr[left]) + "^2 + " + (int)Math.sqrt(arr[right]) + "^2 = " + (int)Math.sqrt(arr[i]) + "^2");
					return true;
				}
				else if(arr[left] + arr[right] < arr[i]) {
					left++;
				}
				else{
					right --;
				}
			}			
		}
		return false;
	}	


	public static void main(String[] args) {

		int[] arr = {1,8,7,6,3,4,5,9};

		System.out.println("Result: " + hasPythagoreanTriplet(arr));

	}
}


