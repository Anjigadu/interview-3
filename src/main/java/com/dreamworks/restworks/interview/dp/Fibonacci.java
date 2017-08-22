package com.dreamworks.restworks.interview.dp;

import java.util.HashMap;
import java.util.Map;

public class Fibonacci {

	public static int fibRecursion(int n) {
		if(n<=1) {
			return n;
		}
		else{
			return fibRecursion(n-1) + fibRecursion(n-2);
		}
	}
	
	Map<Integer,Integer> fibMap = new HashMap<>();
	
	public int fibRecursionWithMemorization(int n) {
		if(n<=1) {
			return n;
		}
		else{
			
			if(fibMap.get(n)!=null) {
				System.out.printf("Using fib[%d]: %d \n", n, fibMap.get(n));				
				return fibMap.get(n);
			}
			else{
				int fibN = fibRecursionWithMemorization(n-1) + fibRecursionWithMemorization(n-2);
				fibMap.put(n,fibN);
				System.out.printf("Storing fib(%d): %d \n", n, fibN);
				
				return fibN;
			}
		}
	}
	
	public static int fibRecursionWithMemorization(int n, Map<Integer,Integer> fibMap) {
		if(n<=1) {
			return n;
		}
		else{
			
			if(fibMap.get(n)!=null) {
				//System.out.printf("Using fib[%d]: %d \n", n, fibMap.get(n));				
				return fibMap.get(n);
			}
			else{
				int fibN = fibRecursionWithMemorization(n-1, fibMap) + fibRecursionWithMemorization(n-2, fibMap);
				fibMap.put(n,fibN);
				//System.out.printf("Storing fib(%d): %d \n", n, fibN);
				
				return fibN;
			}
		}
	}
	
	
	public static int fibIterative(int n){
				
		if(n <0) {
			return -1;
		}
		else if(n<=1) {
			return n;
		}
		else{			
			int fib1=0;
			int fib2=1;			
			int fibNext = 1;
			
			for(int i=2; i<=n;i++){
				fibNext = fib1 + fib2;
				fib1= fib2;
				fib2 = fibNext;
			}
			return fibNext;
		}		
	}
	
	public static void main(String[] args) {
		System.out.println("recursive:" + fibRecursion(5));		
		System.out.println("iterative:" + fibIterative(5));	
		
		Fibonacci fibWithMem = new Fibonacci();
		
		System.out.println("recursive w/ memorization" + fibWithMem.fibRecursionWithMemorization(7));
		
		System.out.println("* Created Map from memorization");
		for(int key : fibWithMem.fibMap.keySet()) {
			System.out.printf("key:%d => value:%d \n", key, fibWithMem.fibMap.get(key));
			
		}		
		
		Map<Integer,Integer> fibMap = new HashMap<>();
		fibRecursionWithMemorization(7, fibMap);
		
		for(int key : fibMap.keySet()) {
			System.out.printf("key:%d => value:%d \n", key, fibWithMem.fibMap.get(key));
			
		}	
	}
	
}
