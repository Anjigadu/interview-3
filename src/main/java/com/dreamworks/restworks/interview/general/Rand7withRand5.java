package com.dreamworks.restworks.interview.general;

import java.util.Random;

public class Rand7withRand5 {

	public static int rand5() {		
		Random rand = new Random();
		return rand.nextInt(5) + 1;
	}


	public static int rand7withRand5() {

		int num =0;
		do {
			num = rand5()*5 -5 + rand5();
		} while(num>21);

		return num%7 +1;

	}
 
	/*                                                       
	 *    rand5()    * 5    -5		+rand5()       (repeat if num>21)     %7   +1
	 *                       	
	 *         1       5	0		1-5      
	 *  	   2      10	5		6-10         1~25      1-21		     0~6   1-7
	 *         3      15	10		11-15        
	 *         4      20	15		16-20
	 *         5      25	20		21-25
	 */
	
		
	public static void main(String[] args) {
		
		System.out.println("\n rand5()");
		for(int i=0; i<50; i++) {
			System.out.print(rand5() + " ");
		}
		
		System.out.println("\n rand7()");
		for(int i=0; i<50; i++) {
			System.out.print(rand7withRand5() + " ");
		}
	}
	
	
}
