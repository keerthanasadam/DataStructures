package org.com.sort;

import java.util.Arrays;

public class QuickSort {

	public static void sort(int a[], int l, int r) {
		int pivot = 0 ;
		while (l < r ) {
			while(a[l]<a[pivot]) 
			{
				l++;
			}
			while(a[r]>a[pivot])
			{
				r--;
			}
			if(l<r){
				int temp = a[l];
				a[l] = a[r];
				a[r] = temp;
				l++;
				r--;
			} 
			

		}

		{	int temp=pivot;
			pivot=a[r];
			
		}
		
		printArray(a);
	}
	
	public static void printArray(int[] sorted){
		System.out.println("Quick sort: "+ Arrays.toString(sorted));
	}
	
	
}
