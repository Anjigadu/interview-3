package com.dreamworks.restworks.interview.dp;



// http://algorithms.tutorialhorizon.com/find-longest-snake-sequence-in-a-given-matrix/
/**
 * 
 * Objec­tive: Given two dimen­sional matrix, write an algo­rithm to find out the snake sequence
 * which has the max­i­mum length. You need to return the one with the max­i­mum length. 
 * Travel is allowed only in two direc­tions, either go right OR go down.
 *
 * What is snake sequence: Snake sequence can be made if num­ber in adja­cent right cell 
 * or num­ber in the adja­cent down cell is either +1 or –1 from the num­ber in the cur­rent cell.	
 * 
 */

public class LongestSnakeSeq {

	public static int getMaxSeq_rec(int [][] matrix){

		int rows = matrix.length;
		int cols = matrix[0].length;
				
		int result = Integer.MIN_VALUE;

		for(int i=0; i < rows; i++) {
			for(int j=0; j <cols; j++) {
		
				int sub = getMaxSeq(matrix, rows, cols, i,j);
				
				if(sub > result) {
					result = sub;
				}
			}
		}
		return result;		
	}
	
	// to make recursive works, internal recursive call must make a call to previous step
	
	public static int getMaxSeq(int [][] matrix, int rows, int cols, int row, int col){
		
		int left =1;
		
		if(row-1 >=0 && Math.abs(matrix[row-1][col] - matrix[row][col]) ==1) {					
			left = getMaxSeq(matrix, rows, cols, row-1, col) +1;
		}
		
		int upper=1;
		
		if(col-1 >=0 && Math.abs(matrix[row][col-1] - matrix[row][col]) ==1) {
		   upper = getMaxSeq(matrix, rows, cols, row, col-1) +1;
		}
		
		return Math.max(left,upper);
	}
	
		
	
	public int getMaxSequence(int [][] matrix){

		int rows = matrix.length;
		int cols = matrix[0].length;
		

		// (1) create result matrix
		int [][] result = new int [rows][cols];

		// (2) initialize result matrix
		//if no sequence is found then every cell itself is a sequence of length 1
		for (int i = 0; i <rows ; i++) {
			for (int j = 0; j <cols ; j++) {
				result[i][j] =1;
			}
		}
		
		// (2-2) initialize result 
		int maxLenth =1;
		int maxRow = 0;
		int maxCol = 0;


		for (int i = 0; i <rows ; i++) {
			for (int j = 0; j <cols ; j++) {
				if(i!=0 || j!=0){					
					//check from top
					if(j>0 && Math.abs(matrix[i][j]-matrix[i][j-1])==1){
						result[i][j] = Math.max(result[i][j],
								result[i][j-1]+1);
						if(maxLenth<result[i][j]){
							maxLenth = result[i][j];
							maxRow = i;
							maxCol = j;
						}
					}
					
					//check from left
					if(i>0 && Math.abs(matrix[i][j]-matrix[i-1][j])==1){
						result[i][j] = Math.max(result[i][j],
								result[i-1][j]+1);
						if(maxLenth<result[i][j]){
							maxLenth = result[i][j];
							maxRow = i;
							maxCol = j;
						}
					}					
				}
			}
		}

		//Now we will check the max entry in the result[][].
		System.out.println("Max Snake Sequence : " + maxLenth);
		printPath(matrix, result, maxLenth, maxRow, maxCol);
		return 0;
	}

	public void printPath(int [][] matrix, int [][] result, int maxLength, int maxRow, int maxCol){
        while(maxLength>=1){
            System.out.print(" - " + matrix[maxRow][maxCol]);
            
            if(maxRow>0 && Math.abs(result[maxRow-1][maxCol]-result[maxRow][maxCol])==1){
                maxRow--;
            }else if(maxCol>0 && Math.abs(result[maxRow][maxCol-1]-result[maxRow][maxCol])==1){
                maxCol--;
            }
            maxLength--;
        }
    }
	
	public static void main(String[] args) {
		int arrA [][] = {{1, 2, 1, 2},
                         {7, 7, 2, 5},
                         {6, 4, 3, 4},
                         {1, 2, 2, 5}};
		
		LongestSnakeSeq snakeSequence = new LongestSnakeSeq();
		snakeSequence.getMaxSequence(arrA);
		
		System.out.println("\ntest2");
		snakeSequence.getMaxSequence2(arrA);
		
		
		System.out.println("\nrecursive test");
		System.out.println("Count:" + getMaxSeq_rec(arrA));
		 

	}
	

	public int getMaxSequence2(int [][] matrix){

		int rows = matrix.length;
		int cols = matrix[0].length;
		
		//create result matrix
		int [][] result = new int [rows][cols];

		// base case (initialization)
		// - if no sequence is found then every cell itself is a sequence of length 1
		for (int i = 0; i <rows ; i++) {
			for (int j = 0; j <cols ; j++) {
				result[i][j] =1;
			}
		}

		for (int i = 0; i <rows ; i++) {
			for (int j = 0; j <cols ; j++) {
				if(i!=0 || j!=0){					
					//check from top
					if(j>0 && Math.abs(matrix[i][j]-matrix[i][j-1])==1){
						result[i][j] = Math.max(result[i][j],
								result[i][j-1]+1);					
					}
					
					//check from left
					if(i>0 && Math.abs(matrix[i][j]-matrix[i-1][j])==1){
						result[i][j] = Math.max(result[i][j],
								result[i-1][j]+1);
					}					
				}
			}
		}

		
		printPath(matrix, result);
		return 0;
	}
	
	public void printPath(int [][] matrix, int [][] result){
		
		int rows = matrix.length;
		int cols = matrix[0].length;
			
		int maxLength =1;
		int maxRow = 0;
		int maxCol = 0;

		// find out maxLength and (maxRow, maxCol)
		for (int i = 0; i <rows ; i++) {
			for (int j = 0; j <cols ; j++) {

				if(result[i][j] > maxLength) {
					maxLength = result[i][j];
					maxRow = i;
					maxCol = j;
				}
			}
		}
		
        while(maxLength>=1){
            System.out.print(" - " + matrix[maxRow][maxCol]);
            if(maxRow>0 && Math.abs(result[maxRow-1][maxCol]-result[maxRow][maxCol])==1){
                maxRow--;
            }else if(maxCol>0 && Math.abs(result[maxRow][maxCol-1]-result[maxRow][maxCol])==1){
                maxCol--;
            }
            maxLength--;
        }
    }
	
	
	
	
}
