package src;


public class HeapMin {

	double positiveInfinity = Double.POSITIVE_INFINITY;
	final int InitSize = 10;
	private Vertex arr[];
	private int Size;
	
	public HeapMin(Vertex arr[]){
		Size = arr.length;
		arr = new Vertex[Size];
		for (int i=0; i<Size; i++){
			arr[i]=arr[i];
		}
	}
	
	public HeapMin(){
		arr = new Vertex[0];
	}
	
	/** return the size*/
	
	public int getSize(){
		return Size;
		}
	
	/** returns the heap array */
	
	public Vertex[] getA(){
		return arr;
		}
	

	/** returns the parent*/
	
	private  int parent(int i){
		return (i-1)/2;
		}

	/** return the left child */
	
	private  int leftChild(int i){
		return 2*i+1;
		}
	
	/**  return the right child */
	
	private  int rightChild(int i){
		return 2*i+2;
		}
	
	/** return the first value */
	
	public Vertex heapMinimum(){
		return arr[0];
		}
	
	/** return true if the heap is empty */
	
	public boolean isEmpty(){
		boolean ans = false;
		if (Size == 0) return true;
		return false;
	}
	
	/** the minHeapfy function maintains the min-heap property */
	private void minHeapify(int v, int heapSize){
		int smallest;
		int left = leftChild(v);
		int right = rightChild(v);
		if (left<heapSize && arr[left].getDist()<arr[v].getDist()){
			smallest = left;
		}
		else{
			smallest = v;
		}
		if (right<heapSize && arr[right].getDist()<arr[smallest].getDist()){
			smallest = right;
		}
		if (smallest!=v){
			exchange(v, smallest);
			minHeapify(smallest, heapSize);
		}		
	}
	
	/** the heap minimum element extraction */
	
	public Vertex heapExtractMin(){
		double min = positiveInfinity; 
		Vertex v=null;
		if (!isEmpty()){
			v=new Vertex(arr[0]);
			min = v.getDist();
			arr[0]=arr[Size-1];
			Size = Size-1;
			minHeapify(0, Size);
		}
		return v;
	}
	
	/** the heapDecreaseKey implements the Decrease Key operation*/
	
	public void heapDecreaseKey(Vertex node){
		int v = node.getName();
		int i = 0;
		while (i<Size && v!=arr[i].getName()) i++;
		if (node.getDist() <arr[i].getDist()){
			arr[i] = node;
			while (i>0 && arr[parent(i)].getDist()>arr[i].getDist()){
				exchange(i, parent(i));
				i = parent(i);
			}
		}
	}
	
	/** minHeapInsert function implements the Insert-Key operation*/
	
	public void minHeapInsert(Vertex node){
		resize(1);
		arr[Size-1] = new Vertex(node);
		arr[Size-1].setDist(positiveInfinity);
		heapDecreaseKey(node);
	}
	
	/** increment an array*/
	
	private void resize(int increment){
		Vertex temp[] = new Vertex[Size+increment];
		for (int i=0; i<Size; i++){
			temp[i]=arr[i];
		}
		arr = temp;
		Size = Size+increment;
	}	
	
	/** exchange two array elements*/
	
	private void exchange(int i, int j){
		Vertex t = arr[i];
		arr[i] = arr[j];
		arr[j] = t;
	}
	
	/** print a heap array */
	public void print(){
		for (int i=0; i<Size; i++){
			System.out.print(arr[i]+"; ");
		}
		System.out.println();
	}
	
	public boolean contains(int name){
		boolean ans = false;
		for (int i=0; !ans && i<Size; i++){
			if (arr[i].getName() == name) ans = true;
		}
		return ans;
	}
	
	
}
	