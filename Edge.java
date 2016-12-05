package src;
public class Edge {


		private  int vert;
		private double weight;
		/**
		 * 
		 * Generic Getters & Setters
		 * 
		 */
		public int getVert() {
			return vert;
		}

		public void setVert(int vert) {
			this.vert = vert;
		}

		public double getWeight() {
			return weight;
		}

		public void setWeight(double weight) {
			this.weight = weight;
		}

		
		
		
		/**
		 * CTOR of edge 
		 * @param v
		 * @param w
		 */
		
		public Edge(int v, double w){ 
			
			vert = v; 
			weight = w; 
		}
		
		/**
		 * Set the weight of edge
		 * @param w
		 */
		/*public void setPrice(double w){  
			weight = w; 
		}*/
		public Edge(Edge edge){ 
			vert = edge.vert; 
			weight = edge.weight; 
		}

	@Override
	/**
	 * toString function
	 * @return string
	 */
		public String toString() {
			return "Edge [vert=" + vert + ", weight=" + weight + "]";
		}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
