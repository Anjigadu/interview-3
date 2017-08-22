package com.dreamworks.restworks.interview.string;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class FirstNonRepeatedChar {

	public static int findFirstNonRepeatedChar(String str) {

		Map<Character, Integer> map = new HashMap<>();

		for(int i=0; i<str.length(); i++) {
			if(map.containsKey(str.charAt(i))) {
				map.put(str.charAt(i), map.get(str.charAt(i)) +1);
			}
			else{
				map.put(str.charAt(i), 1);				
			}
		}
		
		for(int i=0; i<str.length(); i++) {		
		
			if(map.get(str.charAt(i)) ==1){
				System.out.println("first non-repeated char:" + str.charAt(i) + " at index:" + i);
				return i;
			}
		}
		return -1;		
	}

	public static Character findFirstNonRepeatedCharLinkedHashMap(String str) {

		Map<Character, Integer> map = new LinkedHashMap<>();

		for(int i=0; i<str.length(); i++) {
			if(map.containsKey(str.charAt(i))) {
				int value = map.get(str.charAt(i));				
				map.remove(str.charAt(i));
				map.put(str.charAt(i), value +1);
			}
			else{
				map.put(str.charAt(i), 1);				
			}
		}

		Character key = map.keySet().iterator().next();
		if(map.get(key)==1) {
			System.out.println("* first non-repeated char :" + key);	
			return key;
		}
		else{
			return null;
		}
			
	}
	
	
	
	
	public static void main(String[] args) {
		String str = "abcab";
		int idx = findFirstNonRepeatedChar(str);
		
		findFirstNonRepeatedCharLinkedHashMap(str);
	}





}
