package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;



import org.junit.Test;

import src.read_From_Querys;


public class read_From_QuerysTest {

	@Test
	public void testGetNumOfQueries() {
		String fileName = "/Users/edwardk/Downloads/Julia01/test1.txt";
		read_From_Querys rfq = new read_From_Querys(fileName);
		int value = rfq.getNumOfQueries();
		int check = 4;
		
		assertTrue("not equal", value == check);
		
	}
	
	@Test
	public void testGetListOfQueries() {
		String fileName = "/Users/edwardk/Downloads/Julia01/test1.txt";
		read_From_Querys rfq = new read_From_Querys(fileName);
		String[] value = rfq.getListOfQueries();
		
		assertEquals(value[0], "4 5 1 0");
		assertEquals(value[1], "2 3 0");
		assertEquals(value[2], "2 3 1 4");
		assertEquals(value[3], "2 3 2 0 1");
		
	}
	
	

}
