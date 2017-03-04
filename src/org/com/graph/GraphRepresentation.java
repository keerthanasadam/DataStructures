package org.com.graph;



public class GraphRepresentation {

	private int vertices;
	private int[][] adj;
	public GraphRepresentation(int vertices){
		this.vertices=vertices;
		adj=new int[vertices][vertices];
	}
	public void addEdges(int i, int j){
				adj[i][j]=1;
	}
	public static void main(String[] args) {
		GraphRepresentation gr=new GraphRepresentation(5);	
		gr.addEdges(0, 1);
		
	}
}
