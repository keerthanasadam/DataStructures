
public class InfixtoPostfix {
	
	public int operatorPrecedence(char ch){
		switch(ch){
		case '+':
		case '-':
			return 1;
		case '*':
		case '/':
			return 2;
		case '^':
			return 3;
		default:
			return -1;
		}
	}
	boolean isOperand(char ch){
		 if((ch>='a'&& ch<='z')||(ch>='A'&& ch<='Z')){
			 return true;
		 }
		 else{
			 return false;
		 }
	}
	public void conversion( char[] exp){
		int i,k;
		StackArray<Character> stack=new StackArray<Character>(exp.length);
		for( i=0,k=-1;i<exp.length;i++){
			if (isOperand(exp[i])){
				exp[++k]=exp[i];
			}
			else if(exp[i]=='('){
				stack.push(exp[i]);
			}
			else if (exp[i]==')'){
				while( !stack.isEmpty() && stack.top()!='(' ){
					exp[++k]=stack.pop();
				}
				if(!stack.isEmpty() && stack.top()!='('){
					System.out.println("Invalid Expression");
				}
				else{
					stack.pop();
				}
			}
			else{
				while(!stack.isEmpty() && (operatorPrecedence(exp[i])>stack.top())){
					exp[++k]=stack.pop();
				}
				stack.push(exp[i]);
			}
		}
		while (!stack.isEmpty())
	        exp[++k] = stack.pop();
		
	}
	public static void main(String[] args) {
		
		String infix="a+b*(c^d-e)^(f+g*h)-i";
		char[] exp=infix.toCharArray();
		InfixtoPostfix ITP=new InfixtoPostfix();
		ITP.conversion(exp);
		String postfix=new String(exp);
		System.out.println("postfix: \n"+ postfix);
	}
}
