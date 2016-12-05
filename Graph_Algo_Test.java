package test;


import static org.junit.Assert.*;

import org.junit.Test;

//import com.sun.prism.impl.VertexBuffe

import src.Graph_Algo;;




public class Graph_Algo_Test {

	@Test
	public void testMinMaxPairs() {
		double[] a = {1,2,3,4,5};
		int[] b = {0,0,0,0,0};
		String value = Graph_Algo.minMaxPairs(a, b);
		String  check = "diameter=5.0from4to0radius=1.0from0to0";
		assertEquals(value, check);
	}
	
	@Test
	public void testStatisticOutput() {
		src.Vertex[] vertexList = new src.Vertex[3];
		vertexList[0] = new src.Vertex(0, Double.POSITIVE_INFINITY);
		vertexList[1] = new src.Vertex(1, Double.POSITIVE_INFINITY);
		vertexList[2] = new src.Vertex(2, Double.POSITIVE_INFINITY);
		String value = Graph_Algo.statisticOutput(vertexList);
		String check =  " Tie diameter=-1.0 from 0 to -1 radius=-1 from 1 to -1";
		assertEquals(value,check);
	}
	
	@Test
	public void testSeperator() {
		src.Vertex[] vertexList = new src.Vertex[3];
		vertexList[0] = new src.Vertex(0, Double.POSITIVE_INFINITY);
		vertexList[1] = new src.Vertex(1, Double.POSITIVE_INFINITY);
		vertexList[2] = new src.Vertex(2, Double.POSITIVE_INFINITY);
		String s = "0 2";
		String value = Graph_Algo.seperator(s, vertexList);
		String check = "could not find a way 2 from 0";
		assertEquals(value, check);
	}
	
	

}
