package src;

import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;

public class Graph {


	private Vertex [] ListOfVertexes;
	private int NumOfEdges;
	private int NumOfVertexes;

	//@SuppressWarnings("deprecation")
	public Graph(String address){

		File file = new File(address);
		FileInputStream fis = null;
		BufferedInputStream bis = null;
		DataInputStream dis = null;
		

		try {
			fis = new FileInputStream(file);

			// Here BufferedInputStream is added for fast reading.
			bis = new BufferedInputStream(fis);
			dis = new DataInputStream(bis);


			if(dis.available() != 0){
				
				// Read the number of vertices from the file
				String line;
				line=dis.readLine();
				NumOfVertexes=Integer.parseInt(line);
				
				// Read the number of edges from the file
				line=dis.readLine();
				NumOfEdges=Integer.parseInt(line);
				
				// create a list of the vertices 
				ListOfVertexes=new Vertex[NumOfVertexes];
				
				for(int i=0;i<NumOfVertexes;i++){
					ListOfVertexes[i]= new Vertex(i, Double.MAX_VALUE);	
					
				}

				//System.out.println(NumOfEdges);
				String[] arr=new String[3];

				// dis.available() returns 0 if the file does not have more lines.
				for(int i=0;i<NumOfEdges;i++) {
				//	System.out.println(i);
					
					line=dis.readLine();
					arr=line.split(" ");
					ListOfVertexes[Integer.parseInt(arr[0])].getEdges().add(new Edge(Integer.parseInt(arr[1]),Double.parseDouble(arr[2])));
					ListOfVertexes[Integer.parseInt(arr[1])].getEdges().add(new Edge(Integer.parseInt(arr[0]),Double.parseDouble(arr[2])));




				}
			}
			
			// dispose all the resources after using them.
			fis.close();
			bis.close();
			dis.close();

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}



	public Vertex[] getListOfVertexes() {
		return ListOfVertexes;
	}



	public int getNumOfEdges() {
		return NumOfEdges;
	}



	public void setNumOfEdges(int numOfEdges) {
		NumOfEdges = numOfEdges;
	}



	public int getNumOfVertexes() {
		return NumOfVertexes;
	}



	public void setNumOfVertexes(int numOfVertexes) {
		NumOfVertexes = numOfVertexes;
	}



	public static void main(String args[]){

		//gets,sets...
		Graph test = new Graph("/Users/edwardk/Downloads/Julia01/G0.txt");
		
		System.out.println("V = " + test.getNumOfVertexes());

		System.out.println("E = " + test.getNumOfEdges());
		
		for (int i = 0; i < test.getNumOfVertexes(); i++) {
			System.out.println(test.ListOfVertexes[i].toString());
		}

		System.out.println("test");

	}
}
