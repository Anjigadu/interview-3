package com.dreamworks.restworks.interview.general;

import java.util.Random;

public class DiceRollWithCoinFlip {

	
	
	
	
	// returns either 1 or 2
	public static int coinFlip() {		
		Random rand = new Random();
		return rand.nextInt(2) + 1;
	}
	
	// returns 1~6
	public static int diceRollWithCoinFlip() {	
		
		int i=0;
		int j=0;
		int k=0;
		
		do{
			i = coinFlip()==1 ? 0 : 1;
			j = coinFlip()==1 ? 0 : 2;
			k = coinFlip()==1 ? 0 : 4;
		} while(i+j+k>6 || i+j+k <1);
		
		return i+j+k;		
	}
	
	public static void main(String[] args) {
//		
//		System.out.println("\n coinFlip()");
//		for(int i=0; i<50; i++) {
//			System.out.print(coinFlip() + " ");
//		}
//		
		System.out.println("\n diceRoll()");
		for(int i=0; i<50; i++) {
			System.out.print(diceRollWithCoinFlip() + " ");
		}
		
		
	}
	
}
