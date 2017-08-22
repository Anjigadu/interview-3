package com.dreamworks.restworks.interview.dp;

public class CakeType {

	int weight;
	int value;

	public CakeType(int weight, int value) {
		this.weight = weight;
		this.value  = value;
	}
	
	public static int maxDuffelBagValue(CakeType[] cakeTypes, int minCakeWeight, int capacity) {
  		
		if(capacity< minCakeWeight) {
			return 0;
		}
		
		int maxValue = Integer.MIN_VALUE;
		CakeType selected = null;
		
		for(CakeType type : cakeTypes) {
			if(type.weight <= capacity) {

				int subMaxValue = maxDuffelBagValue(cakeTypes, minCakeWeight, capacity - type.weight) + type.value;
				
				if(maxValue <subMaxValue) {
					maxValue = subMaxValue;
					selected = type;
				}
			}
		}

		// if(selected!=null)
		// System.out.println("* Selected Type: (" + selected.weight + "," + selected.value +") for capacity :" + capacity);
		
		return maxValue;
		
	}
	
	
	public static int maxDuffelBagValue_dp(CakeType[] cakeTypes, int[] maxValueForCapacity, int capacity) {
		
		if(capacity<2) {
			return 0;
		}
		 		
		for(CakeType type : cakeTypes) {
			if(type.weight <= capacity) {

				int subMaxValue = maxDuffelBagValue_dp(cakeTypes, maxValueForCapacity, capacity - type.weight) + type.value;
													
				if(maxValueForCapacity[capacity] < subMaxValue) {
					maxValueForCapacity[capacity] = subMaxValue;
				}
			}
		}

		return maxValueForCapacity[capacity];		
	}


	public static void main(String[] args) {

		CakeType[] cakeTypes = new CakeType[] {
				new CakeType(7, 160),
				new CakeType(3, 90),
				new CakeType(2, 15),
		};

		int capacity = 20;

		int minWeight = Integer.MAX_VALUE;
		
		for(CakeType ct : cakeTypes) {
			if(ct.weight < minWeight)
				minWeight = ct.weight;
		}
		
		int result = maxDuffelBagValue(cakeTypes, minWeight, capacity);
		
		System.out.println("Max Value (recursive):" + result);
		
		int[] best = new int[21];
		for(int b : best) {
			b = Integer.MAX_VALUE;
		}
		result = maxDuffelBagValue_dp(cakeTypes, best, capacity);
		System.out.println("Max Value (dynamic programming):" + result);		
		
	}

}
