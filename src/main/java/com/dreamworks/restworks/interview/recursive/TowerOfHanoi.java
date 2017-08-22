package com.dreamworks.restworks.interview.recursive;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TowerOfHanoi {

	
	public static void main(String[] args) {
//		List<Integer> data = new ArrayList<>(Arrays.asList(1,2,3,9));
	
		moveRings(3,"A","B","C");	
	}
		
	public static void moveRings(int n, String start, String aux, String end) {
		if(n==1) {
			System.out.println(start + " => " + end);
		}
		else{
			moveRings(n-1,start, end, aux);
			System.out.println(start + " => " + end);
			moveRings(n-1,aux,start,end);
		}
	}
	
	
}
