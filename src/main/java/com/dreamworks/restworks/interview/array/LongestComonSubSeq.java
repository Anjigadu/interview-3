package com.dreamworks.restworks.interview.array;

import java.util.ArrayList;
import java.util.List;

public class LongestComonSubSeq {

	public static char[] longestCommonSequence(char[] arr1, char[] arr2) {

		if(arr1!=null && arr2!=null){
			int i1=0;
			int i2=0;

			char[] lcs = new char[arr1.length];
			int j =0;

			while(i1 < arr1.length && i2 < arr2.length) {

				if(arr1[i1] == arr2[i2]){
					System.out.println("i1:" + i1 + ", i2:" + i2);
					lcs[j] = arr1[i1];
					i1++;
					i2++;
					j++;					
				}
				else if (arr1[i1] > arr2[i2]){
					i2++;
				}
				else {
					i1++;
				}
			}	
			return lcs;
		}
		return null;
	}

	// if m and n is the last index of array
	public static int lcm(char[] arr1, char[] arr2, int m, int n) {
	
		if(m==0 || n==0){
			return 0;
		}
		
		if(arr1[m]== arr2[n]) {
			return 1 + lcm(arr1, arr2, m-1, n-1);			
		}
		else if (arr1[m] > arr2[n]) {
			return lcm(arr1,arr2,m-1,n);
		}
		else{
			return lcm(arr1,arr2,m,n-1);
		}
			
	}
	
	// if m and n is the last index of array
	public static int lcmChars(char[] arr1, char[] arr2, List<Character> lcm, int m, int n) {
	
		if(m==0 || n==0){
			return 0;
		}
		
		if(arr1[m]== arr2[n]) {
			lcm.add(arr1[m]);
			return 1 + lcmChars(arr1, arr2, lcm, m-1, n-1);			
		}
		else if (arr1[m] > arr2[n]) {
			return lcmChars(arr1,arr2, lcm, m-1,n);
		}
		else{
			return lcmChars(arr1,arr2, lcm, m,n-1);
		}
			
	}
	
	
	
	
	
	
	
	
	public static int longestCommonSequence_dp(char[] arr1, char[] arr2, int m, int n) {

		if(m==0 || n==0) {
			return 0;
		}
		else{
			if(arr1[m-1] == arr2[n-1]){
				return longestCommonSequence_dp(arr1, arr2, m-1, n-1) +1;				
			}			
			else if(arr1[m-1] > arr2[n-1]){
				return longestCommonSequence_dp(arr1, arr2, m-1, n);				
			}
			else {
				return longestCommonSequence_dp(arr1, arr2, m, n-1);				
			}	
		}
	}

	public static void main(String[] args) {

		//		char[] arr1 = {'a','c','f','g','h','p','z'};
		//		char[] arr2 = {'b','g','h','i','o','p','s'};

		String s1 = "acfghpz";
		String s2 = "bghiopsz";

		char[] arr1=s1.toCharArray();
		char[] arr2=s2.toCharArray();

		char[] lcsArr = longestCommonSequence(arr1,arr2);

		System.out.println("*Longest Common SubSequence:" + String.valueOf(lcsArr));

		// Dynamic Programming
		int m = arr1.length;
		int n = arr2.length;


		int lcsArr2 = longestCommonSequence_dp(arr1,arr2,m,n);
		System.out.println("Longest Common SubSequence (dp):" + lcsArr2);
		
		int lcsArr3 = lcm(arr1,arr2,m-1,n-1);
		System.out.println("Longest Common SubSequence (dp2):" + lcsArr3);
		
		List<Character> lcmList = new ArrayList<>();
		
		int lcsArr4 = lcmChars(arr1,arr2, lcmList, m-1,n-1);
		System.out.println("Longest Common SubSequence (dp3):" + lcsArr3);
		System.out.println("Longest Common SubSequence (dp3):" + lcmList.toString());
		
		
//		char[] lcsArr2 = longestCommonSequence_dp(arr1,arr2,m,n);
//		System.out.println("Longest Common SubSequence (dp):" + String.valueOf(lcsArr));

		//		System.out.println("arr1[3]" +  arr1[3] + ", arr2[1]:" + arr2[1]);
		//		if(arr1[3]  == arr2[1]){
		//			System.out.println("yes:" +  arr2[1]);
		//		}
	}
}
