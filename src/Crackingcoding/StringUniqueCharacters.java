package Crackingcoding;

import java.util.Arrays;
import java.util.HashMap;

public class StringUniqueCharacters {
	public static boolean checkUnique(String s){
		StringBuffer sb=new StringBuffer(s);
		 char[] charArray=s.toCharArray();
		 int count=0;
		 for(int i=0;i<s.length();i++){
			 char c=s.charAt(i);
			for(int j=0;j<charArray.length;j++){
				if(charArray[j]==c){
					count++;
				}
				if(count>1){
					return false;
				}
			}
			count=0;
		 }
		 return true;
		}
	public static boolean checkUnique1(String s){
		HashMap<Character,Integer> hmap=new HashMap<Character,Integer>();
		for(int i=0;i<s.length();i++){
			//int count=hmap.containsKey(s.charAt(i))?
			if(!hmap.containsKey(s.charAt(i))){
				hmap.put(s.charAt(i), 1);
			}
			else{
				return false;
			}
		}
		return true;
		
	}
	public static boolean checkUnique2(String s){
		 for(int i=0;i<s.length();i++){
			 char c=s.charAt(i);
			for(int j=i+1;j<s.length();j++){
				char d=s.charAt(j);
				if((c & d)!=0){
					continue;
				}
				else
					return false;
			}
		 }
		 return true;
		}
	public static boolean checkUnique3(String s){
		if(s.length()>256)
			return false;
		boolean[] char_set=new boolean[256];
		System.out.println(Arrays.toString(char_set));
		 for(int i=0;i<s.length();i++){
			 int val=s.charAt(i);
			 char c=(char) val;
			 System.out.println(val+","+c);
				if(char_set[c]){
					return false;
				}
				char_set[c]=true;
				System.out.println(char_set[c]);
			}
		
		 System.out.println(Arrays.toString(char_set));
		 return true;
		}
	public static boolean checkUnique4(String s){
		if(s.length()>26)
			return false;
		int checker=0;
		for(int i=0;i<s.length();i++){
			int val=s.charAt(i)-'a';
			System.out.println(val);
			System.out.println(1<<val);
			if((checker & (1<<val))>0){
				return false;
			}
			checker|=(1<<val);
		}
		 return true;
		}
	public static void main(String args[]){
		String s="Hello are you unique";
		String s1="kerthan";
		System.out.println("Does string conatin unique characters: "+ StringUniqueCharacters.checkUnique4(s1));
		
	}
}
