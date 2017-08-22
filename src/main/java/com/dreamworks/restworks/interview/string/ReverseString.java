package com.dreamworks.restworks.interview.string;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ReverseString {

	public static String reverseString(String str){
		if(str!=null) {
			char[] array = str.toCharArray();

			int l =0;
			int r = str.length() -1;
			
			while(l < r) {

				char lchar = array[l];
				array[l] = array[r];
				array[r] = lchar;				
				l++;
				r--;				
			}
			String rvsStr = String.copyValueOf(array);
			return rvsStr;
		}		
		return str;
	}
	
	public static void main(String[] args){
		
		String str = "abcd";
		System.out.println(reverseString(str));
		
		/*
		List<Integer>  a = new ArrayList<Integer>();
		for (Integer integer : a)
		{
		  integer.toString();
		}
		*/
		
		List<Integer>  a = new ArrayList<Integer>();
		 
		for (Iterator<Integer> iterator = a.iterator(); iterator.hasNext();) {
		   Integer integer = (Integer) iterator.next();
		   integer.toString();
		}
		
		Iterator<Integer> iterator = a.iterator();
		
		while( iterator.hasNext()) {
			   Integer integer = (Integer) iterator.next();
			   integer.toString();
			}
			
		
		
				
	}
	
}
