package org.com.greedy;

import java.util.*;

public class ActivitySelection1 {
	public static void main(String[] args) {
		List<Integer> finish=new ArrayList<>();
		List<Integer> start=new ArrayList<>();
		int a[][]={{5,9},{1,2},{3,4},{0,6},{5,7},{8,9}};
		for(int i=0;i<a.length;i++){
			int[] inner=a[i];
			for(int j=0;j<inner.length-1;j++){
				start.add(a[i][j]);
				finish.add(a[i][j+1]);
			}
		}
		//Collections.sort(finish);
		//System.out.println(Arrays.toString(finish.toArray()));
		
 }
	public static int selectionCount(int[]s, int[] f){
		int count=1;
		for(int i=0,j=0;i<s.length-1;i++){
			if(s[i+1]>=f[j]){
				count++;
				j++;
			}
		}
		return count;
	}
}
