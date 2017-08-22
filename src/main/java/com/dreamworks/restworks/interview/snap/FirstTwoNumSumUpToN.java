package com.dreamworks.restworks.interview.snap;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class FirstTwoNumSumUpToN {

	public static void firstTwoNumSumN(int[] arr, int k){
		
		Set<Integer> neededSet = new HashSet<>();
		for(int i: arr) {		
			if(neededSet.contains(i)){
			    int theOther = k-i;
				System.out.println(i + " and " + theOther);
				return;
			}
			else{
				neededSet.add(k-i);
			}			
		}		
	}
	
	public static Integer findOddNumberRepeatedTheHighestNumberInList(List<Integer> list) {
		
		Map<Integer,Integer> map = new HashMap<>();
		
		for(int i: list){
			if(i%2!=0) {

				if(map.containsKey(i)) {
					map.put(i, map.get(i) +1 );
				}
				else{
					map.put(i, 1);
				}
			}
		}

		int max= Integer.MIN_VALUE;
		for(int i:map.keySet()) {
			if(map.get(i) > max) {
				max = map.get(i);
			}
		}
		
		return max;

	}
	
	public static void main(String[] args){
		int[] arr = {1,2,3,4,5};
		List<Integer> list = Arrays.asList(1,2,3,4,5,2,3,2);
		firstTwoNumSumN(arr,6);
		System.out.println("max: " + findOddNumberRepeatedTheHighestNumberInList(list));
	}
	
	
}
