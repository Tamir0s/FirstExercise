import static org.junit.Assert.*;

import java.util.Iterator;

/**
 * Class that performs tests.
 * 
 * @author EdwardK TamirO BatelD
 */
public class Test {
	final static double EPSILON = 0.0000001;

	@org.junit.Test
	//Testing function we added.
	public void BLIn() {

		OurIn file = new OurIn("tinyEWD.txt");
		Graph G = new Graph(file);
		int NumOfBP = 2 ;
		int []BL = new int[NumOfBP];

		BL[0] = 2 ;
		BL[1] = 7 ;
		G.BLIn(BL, NumOfBP);
		for (int i = 0; i < BL.length; i++) {
			Iterator<DirectedEdge> It = G.adj(BL[i]).iterator();
			while(It.hasNext()){
				DirectedEdge e = It.next();
				assertTrue(e.weight() == Double.MAX_VALUE);
			}
		}
	}
	//Testing function we added.
	@org.junit.Test
	public void BLOut() {

		OurIn file = new OurIn("tinyEWD.txt");
		Graph G = new Graph(file);
		int NumOfBP = 2 ;
		int []BL = new int[NumOfBP];

		BL[0] = 2 ;
		BL[1] = 7 ;
		G.BLIn(BL, NumOfBP);

		G.BLOut();
		for (int i = 0; i < BL.length; i++) {
			Iterator<DirectedEdge> It = G.adj(BL[i]).iterator();
			while(It.hasNext()){
				DirectedEdge e = It.next();
				assertTrue(e.weight() != Double.MAX_VALUE);
			}
		}
	}

	@org.junit.Test
	//Test of tinyEWD with test1.
	public void Test_tinyEWD_test1() {

		OurIn Solution_file = new OurIn("Solution_test1.txt_tinyEWD.txt_1458310266177_.txt");
		String TestFile = "test1.txt";
		String AnsFile = "ans.txt";
		String GraphFile = "tinyEWD.txt";

		TestAlgo new_test = new TestAlgo(TestFile,GraphFile,AnsFile);
		new_test.RunFile();

		OurIn ToTest = new OurIn(AnsFile);

		assertTrue(CompareFiles(ToTest , Solution_file));
	}

	@org.junit.Test
	//Test of mediumEWD with test2.
	public void Test_mediumEWD_test2() {

		OurIn Solution_file = new OurIn("Solution_test2.txt_mediumEWD.txt_1458309646602_.txt");
		String TestFile = "test2.txt";
		String AnsFile = "ans.txt";
		String GraphFile = "mediumEWD.txt";

		TestAlgo new_test = new TestAlgo(TestFile,GraphFile,AnsFile);
		new_test.RunFile();

		OurIn ToTest = new OurIn(AnsFile);

		assertTrue(CompareFiles(ToTest , Solution_file));
	}

	@org.junit.Test
	//Test of mediumEWD with test3.
	public void Test_mediumEWD_test3() {

		OurIn Solution_file = new OurIn("Solution_test3.txt_mediumEWD.txt_1458310286550_.txt");
		String TestFile = "test3.txt";
		String AnsFile = "ans.txt";
		String GraphFile = "mediumEWD.txt";

		TestAlgo new_test = new TestAlgo(TestFile,GraphFile,AnsFile);
		new_test.RunFile();

		OurIn ToTest = new OurIn(AnsFile);

		assertTrue(CompareFiles(ToTest , Solution_file));
	}

	

	@org.junit.Test
	//Test of tinyEWD2 with test4.
	public void Test_tinyEWD2_test4() {

		OurIn Solution_file = new OurIn("Solution_test4.txt_tinyEWD2.txt");
		String TestFile = "test4.txt";
		String AnsFile = "ans.txt";
		String GraphFile = "tinyEWD2.txt";

		TestAlgo new_test = new TestAlgo(TestFile,GraphFile,AnsFile);
		new_test.RunFile();

		OurIn ToTest = new OurIn(AnsFile);

		assertTrue(CompareFiles(ToTest , Solution_file));
	}

	@org.junit.Test
	//Test of tinyEWD3 with test5.
	public void Test_tinyEWD3_test5() {

		OurIn Solution_file = new OurIn("Solution_test5.txt_tinyEWD3.txt");
		String TestFile = "test5.txt";
		String AnsFile = "ans.txt";
		String GraphFile = "tinyEWD3.txt";

		TestAlgo new_test = new TestAlgo(TestFile,GraphFile,AnsFile);
		new_test.RunFile();

		OurIn ToTest = new OurIn(AnsFile);

		assertTrue(CompareFiles(ToTest , Solution_file));
	}
	//******************Saed tests.****************************************
	@org.junit.Test
	//Test of mediumEWD with test6.
	public void Test_mediumEWD_test6() {

		String TestFile = "test6.txt";
		String AnsFile = "AnswerFile1.txt";
		String GraphFile = "mediumEWD.txt";

		TestAlgo new_test = new TestAlgo(TestFile,GraphFile,AnsFile);
		new_test.RunFile();
	}
	
	
	//******************saed tests.****************************************
	@org.junit.Test
	//Triangle inequality: 6 -> 0 + 6 -> 2 >= 0 -> 2
	public void TriangleInequality1() {

		String GraphFile = "tinyEWD.txt";
		OurIn test_file = new OurIn(GraphFile);

		Graph G = new Graph(test_file);
		int First_vertex = Integer.parseInt("0");
		int Second_vertex = Integer.parseInt("6");

		// compute shortest paths
		Graph_algo sp1 = new Graph_algo(G, First_vertex);
		Graph_algo sp2 = new Graph_algo(G, Second_vertex);

		assertTrue(CompareDoubles(sp1.distTo(2) + sp2.distTo(2),  sp2.distTo(0)));
	}	

	@org.junit.Test
	//Triangle inequality: 5 -> 4 + 5 -> 7 >= 4 -> 7
	public void TriangleInequality2() {

		String GraphFile = "tinyEWD.txt";
		OurIn test_file = new OurIn(GraphFile);

		Graph G = new Graph(test_file);
		int First_vertex = Integer.parseInt("5");
		int Second_vertex = Integer.parseInt("4");

		// compute shortest paths
		Graph_algo sp1 = new Graph_algo(G, First_vertex);
		Graph_algo sp2 = new Graph_algo(G, Second_vertex);

		assertTrue(CompareDoubles(sp1.distTo(4) + sp1.distTo(7),sp2.distTo(7)));
	}

	/**
	 * The function compares two double values.
	 * @param d1 - first double.
	 * @param d2 - second double.
	 * @return - value 0 if d1 is equal to d2,
	 * a value less than 0 if d1 is less than d2
	 */
	public static boolean CompareDoubles(double d1 , double d2){

		int answer = Double.compare(d1, d2);

		if(answer < 0) {
			return false;
		}
		return true;
	}

	/**
	 * Function that compares two files.
	 * @param First - first file.
	 * @param Second - second file.
	 * @return - true if they are equal,
	 * otherwise return false.
	 */
	public static boolean CompareFiles(OurIn First , OurIn Second){

		if(First.readLine().compareTo(Integer.toString(Second.readInt())) != 0){
			return false;
		}

		Second.readLine(); // read "regenerated by a simple SE1_EX1 solution".

		while((First.hasNextLine()) && (Second.hasNextLine())){
			if(First.readLine().compareTo(Second.readLine()) != 0){
				return false;
			}
		}
		return true;
	}
}