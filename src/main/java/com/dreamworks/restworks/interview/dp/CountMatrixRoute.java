package com.dreamworks.restworks.interview.dp;

public class CountMatrixRoute {

	// numeber of path : Starting from (0,0) to (m,n) when it can move to right or down only
	
	
	int countMR(int r, int c) {
		
		if(r==1||c==1) {
			return 1;
		}		
		return countMR(r-1,c) + countMR(r,c-1);	
	}
	
	
	
	public static int countMatrixRoute_dynamicProgramming(int[][] matrix) {
		
		if(matrix==null) {
			return -1;
		}
		
		int rowCount = matrix.length;
		int columnCount = matrix[0].length;

		int[][] result = new int[rowCount][columnCount];

		//-----------------------------------------
		// base cases
		//-----------------------------------------
		result[0][0] = 1;

		for(int i=0; i<rowCount; i++) {
			result[i][0] = 1;
		}

		for(int i=0; i<columnCount; i++) {
			result[0][i] = 1;
		}
		//-----------------------------------------

		// Update result[][]		
		for(int i=1;i<rowCount; i++) {
			for(int j=1; j<columnCount; j++) {	
				result[i][j] = result[i-1][j] + result[i][j-1];			
			}			
		}
		
		
		// print result[][]
		for(int i=0;i<rowCount; i++) {
			for(int j=0; j<columnCount; j++) {			
				System.out.print(result[i][j] + " ");		
			}			
			System.out.print("\n");					
		}
		return result[rowCount-1][columnCount-1];	
	}
	
	
	
	public static int countMatrixRoute_recursive(int row, int column) {
			
		// base case
		// allow to move only to the right or down
		// ==> so there is only 1 path to get to any 1st row cell (and any 1st column cell) 
		if(row == 1 || column == 1) {		
			return 1;
		}
		return countMatrixRoute_recursive(row-1, column) + countMatrixRoute_recursive(row, column-1);
	}
	
	
	public static void main(String[] args) {
		
		int[][] testMatrix = {{1,2,3},{4,5,6},{7,8,9},{10,11,12}};
		
		// call with matrix, and start (top left) location
		int result = countMatrixRoute_recursive(3,4);		
		System.out.println("Path count (recursive):" + result);
		
		result = countMatrixRoute_dynamicProgramming(testMatrix);		
		System.out.println("Path count (dynamic programming):" + result);
	}
	
	
	
	
}
