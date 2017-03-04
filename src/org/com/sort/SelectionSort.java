package org.com.sort;

import java.util.Arrays;

public class SelectionSort {
	public static void sort(int[] a){
		int sorted[]=new int[a.length];
		for(int i=0;i<a.length-1;i++){
			int[] minindex=minimum(a,i);
			a[minindex[1]]=a[i];
			a[i]=minindex[0];
			sorted[i]=minindex[0];
		}
		printArray(a);
	}
	
	public static int[] minimum(int[] a, int j){
		int min=a[j];
		int index=0;
		for(int i=j+1;i<a.length;i++){
			if(min>a[i]){
				min=a[i];
				index=i;
			}
		}
		return new int[]{min,index};
	}
	public static void printArray(int[] sorted){
		System.out.println("Selection sort: "+ Arrays.toString(sorted));
	}
	
}
