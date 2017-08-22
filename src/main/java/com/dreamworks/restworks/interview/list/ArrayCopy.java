package com.dreamworks.restworks.interview.list;

public class ArrayCopy {

	
	public static void arrayCopy() {
		int[] intValues = {0,1,2,3,4};
		
		int[] newIntArray = new int[intValues.length];
		
		System.arraycopy(intValues, 0, newIntArray, 0, 5);
		
		for(int i : newIntArray) {
			System.out.print(i + " ");
		}
		
		
	}
	
	public static void main(String[] args) {
		arrayCopy();
	}
}
