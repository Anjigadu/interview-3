package com.dreamworks.restworks.interview.search;

public class BinarySearch {

	public static int binarySearch(int[] data, int target) {

		//Arrays.sort(data);
		
		int left = 0;
		int right = data.length - 1;
		
		while(left <= right) {
			int mid = (left + right) / 2;
			if(data[mid] == target) {
				return mid;
			}
			else if (target < data[mid]) {
				right = mid - 1;
			}
			else{
				left = mid + 1;
			}
		}		
		return -1;
	}
	
	public static void main(String[] arg) {
		
		//int[] testData = new int[] {1,3,5,7,9,11,12,15,20};
		int[] testData = new int[] {1,2};				
		
		int foundIndex = binarySearch(testData, 0);
		if(foundIndex >=0) {
			System.out.printf("found index is =%d and value is =%d", foundIndex, testData[foundIndex]);
		}
	}
}
