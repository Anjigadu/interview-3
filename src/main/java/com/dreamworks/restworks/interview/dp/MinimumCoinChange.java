package com.dreamworks.restworks.interview.dp;

public class MinimumCoinChange {
	
	
	
	
	
	
	
	
	
	
	
	static int minCoin_rec(int[] coins, int amount) {
		
		if(amount==0) {
			return 0;
		}
		
		int result = Integer.MAX_VALUE;
		
		for(int coin : coins) {
			if(coin <= amount) {			
				int sub = minCoin_rec(coins, amount-coin);				
			
				if(sub!= result && sub +1 < result) {
					result = sub;
				}
			}
		}
		
		return result +1;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	static int minCoins_recursive(int[] coins, int amount)
	{
		// (1) base case
		// exactly divided, which mean 1 given coin is used
		if (amount == 0) return 0;

		// (2) Initialize result
		int res = Integer.MAX_VALUE;

		// Try every coin that has smaller value than V
		for (int coinValue : coins)
		{    	 
			if (coinValue <= amount)
			{
				int sub_res = minCoins_recursive(coins, amount-coinValue);

				// (3) update result
				// Check for INT_MAX to avoid overflow and see if
				// result can minimized
				if (sub_res != Integer.MAX_VALUE && sub_res + 1 < res) {
					res = sub_res + 1;
				}
			}
		}
		// (4) return result
		return res;
	}

	
	// if i >= coins[j]
	//   coinCount[i] = Min(coinCount[i], 1 + coninCount[i-coins[j])
	//                      without coins[j] ==> curMinCoinCount
	//                   vs with    coins[j] ==> 1 + coinCount[1 - coins[j]]             

	public static int minCoins_dp(int[] coins, int amount) {

		if(coins==null || coins.length ==0 || amount <1) {
			return 0;
		}

		// Array To store Total Coin Count Required for each amount
		int coinCount[] = new int[amount+1];
		int prevCoinIdx[] = new int[amount+1];

		for(int i=0; i<=amount; i++) {
			coinCount[i] = Integer.MAX_VALUE;
			prevCoinIdx[i] = -1;
		}

		// base condition
		coinCount[0] =0;

		// for each coin
		for(int i=0; i <coins.length;i++) {		
			for(int j=0; j<=amount;j++) {				
				if(coins[i] <= j) {					
					if(coinCount[j] > 1 + coinCount[j-coins[i]]) {
						coinCount[j] = 1 + coinCount[j-coins[i]];
						prevCoinIdx[j] = i;
					}
				}
			}
		}
		/*
		for(int i=0; i<=amount; i++) {
			System.out.println("i:" + i + ", count:" + coinCount[i]);
			System.out.println("lastCoinIndex:" + i + ", count:" + prevCoinIdx[i]);
		}
		 */

		printCoinCombinations(amount, coins, prevCoinIdx);

		return coinCount[amount];

	}


	public static void printCoinCombinations(int amount, int[] coins, int[] prevCoinIdx){
		if(amount >0 && coins!=null && prevCoinIdx!=null) {

			int remainder = amount;

			System.out.print("Coins:" );
			while(remainder>0) {

				// has the index for one of the coin
				int coinIdx = prevCoinIdx[remainder];
				int coinValue = coins[coinIdx];

				System.out.print(coinValue + " ");

				remainder = remainder - coinValue;
			}
		}
	}


	public static void main(String[] args) {
		int[] coins = {1,5,10,25};

		int amount = 34;

		System.out.println("Coin Count (dp):" + minCoins_dp(coins, amount) );

		//System.out.println("Coin Count (recursive):" + minimumCoinChange_recursive(coins, 27,0) );

		System.out.println("Minimum coins required is "+ minCoins_recursive(coins, amount) );

		
		System.out.println("min coins (dp2):" + minCoins_recursive2_dp(coins,amount));
		
		
	}

	static int minCoins_recursive2(int coins[], int amount)
	{	
		if(amount ==0) {
			return 0;
		}

		int minCount = Integer.MAX_VALUE; 
		
		for(int val : coins) {
			if(val <= amount) {
				
				int subMinCount = minCoins_recursive2(coins, amount - val);
				
				if(subMinCount!= Integer.MAX_VALUE && minCount > subMinCount +1 )
					minCount = minCoins_recursive2(coins, amount - val) +1;
			}
		}

		return minCount;
	}
	
	static int minCoins_recursive2_dp(int coins[], int amount)
	{
		int result[] = new int[amount+1];

		result[0] =0;
		for(int i=1; i <=amount; i++) {
			result[i] = Integer.MAX_VALUE;
		}
		                                                                                                      
		// for each value, for each coin		
		for(int v=1; v<=amount; v++) {

			for(int val : coins) {
				if(val <= v) {
					if(result[v-val]!= Integer.MAX_VALUE && result[v] > result[v-val] +1) {
						result[v] = result[v-val] +1;
					}
				}
			}
		}

		return result[amount];
	}

	static int minCoins_recursive3(int coins[], int amount){
		
		if(amount==0) {
			return 0;
		}
		
		int result = Integer.MAX_VALUE;
		for(int i=0; i< coins.length; i++) {

			if(amount <=coins[i]) {
				int sub = minCoins_recursive3(coins, amount - coins[i]);
				if(sub!= Integer.MAX_VALUE && result > sub+1) {
					result = sub+1;
				} 	
			}
		}
		
		return result;
	}
	
	
	
	public static int minCoins_dp4(int[] coins, int amount) {

		int [] prev = new int[amount+1];
		int [] minCount = new int [amount+1];
				
		for(int i=0; i<=amount; i++) {
			minCount[i] = Integer.MAX_VALUE;
		}
		minCount[0] =0;
		
		for(int i=1; i<=amount; i++) {
			for (int j=0; j< coins.length; j++) {			
				if(coins[j] <= amount) {
					if(minCount[i-coins[j]]!= Integer.MAX_VALUE && minCount[i] > minCount[i-coins[j]] +1) {
						minCount[i] = minCount[i-coins[j]] +1;
					}
				}				
			}
		}		
		
		return minCount[amount];
	}
	
	public static int minCoins_recursive5(int[] coins, int amount) {

		if(amount==0){
			return 0;
		}
		
		int min = Integer.MAX_VALUE;
		for(int value : coins) {
			if(value <=amount) {
				if(minCoins_recursive5(coins,amount) > minCoins_recursive5(coins,amount-value) +1) {
					min = minCoins_recursive5(coins,amount-value) +1;
				}
			}

		}

		
		return min;
	
	}
	
}
