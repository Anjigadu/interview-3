package com.dreamworks.restworks.interview.backtracking;

public class StringPathInMatrix {

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	// find str path from the matrix
	public static boolean searchString(char[][] matrix, String str) {
		int rows = matrix.length;
		int cols = matrix[0].length;
		
		boolean[][] visited = new boolean[rows][cols];
		
		int pathLength =0;
		
		for(int r=0; r< rows; r++) {
			for(int c=0; c <cols; c++) {
				
				if(hasPath(matrix, rows, cols, r, c, str, pathLength, visited)){
					return true;
				}							
			}
		}
		return false;
	}
	
	
	public static boolean hasPath(char[][] matrix, int rows, int cols, int r, int c, String str, int pathLength, boolean[][] visited){

		// end condition
		if(pathLength == str.length()){
			System.out.println("pathLen:"+ pathLength);
			
			printMatrix(matrix);
			printMatrix(visited);
			
			return true;
		}
		
		boolean hasPath = false;
		
		if(r>=0 && r < rows && c>=0 && c <cols
			&& !visited[r][c]
			&& matrix[r][c]	 == str.charAt(pathLength)) {
			
			//--------------------------------
			// visited:true && pathLength ++
			//--------------------------------
			visited[r][c] = true;  // => set this true before checking neighboring cells
			pathLength++;
			
			hasPath = hasPath(matrix, rows, cols, r-1, c, str, pathLength, visited)
					|| hasPath(matrix, rows, cols, r, c-1, str, pathLength, visited)
					|| hasPath(matrix, rows, cols, r+1, c, str, pathLength, visited)
					|| hasPath(matrix, rows, cols, r, c+1, str, pathLength, visited);

			if(!hasPath) {
				//-----------------------------
				// (Reset) visited:false 
				//-----------------------------
				visited[r][c] = false; // <== resetting after checking neighboring cells (if path not found)
			}			
		}	
		return hasPath;
	}
		
	public static void main(String[] args) {
		
		char[][] matrix = {{'a','s','c','l'},
						   {'f','a','h','d'},
						   {'t','s','o','s'},
						   {'m','l','o','c'}};
	
		//String searchStr = "fast";
		String searchStr = "school";
		boolean found = searchString(matrix, searchStr); 
		System.out.println("Found (" + searchStr + ") :" + found);
	}
	
	public static void printMatrix(char[][] matrix) {
		
		if(matrix!=null){
			for(int r =0; r < matrix.length; r++) {
				for (int c=0; c < matrix[0].length; c++) {
					System.out.print(matrix[r][c] + " ");					
				}
				System.out.println("");					
			}
		}
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
