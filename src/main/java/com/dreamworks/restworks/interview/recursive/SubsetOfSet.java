package com.dreamworks.restworks.interview.recursive;

public class SubsetOfSet {

	
	static void printSubsets(char[] set)
    {
        int n = set.length;
 
        // Run a loop for printing all (2^n)  ==  (1<<n) 
        // subsets one by one
     
        for (int i = 0; i < (1<<n); i++)
        {
            
        	System.out.print("* i:" + i);
        	 
        	System.out.print("{ ");
 
            // Print current subset (char count n)
            // if n=3 ==> out of 8 combinations
            //        ==> check for each char 
            // 0 0 0
            // 0 0 1
            // 0 1 0           0 0 1    ( 1<< 0)        
            // 0 1 1    &      0 1 0    ( 1<< 1)      
            // 1 0 0           1 0 0    ( 1<< 2)
            // 1 0 1
            // 1 1 0
            // 1 1 1 
                        
            for (int j = 0; j < n; j++) {

             	System.out.print("- (1<<j):" + (1& (1 <<j)));
            
                // (1<<j) is a number with jth bit 1
                // so when we 'and' them with the
                // subset number we get which numbers
                // are present in the subset and which
                // are not
                if ((i & (1 << j)) > 0)
                    System.out.print(set[j] + " ");
            }
            
            System.out.println("}");
        }
    }
	
	
	public static void main(String[] args) {
		
		
		int max = 1 << 3;    // 3 ==> 8
		System.out.println("max:" + max);
		
		char set[] = {'a', 'b', 'c'};
		printSubsets(set);

		/*
		set[0] => a
		set[1] => b
		set[2] => c
		*/
		
		
		
		/*
		List<Integer> set = new ArrayList<Integer>();
		
		set.add(1);
		set.add(2);
		set.add(3);
		
		
		int max = 1 << set.size();    // 3 ==> 8
		
		max >>=1;                     //   ==> 4
        */		
	}
	
	
	static void printSubsets_recur(char[] set, int s) {
		
		int n = set.length;
		
		
		for(int i=0; i <n; i++) {
			
			
			printSubsets_recur(set, s+1);
			
		}
		
	}
	 
	
	
}
