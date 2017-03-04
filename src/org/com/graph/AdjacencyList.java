package org.com.graph;

import java.util.LinkedList;

public class AdjacencyList {
	private int size;
	private LinkedList<Integer>[] vertices;
	
	public AdjacencyList(int size1) {
		this.size=size1;
		vertices=new LinkedList[size];
		for(int i=0;i<size;i++){
			vertices[i]=new LinkedList<>();
		}
	}
	public void addEdge(int start, int end){
		vertices[start].add(end);
	}
	public static void main(String[] args) {
		AdjacencyList al=new AdjacencyList(5);
		
	}
}
