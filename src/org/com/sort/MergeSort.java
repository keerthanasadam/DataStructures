package org.com.sort;

public class MergeSort {
	private static int neles;
	private static int[] a={64,21,33,70,12,85,44,3,99,0,108,36};
	static void recMergeSort(int[] workspace,int lowerbound,int higherbound){
		if(lowerbound==higherbound){
			return;
		}
		else{
			int mid=(lowerbound+higherbound)/2;
			recMergeSort(workspace,lowerbound,mid);
			recMergeSort(workspace, mid+1, higherbound);
			merge(workspace,lowerbound,mid+1,higherbound);
		}
	}
	public static void merge(int[] workspace, int lowptr,int highptr, int upperbound){
		int lowerbound=lowptr;
		int mid=highptr-1;
		int n=upperbound-lowerbound+1;
		int i=0;
		while(lowptr<=mid && highptr<=upperbound){
			if(a[lowptr]<a[highptr]){
				workspace[i++]=a[lowptr++];
			}
			else if(a[lowptr]>a[highptr]){
				workspace[i++]=a[highptr++];
			}
		}
		while(lowptr<=mid){
			workspace[i++]=a[lowptr++];
		}
		while(highptr<=upperbound){
			workspace[i++]=a[highptr++];
		}
		for(int j=0;j<n;j++){
			a[lowerbound+j]=workspace[j];
		}
	}
	public static void mergesort(){
		int workspace[]=new int[neles];
		recMergeSort(workspace, 0, neles-1);
	}
	public static void main(String[] args) {
		neles=a.length;
		MergeSort.mergesort();
	}
}
