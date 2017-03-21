package Crackingcoding;

public class CompressString {
	public static void main(String args[]){
		String s="ababca";
		System.out.println(CompressString.compress(s));
		
	}
	//compress using StringBuffer
	public static String compress(String s){
		int size=countCompress(s);
		if(size>=s.length()){
			return s;
		}
		char[] charArray=s.toCharArray();
		StringBuffer sb=new StringBuffer();
		int count=1;
		for(int i=1;i<s.length();i++){
			if(charArray[i]==charArray[i-1]){
				count++;
			}
			else{
				sb.append(charArray[i-1]);
				sb.append(count);
				count=1;
			}
			if(i==s.length()-1){
				sb.append(charArray[i]);
				sb.append(count);	
			}
		}
		return sb.toString();
	}
	//compress using char[]
	public String compress1(String s){
		int size=countCompress(s);
		if(size>=s.length()){
			return s;
		}
		char[] compress=new char[size];
		char last=s.charAt(0);
		int index=0;
		int count=1;
		for(int i=1;i<s.length();i++){
			if(last==s.charAt(i)){
				count++;
			}
			else{
				index=setChar(compress,last,count,index);
				last=s.charAt(i);
			}
		}
		index=setChar(compress,last,count,index);
		return String.valueOf(compress);
	}
	public static int setChar(char[]compress, char last, int count, int index){
		compress[index]=last;
		index++;
		char[] cnt=String.valueOf(count).toCharArray();
		for(char c:cnt ){
			compress[index]=c;
			index++;
		}
		return index;
	}
	public static int countCompress(String s){
		if(s==null||s.isEmpty())return 0;
		int size=0;
		char last=s.charAt(0);
		int count=1;
		for(int i=1;i<s.length();i++){
			if(last==s.charAt(i)){
				count++;
			}
			else{
				last=s.charAt(i);
				size+=1+String.valueOf(count).length();
				count=1;
			}
		}
		size+=1+String.valueOf(count).length();
		return size;
	}
			
	
}
