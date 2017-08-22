
package com.dreamworks.restworks.interview.boingo;

import java.util.HashMap;
import java.util.Map;

public class RepeatedCharCount {

	public static Map<Character,Integer> getRepeatedCharMap(char[] arr){
		
		int count =1;
		char prev = arr[0];
		Map<Character, Integer> map = new HashMap<>();
		
		for(int i=1; i< arr.length; i++) {
		
			if(arr[i]==prev) {
				count++;
			}			
			else{
				
			    if(!map.containsKey(prev) || map.containsKey(prev) && map.get(prev) < count) {
			    	map.put(prev, count);
			    }
			    // reset after processing
			    count =1;
				prev = arr[i];
				
			}			
		}
		
		if(count >1){
			if(!map.containsKey(prev) || map.containsKey(prev) && map.get(prev) < count) {
		    	map.put(prev, count);
		    }
		}
		
		for(Character c: map.keySet()){
			System.out.println(c + ":" + map.get(c));
		}
		
		return map;		
	}


	public static void main(String[] args){
		char[] arr = {'a','b','c','c','b','b','b'};
		
		String str = "abccbbb";
		char[] arr2 = str.toCharArray();

		getRepeatedCharMap(arr);
		
	}
	
}
