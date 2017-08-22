package com.dreamworks.restworks.interview.recursive;

public class PermutationOfString {

	//==================================================
	// Permute char[]
	//==================================================
	
	public static void permute_recursive(char[] arr, int start) {
	
		if(arr!=null & arr.length >0) {			

			// base condition ==> when it reaches to the last index
			if(start==arr.length-1) {
				printCharArray(arr);				

			}
			else{			
				for(int i=start;i<arr.length;i++) {				
					swap(arr,start,i);
					permute_recursive(arr, start+1);
					swap(arr,start,i);
				}
			}
		}		
	}
	
	public static void swap(char[] arr, int i, int j) {
		char temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
	
	public static void printCharArray(char[] arr){
		System.out.println(String.valueOf(arr));
	}

	//==================================================
	// Permute String
	//==================================================	
	public static void permuteString(String str) {
		if(str==null|| str.length()==0){
			return;
		}
		else{
			permute_recursive(str.toCharArray(),0);
		}		
	}	
	
	public static void main(String[] args) {
		char[] arr = "abc".toCharArray();	
		permute_recursive(arr,0);	
		
	
		printChar(arr);
		
		printChar2(arr);
		
		printChar(arr);
	
		
		char[] arr2 = "abc".toCharArray();	
		
		System.out.println("\n--\n");
		perm_r(arr2, 0);
		
			
	}
	

	public static void printChar(char[] arr){
		System.out.print("\n");
		arr[0] = arr[1];
			
		for(char c: arr){
			System.out.print(c);
		}
	}

	public static void printChar2(char[] arr){
		System.out.print("\n");
		for(char c: arr){
			System.out.print(c);
		}
		
	}
	
	
	public static void perm_r(char[] arr, int start) {
		
		if(start == arr.length-1) {
			System.out.println(new String (arr));
		}
		
		for(int i=start; i< arr.length;i++) {
			swap(arr,start,i);
			perm_r(arr,start+1);
			swap(arr,start,i);			
		}
	}
	
	public static void swap2(char[] arr, int i, int j) {
		char temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
	
}
