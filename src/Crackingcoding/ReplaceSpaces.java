package Crackingcoding;
import java.util.*;

public class ReplaceSpaces {
	public static void main(String[] args) {
		String source="Mr John Smith    ";
		int true_length=13;
		int spaces=0;
		char[] charArray=source.toCharArray();
		for(int i=0;i<true_length;i++){
			if(charArray[i]== ' ')
				spaces++;
		}
		int total_length=true_length+spaces*2;
		char[] target=new char[total_length];
		for(int i=0,j=0;j<total_length;i++){
			if(charArray[i]==' '){
				target[j]='%';
				target[j+1]='2';
				target[j+2]='0';
				j=j+3;
						}
			else{
				target[j]=charArray[i];
				j++;
			}	
		}
	char[] target1=ReplaceSpaces.replace(charArray,13);
		String output=new String(target1);
		System.out.println(Arrays.toString(target));
		System.out.println(output);
	}
	
	public static char[] replace(char[] str,int length){
		
		int spaceCount=0,newLength,i;
		for(i=0;i<length;i++){
			if(str[i]==' ')
			spaceCount++;
		}
		newLength=length+spaceCount*2;
		//str[newLength]='\0';
		for( i=length-1;i>=0;i--){
			if(str[i]==' '){
				str[newLength-1]='0';
				str[newLength-2]='2';
				str[newLength-3]='%';
				newLength=newLength-3;
			}
			else{
				str[newLength-1]=str[i];
				newLength=newLength-1;
			}
		}
		return str;
	}
}
