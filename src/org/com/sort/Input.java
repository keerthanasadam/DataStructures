package org.com.sort;


public class Input {
	public static void main(String[] args) {
		//SelectionSort s=new SelectionSort();
		//SelectionSort.sort(new int[]{10,15,7,18,12});
		//InsertionSort.sort(new int[]{10,15,7,18,12});
		int[] a= new int[]{54,26,93,17,77, 31,45, 55,20};
		QuickSort.sort(a,0,a.length-1 );
	}

	
}
