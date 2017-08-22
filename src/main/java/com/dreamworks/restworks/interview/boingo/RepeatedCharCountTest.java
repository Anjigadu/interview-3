package com.dreamworks.restworks.interview.boingo;

import static org.junit.Assert.assertEquals;

import org.junit.Test;


public class RepeatedCharCountTest {

	
	@Test
	public void testRepeatedCharCount() {
		String str = "abccbbb";
		char[] arr = str.toCharArray();

		assertEquals(3, RepeatedCharCount.getRepeatedCharMap(arr).keySet().size());
		
	}
}
