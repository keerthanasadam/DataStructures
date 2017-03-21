package Crackingcoding;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Hashtable;
import java.util.LinkedList;

public class AnagramSort implements Comparator<String[]>{
	public static String charSort(String s){
		char[] arrayContents=s.toCharArray();
		Arrays.sort(arrayContents);
		return new String(arrayContents);
	}
	public int compare(String[] o1, String[] o2) {
		// TODO Auto-generated method stub
		return 0;
	}
	public static void 	sort(String[] a){
		Hashtable<String, LinkedList<String>> hash=new Hashtable<>();
		for(String s:a){
			String key=charSort(s);
			if(!hash.containsKey(key)){
				hash.put(key, new LinkedList<String>());
			}
			LinkedList<String> anagrams=hash.get(key);
			anagrams.push(s);
		}
		int index=0;
		for(String key: hash.keySet()){
			LinkedList<String> list=hash.get(key);
			for(String ele:list){
				a[index]=ele;
				index++;
			}
		}
		printArray(a);
	}
	public static void printArray(String[] sorted){
		for(int i=0;i<sorted.length;i++){
			System.out.print(sorted[i]+',');
		}
	}
		
	public static void main(String[] args) {
		String[] test= { "abc","cba","xyz","def","yzx","cab","hello","polo"};
		AnagramSort.sort(test);
	}
	
	
}
