package com.dreamworks.restworks.interview.LruCache;

import java.util.LinkedHashMap;

public class LruCacahLlikedhmap {

	private final LinkedHashMap<String, Integer> lhmap = new LinkedHashMap<>();
	
	int capacity = 10;
	
	public void set(final String key, final Integer value){
		if(lhmap.containsKey(key)){
			lhmap.remove(key);
		}
			if(capacity == lhmap.size()) {
				String firstKey = lhmap.keySet().iterator().next();
				lhmap.remove(firstKey);				
			}						
		lhmap.put(key, value);
	}
	
	public Integer get(final String key) {
		if(lhmap.containsKey(key)) {
			int value = lhmap.get(key);
			lhmap.remove(key);
			lhmap.put(key, value);
			
			return value;
		}
		return null;
	}
	
	public LruCacahLlikedhmap(int capacity){
		this.capacity = capacity;
	}
	
	
}
