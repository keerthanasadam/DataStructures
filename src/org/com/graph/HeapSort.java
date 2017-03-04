package org.com.graph;

public class HeapSort {
	public Movie extractMax(Movie[] heap){
		int currentSize=heap.length;
		if(heap.length>0){
			Movie root=heap[0];
			heap[0]=heap[--currentSize];
			trickleDown(heap,0);
			return root;
		}
		return null;
	}
	public void trickleDown(Movie[] heap,int index){
		int currentSize=heap.length;
		int largestChild;
		Movie top=heap[index];
		while(index<currentSize/2){
		int leftIndex=2*index+1;
		int rightIndex=leftIndex+1;
			if(rightIndex<currentSize && heap[leftIndex].getRating()<heap[rightIndex].getRating()){
				largestChild=rightIndex;
			}
			else{
				 largestChild=leftIndex;
			}
			if(top.getRating()<heap[largestChild].getRating()){
			heap[index]=heap[largestChild];
			index=largestChild;				
			}
			else
				break;
		}
		heap[index]=top;
	}
}
