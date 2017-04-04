package org.com.graph;
class Stack{
	private final int SIZE=20;
	int labels[];
	int top;
	public Stack(){
		labels=new int[SIZE];
		top=-1;
	}
	public void push(int c){
		labels[++top]=c;
	}
	public int pop(){
		return labels[top--];
	}
	public int peek(){
		return labels[top];
	}
	boolean isEmpty(){
		if(top==-1){
			return true;
		}
		return false;
	}
} 
class Vertex{
	char label;
	boolean wasVisited;
	public Vertex(char c) {
		label=c;
		wasVisited=false;
	}
}

public class DFS {
	private int nvert;
	private final int MAX_VERT=20;
	private int adj[][];
	private Vertex vertexList[];
	private Stack theStack;
	public DFS(){
		this.vertexList=new Vertex[MAX_VERT];
		adj=new int[MAX_VERT][MAX_VERT];
		for(int i=0;i<MAX_VERT;i++){
			for (int j=0;j<MAX_VERT;j++){
				adj[i][j]=0;
			}
		}
		this.nvert=0;
		theStack=new Stack();
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
	/*
	 * Rule 1: If exists unvisited adjacent vertex mark it,display and push into stack
	 * Rule 2: If rule 1 not possible , if possible pop the stack
	 * Rule 3: if rule 1 and rule 2 not possible then you are done.
	 * 
	 */
	public void search(){
		//start the 0 element
		vertexList[0].wasVisited=true;
		displayVertex(0);
		theStack.push(0);
		while(!theStack.isEmpty()){
			int v= adjacentIndex(theStack.peek());
			if(v==-1){
				//rule 2
				theStack.pop();	
			}
			else{
				
				//mark as visited
				vertexList[v].wasVisited=true;
				
				//display
				displayVertex(v);
				//push into stack
				theStack.push(v);
			}
		}
		//reset flags
		for(int i =0;i<nvert;i++){
			vertexList[i].wasVisited=false;
		}
		
	}
	public static void main(String[] args) {
		DFS dfs=new DFS();
		dfs.addVertex('A');
		dfs.addVertex('B');
		dfs.addVertex('C');
		dfs.addVertex('D');
		dfs.addVertex('E');
		dfs.addVertex('F');
		dfs.addVertex('G');
		dfs.addVertex('H');
		dfs.addVertex('I');
		dfs.addEdge(0, 1);
		dfs.addEdge(0, 2);
		dfs.addEdge(0, 3);
		dfs.addEdge(0, 4);
		dfs.addEdge(1, 5);
		dfs.addEdge(5,7 );
		dfs.addEdge(3, 6);
		dfs.addEdge(6, 8);
		dfs.search();
		
	}

}
