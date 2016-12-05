package src;
import java.io.PrintWriter;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;


public class Graph_Algo {

	/**
	 * This function finds the minimum and the maximum in the array. the minimum is the radius value
	 * and the maximum is the diameter value.
	 * @param arr1
	 * @param arr2
	 * @return a String to describe the radius and the diameter. 
	 */
	public static String minMaxPairs(double []arr, int arr2[]){
		double min, max;
		int minI=0, maxI=0;
		int len = arr.length, count = 0;
		count++;
		// it start from i=0 and i=1
		if (arr[0]<arr[1]){
			min = arr[0];
			minI=0;
			max = arr[1];
			maxI=1;
		}
		else{
			min = arr[1];
			minI=1;
			max = arr[0];
			maxI=0;
			// continues in a loop. it start from i=2 till the end of the array.
		}
		for (int i=2; i<(2*(len/2)); i=i+2){
			count++;
			if(arr[i]<arr[i+1]){
				count = count + 2;
				if(arr[i]<min) { min = arr[i]; minI=i;}
				if(arr[i+1]>max){  max = arr[i+1]; maxI=i+1;}
			}
			else{
				count = count + 2;
				if(arr[i+1]<min){ min = arr[i+1]; minI=i+1;}
				if(arr[i]>max){  max = arr[i]; maxI=i;}				
			}
		}
		// if the number of the elements is odd, we check the last element.
		if (len%2!=0){
			count++;
			if (arr[len-1]>max){
				max = arr[len-1];
				maxI=len-1;
			}
			else{
				count++;
				if (arr[len-1]<min){
					min = arr[len-1];		
					minI=len-1;
				}
			}
		}
		String s="diameter="+max+" from "+maxI+" to "+arr2[maxI]+ " radius="
				+min +" from "+minI+" to "+arr2[minI];
		return s;
	}
	
	// triangle inequality true or false
			// c < a + b
	
	public static String statisticOutput(Vertex vertexList[]){
		boolean isTie = false;
		double allMax[]=new double[vertexList.length];
		int vertexs[]=new int[vertexList.length];
		for (int i = 0; i < vertexList.length; i++) {
			Dijkstra ds = new Dijkstra(vertexList,i);
			ds.computePaths();
			if(ds.isOk)
				isTie=true;
			
			ds.printWeights();
			allMax[i]=ds.max;
			vertexs[i]=ds.maxV;
		}
		
		
		if(isTie){
		return (" Tie "+minMaxPairs(allMax,vertexs));}
		return (" !Tie "+minMaxPairs(allMax,vertexs));
	}
	
	/**
	 * 
	 * @param s
	 * @param vertexList
	 * @return the result of the dijakstra as string
	 */
	public static String seperator(String s, Vertex vertexList[] ){
		String [] arr=s.split(" ");
		String result;
		int firstV=Integer.parseInt(arr[0]);
		int secondV=Integer.parseInt(arr[1]);
		int black_list[]=new int[arr.length-2];
		if(arr.length-2!=0){
			for(int i=2;i<arr.length;i++){
				black_list[i-2]=Integer.parseInt(arr[i]);
				
				
			}
			Dijkstra ds = new Dijkstra(vertexList,firstV);
			result=ds.blacklist(black_list, firstV,secondV,vertexList);
			

		}
		else{
			Dijkstra ds = new Dijkstra(vertexList,firstV); 
			ds.computePaths();
			result=ds.printPaths(secondV);
		}
		return result;
	}

	// this main function create a txt file with the result of the graph and the test files.
	public static void main(String[] args) {
		
		long startTime = System.currentTimeMillis();
		String address="/Users/edwardk/Downloads/Ex1/G0.txt"; //here we add the address of the graph file
		Graph gph= new Graph(address);
		Vertex vertexList[]=gph.getListOfVertexes();
		read_From_Querys rfq =new read_From_Querys("/Users/edwardk/Downloads/Ex1/test1.txt"); //here we add the address of the test file
		Path currentRelativePath = Paths.get("");
		String s = currentRelativePath.toAbsolutePath().toString();
		System.out.println("creating a result file into "+s);
		try{
			PrintWriter writer = new PrintWriter("Result.txt", "UTF-8");
			for(int i=0;i<rfq.getNumOfQueries();i++){
				String res=seperator(rfq.getListOfQueries()[i], vertexList);
				writer.println(res);
			}
		
		
			String info="Graph: |V|="+gph.getNumOfVertexes()+" |E|="+gph.getNumOfEdges()
			+statisticOutput(vertexList);
			long endTime   = System.currentTimeMillis();
			long totalTime = endTime - startTime;
			writer.println(info+" ,"+totalTime+"ms");
			writer.close();
		}catch (Exception e) {
			System.out.println("error");
		}				
	}
}