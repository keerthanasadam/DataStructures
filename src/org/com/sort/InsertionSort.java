package org.com.sort;

import java.util.Arrays;

public class InsertionSort {
	public static void sort(int[] a){
		
		for(int i=1;i<a.length;i++){
			int temp=a[i];
			int j=i-1;
			while(j>=0 && temp<a[j]){
				a[j+1]=a[j];
				j--;
			}
			a[j+1]=temp;
			
		}
		printArray(a);
	}
	public static void printArray(int[] sorted){
		System.out.println("Insertion sort: "+ Arrays.toString(sorted));
	}
}
