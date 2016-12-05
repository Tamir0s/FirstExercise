package src;
import java.util.ArrayList;

public class Vertex {
	private int numID;
	private ArrayList<Edge> edges;
	private double dist;
	private int previous;
	private boolean visited;
	private int count;
	
	
	// CTORS
	public Vertex(int id, double dist) {
		this.numID = id; 
		this.dist = dist;
		previous = -1;
		visited = false;
		edges = new ArrayList<>(); 
		count=0;
	}
	public Vertex(Vertex v) {
		this.numID = v.numID; 
		this.dist = v.dist;
		this.previous = v.previous;
		this.visited = v.visited;
		this.count=v.count;
		this.edges = new ArrayList<>();
		for(int i=0;i<v.edges.size();i++){
			this.edges.add(v.edges.get(i));
		}
	}
	public Vertex(Vertex v,int num) {
		this.numID = v.numID; 
		this.edges = new ArrayList<>();
		for(int i=0;i<v.edges.size();i++){
			this.edges.add(v.edges.get(i));
		}
	}
	public String toString() {
		String s= "name is" + numID+" sons are:"; 
		for(int i=0;i<edges.size();i++)
			s+=edges.get(i).toString();
		return s;
	}
	
	/**
	 * GETTERS & SETTERS 
	  
	 */
	public int getName() {
		return numID;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(int name) {
		this.numID = name;
	}
	/**
	 * @return the edges
	 */
	public ArrayList<Edge> getEdges() {
		return edges;
	}
	/**
	 * @param edges the edges to set
	 */
	public void setEdges(ArrayList<Edge> edges) {
		this.edges = edges;
	}
	/**
	 * @return the dist
	 */
	public double getDist() {
		return dist;
	}
	/**
	 * @param dist the dist to set
	 */
	public void setDist(double dist) {
		this.dist = dist;
	}
	/**
	 * @return the previous
	 */
	public int getPrevious() {
		return previous;
	}
	/**
	 * @param previous the previous to set
	 */
	public void setPrevious(int previous) {
		this.previous = previous;
	}
	/**
	 * @return the visited
	 */
	public boolean isVisited() {
		return visited;
	}
	/**
	 * @param visited the visited to set
	 */
	public void setVisited(boolean visited) {
		this.visited = visited;
	}
	/**
	 * @return the count
	 */
	public int getCount() {
		return count;
	}
	/**
	 * @param count the count to set
	 */
	public void setCount(int count) {
		this.count = count;
	}
}

