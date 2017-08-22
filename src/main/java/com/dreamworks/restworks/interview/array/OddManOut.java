package com.dreamworks.restworks.interview.array;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class OddManOut {

	/*
	 *  Find out the only number which appears odd number in the array
	 */
	public static int oddManOut(int[] array) {

		HashSet<Integer> s = new HashSet<Integer>();
		int sum = 0;

		for (int i = 0; i < array.length; i++) {
			if (!s.contains(array[i])) {
				s.add(array[i]);				
				sum = sum + array[i];
			} else {
				s.remove(array[i]);
				sum = sum - array[i];
			}
		}
		return sum;
	}
	
	//  Find out the only number which appears single time in the array
	
	public static int oddManOutWithMap(int[] array) {

		Map<Integer,Integer> s = new HashMap<>();
	
		for (int i = 0; i < array.length; i++) {
			if(s.containsKey(array[i])){
				s.put(array[i], s.get(array[i]) +1);
			}
			else{
				s.put(array[i], 1);
			}
		}
		
		int oddMan =0;
		
		for(Integer i: s.keySet()){
			if(s.get(i) == 1) {
				oddMan = i;
				break;
			}					
		}
		return oddMan;
	}

	static int oddManOutWithXOR(int[] array) {
		int val = 0;
		for (int i = 0; i < array.length; i++) {
			val ^= array[i];
		}
		return val;
	}
	
	public static void main(String[] arg) {
		//int[] nums = {1,1,2,3,3,4,4,5,5};
		int[] nums = {1,2,3,3,1};
		
		System.out.println("odd number:" + oddManOut(nums));
		
		System.out.println("odd number (w/ map):" + oddManOutWithMap(nums));
		System.out.println("odd number (w/ XOR):" + oddManOutWithXOR(nums));
			
	}



}
