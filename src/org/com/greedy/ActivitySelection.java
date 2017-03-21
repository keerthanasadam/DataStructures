package org.com.greedy;
//Activities are sorted according to finish time
public class ActivitySelection {
	public static void main(String[] args) {
		int s[]={1,3,0,5,8,5};
		int f[]={2,4,6,7,9,9};
		int max_activities=ActivitySelection.selectionCount(s, f);
		System.out.println(max_activities);
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
