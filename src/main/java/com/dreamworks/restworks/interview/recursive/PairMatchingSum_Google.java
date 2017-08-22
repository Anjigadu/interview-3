package com.dreamworks.restworks.interview.recursive;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class PairMatchingSum_Google {

	public static void main(String[] args) {
		List<Integer> data = new ArrayList<>(Arrays.asList(1,2,3,9));
		List<String> stringData = new ArrayList<>(Arrays.asList("dongjin","son"));
		
			
//		data = null;
		int sum = 5;
		
		isMatchingPairToSum_n2(data, sum);
		isMatchingPairToSum(data, sum);
	
//		int[] dataArray = {1,2,3,9};

		int[] dataArray = {1,9,8,10,5,7,9,6,23,21,24,34,78,98,64,4,3,12,15,17,18,2,20};
		
		// Integer dataArrayInt[]  = new Integer[data.size()];		
		// dataArrayInt = data.toArray(dataArrayInt);
		
		isMatchingPairToSum_array(dataArray, sum);
		
	}
	// boolean : primitive type
	// Boolean : object, containes a single type which is boolean ==> Serializable wraper of boolean
		
	public static boolean isMatchingPairToSum_n2(List<Integer> data, int sum) {
		
		if(data!=null) {
			for(Integer i : data) {
				for(Integer j : data) {
					if(i+j == sum) {
						 System.out.println("Matching Pair:" + i + " + " + j);						    
						return true;
					}
				}
			}		
		}
		System.out.println("No Matching Pair found for sum:" + sum);		
		return false;
	}
	
	public static boolean isMatchingPairToSum(List<Integer> data, int sum) {
		
		if(data==null)
			return false;
		
		Set<Integer> compSet = new HashSet<>();
		
		for(int i: data) {		
			int comp = sum - i;
		     if(compSet.contains(comp)) {
		    	 System.out.println("Matching Pair:" + i + " + " + comp);
		    	 return true;
		     }
		     else{
		    	 compSet.add(i); 
		     }
		}
   	 
		System.out.println("No Matching Pair found for sum:" + sum);
		return false;		
	}
	
	
	public static boolean isMatchingPairToSum_array(int[] data, int sum) {
		
		if(data==null)
			return false;
		
		final int defaultSize = 10;
		int[] compArray = new int[defaultSize];

		int compSize = 0;
		
		for(int i: data) {		
			int comp = sum - i;
			
			for(int j=0;j<compSize; j++) {
				if(compArray[j] == comp) {
					System.out.println("Matching Pair:" + i + " + " + comp);			    		
					return true;
				}
			}			
			compArray[compSize++] = i;	
			
			if(compSize == compArray.length) {
				int [] compArrayNew = new int[compArray.length + defaultSize];
				compArrayNew = Arrays.copyOf(compArray, compArray.length + defaultSize);
				compArray = compArrayNew;
			}
		}
   	 
		System.out.println("No Matching Pair found for sum:" + sum);
		return false;		
	}
	
}
