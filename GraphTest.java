package test;


import static org.junit.Assert.*;

import org.junit.Test;

import src.Graph;

public class GraphTest {

	Graph g = new Graph("Users/edwardk/Downloads/Julia01/G0.txt");
	
	@Test
	public void testGetNumOfEdges() {

		int value = g.getNumOfEdges();
		int check = 9;
		
		assertTrue("num of Edges not eq: " , value==check);	
	}
	
	public void testSetNumOfEdges() {

		g.setNumOfEdges(10);
		int value = g.getNumOfEdges();
		int check = 10;
		
		assertTrue("num of Edges after set not eq: " , value==check);	
	}
	
	public void testGetNumOfVertexes() {

		int value = g.getNumOfVertexes();
		int check = 10;
		
		assertTrue("num of Vertexs not eq: " , value==check);	
	}
	
	public void testSetNumOfVertexs() {

		g.setNumOfVertexes(10);
		int value = g.getNumOfVertexes();
		int check = 10;
		
		assertTrue("num of Vertexs after set not eq: " , value==check);	
	}

}
