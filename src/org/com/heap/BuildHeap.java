package org.com.heap;

class Node{
	private int value;
	public Node(int value){
		this.value=value;
	}
	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}
}
public class BuildHeap {
	private int currentSize;
	private Node[] heapArray;
	private int maxSize;
	
	public BuildHeap(){
		
	}
	public BuildHeap(int max){
		currentSize=0;
		heapArray=new Node[max];
		maxSize=max;
	}
	//inserting elemets
	public boolean insert(int value){
		if(currentSize>=maxSize){
			return false;
		}
		Node newNode=new Node(value);
		heapArray[currentSize]=newNode;
		trickleUp(currentSize++);
		return true;
	}
	//heapify by moving up
	public void trickleUp(int index){
		Node bottom=heapArray[index];
		int parent=(index-1)/2;
		while(index>0 && heapArray[parent].getValue()<bottom.getValue()){
			heapArray[index]=heapArray[parent];
			index=parent;
			parent=(parent-1)/2;
		}
		heapArray[index]=bottom;
		}
	//Deleting max elements
	public Node extractMax(){
		if(heapArray.length>0){
			Node root=heapArray[0];
			heapArray[0]=heapArray[--currentSize];
			trickleDown(0);
			return root;
		}
		return null;
	}
	public void delete(int index, int ele){
		heapArray[index].setValue((int)Double.POSITIVE_INFINITY);
		Node root=heapArray[0];
		heapArray[0]=heapArray[index];
		heapArray[0]=heapArray[currentSize--];
		heapArray[index]=root;
		trickleDown(0);
	}
	//heapify while moving down
	public void trickleDown(int index){
		int largestChild;
		Node top=heapArray[index];
		while(index<currentSize/2){
		int leftIndex=2*index+1;
		int rightIndex=leftIndex+1;
			if(heapArray[leftIndex].getValue()>heapArray[rightIndex].getValue()){
				largestChild=leftIndex;
			}
			else{
				 largestChild=rightIndex;
			}
			if(top.getValue()<heapArray[largestChild].getValue()){
			heapArray[index]=heapArray[largestChild];
			index=largestChild;				
			}
			else
				break;
		}
		heapArray[index]=top;	
	}
	public boolean changePrority(int index, int newValue){
		if(index<0 || index>currentSize){
			return false;
		}
		else{
			int oldValue=heapArray[index].getValue();
			heapArray[index].setValue(newValue);
			if(oldValue>newValue){
				trickleUp(index);
			}
			else{
				trickleDown(index);
			}
			return true;
		}
	}

	public static void main(String[] args) {
		BuildHeap heap=new BuildHeap(10);
		
		heap.insert(70);
		heap.insert(50);
		heap.insert(20);
		heap.insert(30);
		heap.insert(60);
		heap.insert(80);
		heap.insert(90);
		heap.insert(10);
		for(int i=0;i<heap.currentSize;i++){
			System.out.println(heap.heapArray[i].getValue());
		}
		Node Sorted[]=new Node[heap.currentSize];
		System.out.println("Heap Sort");
		for(int i=0;i<Sorted.length;i++){
		Sorted[i]=heap.extractMax();
		}
		System.out.println("sorted array size:" +Sorted.length);
		for(int i=0;i<Sorted.length;i++){
			System.out.println(Sorted[i].getValue());
		}
		//System.out.println(Arrays.toString(heap.heapArray));
		
		
	}
	
}
