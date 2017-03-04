

public class StackLinked {
	Node head;
	static class Node{
		int data;
		Node next;
		Node(int ele)
		{
			data=ele;
			next=null;
		}
	}
	public void push(int ele){
		Node add=new Node(ele);
		if (head==null){
			head=add;
		}
		else{
			add.next=head;
			head=add;
		}
	}
	public void pop(){
		if(head==null){
			System.out.println("stack is empty");
		}
		else{
			head=head.next;
			
		}
	}
	public boolean isEmpty(){
		if (head==null){
			return true;
		}
		else{
			return false;
		}
		
	}
	public void display(){
		while(head!=null){
			System.out.println("stack elements"+head.data);
			head=head.next;
		}
	}
	public static void main(String[] args) {
		StackLinked stackL=new StackLinked();
		stackL.push(10);
		stackL.push(20);
		stackL.display();
		stackL.pop();
		stackL.display();
	
	}
}
