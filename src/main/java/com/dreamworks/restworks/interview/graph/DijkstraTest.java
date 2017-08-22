package com.dreamworks.restworks.interview.graph;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;

public class DijkstraTest {

	static int matrix[][];
	Dijkstra d;
	
	@BeforeClass
	public static void matrixSetup(){
		
		matrix = new int[][]{{0, 5, 2, 0},
			{5, 0, 3, 1},
			{2, 3, 0, 2},
			{0, 1, 2, 0}};			
		
	}

  	@Test
	public void testDijkstra() {
  		d = new Dijkstra();
  		d.dijeckstraShortestPath(matrix, 0);

  		d.printMinDist();
  		d.printShortestPathToDist(1);
  		d.printShortestPathToDist(2);
  		d.printShortestPathToDist(3);

  		// 1 is still not settled at the end because it has largest min dist
  		assertEquals(1,d.findMinDistNode());  		
	}

  	
}
