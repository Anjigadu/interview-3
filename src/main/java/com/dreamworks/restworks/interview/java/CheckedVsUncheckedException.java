package com.dreamworks.restworks.interview.java;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class CheckedVsUncheckedException {

	
	public static void main(String[] args) {
		
		uncheckedException();
	}
	
	
	// FileNotFoundException is a subclass of IOException. 
	// So we can just specify IOCException in throws
	public static void checkedExceptionExample() throws FileNotFoundException,IOException
	{		
//		try {

			//-------------------------------------------------------------
			// * CheckedException : Must Handle (catch) or Throw exception
			// throws FileNotFoundException 
			//-------------------------------------------------------------
			FileReader file = new FileReader("C:\\test\\file.txt");
			
			BufferedReader fileInput = new BufferedReader(file);

			for(int counter = 0; counter <3; counter++) {
				System.out.println(fileInput.read());
			}
			
			fileInput.close();
			
//		} catch (FileNotFoundException e) {
//			e.printStackTrace();
//		}
		
	}
	
	public static void uncheckedException(){
		int i=0;
		int j=10;
		
		int k = j/i;
		// Returns 
		// Exception in thread "main" java.lang.ArithmeticException: / by zero
	
	}
	
	
}
