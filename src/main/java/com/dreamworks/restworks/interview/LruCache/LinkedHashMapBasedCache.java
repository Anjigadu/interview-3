package com.dreamworks.restworks.interview.LruCache;

import java.util.LinkedHashMap;

public class LinkedHashMapBasedCache {

	static final int CAPACITY = 10;
	
	LinkedHashMap<String,Integer> hmLruCache = new LinkedHashMap<>();
	
	public void set(String key, Integer value) {

		if(hmLruCache.get(key)!=null){
			hmLruCache.remove(key);
		}

		if(hmLruCache.size() == CAPACITY) {
			// remove the first one (oldest one, in the cache)
			String firstKey = hmLruCache.keySet().iterator().next();
			hmLruCache.remove(firstKey);			
		}
		hmLruCache.put(key, value);				
	}

	// put accessed item to the end
	public Integer get(String key) {
		Integer value = hmLruCache.get(key);
		if(value!=null){
			hmLruCache.remove(key);
			hmLruCache.put(key, value);
		}
		return value;
	}
	
	
	
	public static void main(String[] args) {
	
		// test
		LinkedHashMapBasedCache cacheNumVisit = new LinkedHashMapBasedCache();
		cacheNumVisit.set("dongjin", 7);
		cacheNumVisit.set("david", 4);
		cacheNumVisit.set("ian", 8);
		
		System.out.println("* Cache Order before accessing (dongjin)");
		for(String key : cacheNumVisit.hmLruCache.keySet()) {
			System.out.println(key);
		}
		cacheNumVisit.get("dongjin");
		
		System.out.println("* Cache Order before accessing (dongjin)");		
		for(String key : cacheNumVisit.hmLruCache.keySet()) {
			System.out.println(key);
		}
	}	
}
