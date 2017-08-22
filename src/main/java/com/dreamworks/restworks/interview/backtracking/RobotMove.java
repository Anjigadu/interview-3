package com.dreamworks.restworks.interview.backtracking;

/*
 * A robot starts at cell (0,0) of grid with m x n
 * - can move up, down, left, right 
 * - cannot enter cells where the digit sum of the row index and column index are greater than given k
 *   e.g., k=18, can  enter (35,37) because 3+5+3+7 = 18
 *             cannot enter (35,38) because 3+5+3+8 = 19
 *
 * - (Q) How many cells can the robot reach
 */

public class RobotMove {
		
	
	public static int getVisitableCellCount(int rows, int cols, int k) {
	
		boolean[][] visited = new boolean[rows][cols];
		
		int count = canVisit(k,rows, cols,0,0,visited);		
		
		printMatrix(visited);
		return count;
	}

	public static int canVisit(int k, int rows, int cols, int row, int col, boolean[][] visited) {

		int count =0;
		
		if(row >= 0 && row < rows && col >=0 && col < cols 
				&& !visited[row][col]){  // ==> to avoid duplicated move!
			
			if(isVisitiableCell(row, col, k)) {
				visited[row][col]=true;
				
				// can add data from all direction 
				// because if the cell is visited, it will return 0 anyway!
				
				count = 1 + canVisit(k,rows,cols,row-1,col,visited)
						+ canVisit(k,rows,cols,row+1,col,visited)
						+ canVisit(k,rows,cols,row,col-1,visited)
						+ canVisit(k,rows,cols,row,col+1,visited);								
			}			
		}		
		
		return count;
    }

	public static boolean isVisitiableCell(int row, int col, int k) {

		System.out.println("(" + row + "," + col + ") and k: " + k);
		
		String rowStr = Integer.toString(row);
		String colStr = Integer.toString(col);

		int sum=0;
		for(int i=0; i< rowStr.length(); i++) {
			sum+= Integer.parseInt(Character.toString(rowStr.charAt(i)));
		}

		for(int i=0; i< colStr.length(); i++) {
			sum+= Integer.parseInt(Character.toString(colStr.charAt(i)));
		}
		
		return sum <= k;
	}

	public static void main(String[] args) {		
		System.out.println("visitable cell count (4,4), k=6 :" + getVisitableCellCount(4,4,4));			
	}
	
	public static void printMatrix(boolean[][] matrix) {
		
		if(matrix!=null){
			for(int r =0; r < matrix.length; r++) {
				for (int c=0; c < matrix[0].length; c++) {
					if(matrix[r][c]) {
						System.out.print("1 ");					
					}
					else {
						System.out.print("0 ");											
					}											
				}
				System.out.println("");					
			}
		}
	}
}



