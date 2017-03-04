import java.util.EmptyStackException;

public class StackArray<E>
{	int top;
	int size; 
	E a[];
	
	
	public StackArray(int size){
		this.size=size;
		a=(E[]) new Object[size];
		top=-1;
	}
	public void push(E ele)
	{
			if (top==size-1){
				System.out.println("stack is full");
			}
			else{
				top++;
				a[top]=ele;
			}		
	}
	public E pop()
	{
		if (isEmpty()){
			throw new EmptyStackException();
		}
		else{
			
			return a[top--]; 
		}
	}
	public boolean isEmpty()
	{
		return top==-1;
	}
	public E top(){
		if (top!=-1){
			return a[top];
		}
		return null;
	}
	public void display()
	{
		for(int i=0;i<top;i++)
		{
			System.out.println(a[i]);
		}
	}
	public static void main(String[] args) {
		StackArray<Integer> stack=new StackArray<Integer>(5);
		try{
			stack.push(10);
			stack.push(20);
			stack.display();
			stack.pop();
			stack.display();
			}
		catch(Exception e){
			System.out.println("stack is empty");
		}
	
	}
}
