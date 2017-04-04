package org.com.graph;
class Queue{
	private final int SIZE=20;
	private int labels[];
	int front;
	int rear;
	public Queue() {
		this.labels=new int[SIZE];
		front=0;
		rear=-1;
	}
	public void insert(int ele){
		if(rear==SIZE-1){
			rear=-1;
		}
		labels[++rear]=ele;
	}
	public int remove(){
		return labels[front++];
	}
	public boolean isEmpty(){
		if(front==rear+1||front+SIZE-1==rear){
			return true;
		}
		return false;
	}
}

public class BFS {
	private int nvert;
	private final int MAX_VERT=20;
	private int adj[][];
	private Vertex vertexList[];
	private Queue theQueue;
	public BFS(){
		this.vertexList=new Vertex[MAX_VERT];
		adj=new int[MAX_VERT][MAX_VERT];
		for(int i=0;i<MAX_VERT;i++){
			for (int j=0;j<MAX_VERT;j++){
				adj[i][j]=0;
			}
		}
		this.nvert=0;
		theQueue=new Queue();
	}
	/*
	 * Add Vertex object to vertexList array 
	 */
	public void addVertex(char label){
		vertexList[nvert++]=new Vertex(label);
	}
	/*
	 * Adding edge to adjaceny matrix
	 */
	public void addEdge(int start, int end){
		adj[start][end]=1;
		adj[end][start]=1;
	}
	/*
	 * Display the vertex label
	 */
	public void displayVertex(int v){
		System.out.println(vertexList[v].label);
	}
	/*
	 * Function for returning index of adjacentvertex
	 */
	public int adjacentIndex(int c){
		for(int i=0;i<nvert;i++){
			if (vertexList[i].wasVisited==false && adj[c][i]==1){
				return i;
		}
		}
		return -1;
		 
	}
	public void search(){
		vertexList[0].wasVisited=true;
		displayVertex(0);
		theQueue.insert(0);
		while(!theQueue.isEmpty()){
			int v=theQueue.remove();
			int c;
			while((c=adjacentIndex(v))!=-1){
				vertexList[c].wasVisited=true;
				displayVertex(c);
				theQueue.insert(c);
			}
		}
		//reset flags
				for(int i =0;i<nvert;i++){
					vertexList[i].wasVisited=false;
				}
		
	}
	public static void main(String[] args) {
		BFS bfs=new BFS();
		bfs.addVertex('A');
		bfs.addVertex('B');
		bfs.addVertex('C');
		bfs.addVertex('D');
		bfs.addVertex('E');
		bfs.addVertex('F');
		bfs.addVertex('G');
		bfs.addVertex('H');
		bfs.addVertex('I');
		bfs.addEdge(0, 1);
		bfs.addEdge(0, 2);
		bfs.addEdge(0, 3);
		bfs.addEdge(0, 4);
		bfs.addEdge(1, 5);
		bfs.addEdge(5,7 );
		bfs.addEdge(3, 6);
		bfs.addEdge(6, 8);
		bfs.search();
	}
	

}
