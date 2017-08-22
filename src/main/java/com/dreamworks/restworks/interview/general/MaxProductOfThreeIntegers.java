package com.dreamworks.restworks.interview.general;

import java.security.InvalidParameterException;
import java.util.Arrays;
import java.util.Collections;

public class MaxProductOfThreeIntegers {

	// Question List
	// - negative number can be included
	
	public static void main(String[] args) {
		
		int[] numArr = {-9,-8, 0, 4,1,5,10};
		
		System.out.println("Max Product of Three:" + maxProductOfThreeInt(numArr));		
	}
	
	public static int maxProductOfThreeInt(int[] numArr) {

		if(numArr==null || numArr.length <3) {
			throw new InvalidParameterException();
		}
			
		Arrays.sort(numArr);
		
	    int length = numArr.length;
	    
		if(numArr[0]*numArr[1] > numArr[length-3] * numArr[length-2]) {
			return numArr[0]*numArr[1] * numArr[length-1];
		}
		else{
			return numArr[length-3] * numArr[length-2] * numArr[length-1];
		}				
	}
	
}
