package com.dreamworks.restworks.interview.amazon;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class FolderComparison {

	public static boolean compareDir(Path dir1, Path dir2) {
	    
	    if((dir1==null && dir2!=null) || (dir1!=null && dir2==null)) {
	        return false;
	    }
	    else if(dir1==null && dir2==null) {
	    	return true;
	    }
	   
	    		
		//Stream<Path> dir1Stream = Files.walk(dir1);
		
		List<Path> dirPath1 = new ArrayList<Path>();
		
//    	try (Stream<Path> stream = Files.walk(dir1)) {
//
//    		stream.filter(p->Files.isDirectory(p)).
//    		
//    		
//    		
//    		forEach(p-> {
//    			try {
//    				replacer.replaceText(p, regexPattern, replacement, TextUtil.updateOutputPathWithSuffix(p,Consts.OUTPUT_FILE_SUFFIX));
//    				
//    				
//    			} catch (IOException e) {    				
//    				e.printStackTrace();
//    			}
//    		});
//
//    	} catch (Exception e) {
//    		throw new RuntimeException(e);
//    	}
//		
		return false;

		
		
	}
	
}
