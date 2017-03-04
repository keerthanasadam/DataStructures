import java.util.EmptyStackException;
import java.util.Scanner;

public class Check_Brackets<E> {
	int top;
	E[] brackets;
	int size;
	static Check_Brackets<Character> CB;
	public Check_Brackets(int size){
		this.size=size;
		brackets=(E[])new Object[size];
		top=-1;
	}
	public void push(E ele){
		if(top==size-1){
			System.out.println("stack is full");
		}
		brackets[++top]=ele;
	}
	public E pop(){
		if(isEmpty()){
			throw new EmptyStackException();
		}
		return brackets[top--];
		
	}
	public boolean isEmpty(){
		if(top==-1){
			return true;
		}
		else
			return false;
	}
	public E top(){
		if (top!=-1){
			return brackets[top];
		}
		return null;
	}
	public static void main(String[] args) {
		Scanner scan=new Scanner(System.in);
		String s=scan.nextLine();
		CB=new Check_Brackets<Character>(s.length());
		CB.readInput(s);
		/*if(i==1){
			System.out.println("Success");
		}*/
	}
	public void readInput(String s){
		
		char c;
		char[] input=s.toCharArray();
		for(int input_i=0;input_i<s.length();input_i++){
			if(input[input_i]=='('||input[input_i]=='{'||input[input_i]=='['){
				CB.push(input[input_i]);
			}
			else{
				if(Character.isLetter(input[input_i])||Character.isDigit(input[input_i])){
					continue;
				}
				if (CB.isEmpty()){
					System.out.println(input_i+1);
					return;
				}
				char current=CB.pop();
				if((current=='[' && input[input_i]!=']')||(current=='{' && input[input_i]!='}')||(current=='(' && input[input_i]!=')')){
					System.out.println(input_i+1);
					return;
				}
			}
		}
		if(!CB.isEmpty()){
			System.out.println(s.indexOf(CB.top())+1);;
		}
		else{
			System.out.println("Success");
		}
		
	}
}
