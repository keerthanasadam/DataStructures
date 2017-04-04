package org.com.recursion;

import java.util.Scanner;

public class AnagaramRecursion {
	private static char[] a=new char[100];
	private static int size;
	private static int count =0;
	public static void doAnagaram(int newsize){
		if(newsize==1)
			return;
		for(int j=0;j<newsize;j++){
			doAnagaram(newsize-1);
			if(newsize==2)
				display();
			rotate(newsize);
		}
	}
	public static void rotate(int newsize){
		int i;
		int pos=size-newsize;
		char temp=a[pos];
		for(i=pos+1;i<size;i++){
			a[i-1]=a[i];
		}
		a[i-1]=temp;
		
	}
	public static void display(){
		count++;
		System.out.print(count+" ");
		for(int j=0;j<size;j++){
			System.out.print(a[j]);
		}
		System.out.println();
	}
	
	public static void main(String[] args) {
		Scanner s =new Scanner(System.in);
		String input=s.nextLine();
		size=input.length();
		for(int i=0;i<size;i++){
			a[i]=input.charAt(i);
		}
		AnagaramRecursion.doAnagaram(size);
	}
}
