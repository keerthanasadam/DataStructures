package org.com.sort;

import java.util.Arrays;

public class QuickSort {

	public static int partition(int a[], int l, int r) {
		int pivot = l ;
		l++;
		while (l < r ) {
			while(a[l]<a[pivot] && l<r) 
			{
				l++;
			}
			while(a[r]>a[pivot] && r>0)
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
		//System.out.println("r index"+ r);
		if(r>pivot){
		int temp=a[r];
		a[r]=a[pivot];
		a[pivot]=temp;
		}
		return r;
		
	}
	
	public static void sort(int a[], int l, int r){
		if(l<r)
		{
			int pos=partition(a, l, r);
			sort(a,l,pos-1);
			sort(a,pos+1,r);	
		}
		printArray(a);
	}
	public static void printArray(int[] sorted){
		System.out.println("Quick sort: "+ Arrays.toString(sorted));
	}
	
	
}
