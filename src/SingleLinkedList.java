
public class SingleLinkedList {
	Node head;
	Node tail;
	static class Node{
		int data;
		Node next;
		Node(int ele)
		{
			data=ele;
			next=null;
		}
	}
	public static void main(String[] args) {
		SingleLinkedList SLL=new SingleLinkedList();
		SLL.head=new Node(10);
		Node Second=new Node(20);
		SLL.tail=new Node(30);
		SLL.head.next=Second;
		Second.next=SLL.tail;
		System.out.println("head: "+SLL.head+"tail:"+ SLL.tail);
		SLL.pushFront(50);
		//SLL.pushFront(60);
		//SLL.printList();
		SLL.pushFront(60);
		SLL.printList();
		SLL.popFront();
		System.out.println("After pop first element:"); 
		SLL.printList();
		SLL.pushBack(40);
		System.out.println("After pushing element at back:");
		SLL.printList();
		SLL.popBack();
		System.out.println("After pop Last element:");
		SLL.printList();
		SLL.addAfter(Second, 15);
		System.out.println("Add element in middle after node n:");
		SLL.printList();
		SLL.addBefore(Second, 8);
		System.out.println("Add element in middle before node n:");
		SLL.printList();
			
	}
	public void printList()
	{
		Node n=head;
		while(n!=null)
		{
			System.out.println("key:"+n.data+" pointer:"+n.next);
			n=n.next;
			
		}
	}
	public void pushFront(int key)
	{
		Node start=new Node(key);
		if(head==null){
			head=start;
		}
		else{
		start.next=head;
		head=start;
		}
		if (tail==null){
			tail=head;
		}	
	}
	public int popFront()
	{	Node temp=head;
		if (head!=null)
		{
			head=head.next;
		}
		else
		{
			System.out.println("Error: Empty List");
		}
		if (head==null){
			tail=head;
		}
		return temp.data;
	}
	public void pushBack(int key)
	{
		Node end=new Node(key);
		if(tail==null)
		{
			head=tail=end;
		}
		else
		{
			tail.next=end;
			tail=end;
		}
		
	}
	public void popBack()
	{
		if (head==null)
		{
			System.out.println("Error: Empty List");
		}
		else if (head==tail){
			head=tail=null;
		}
		else{
			Node p=head;
			while(p.next!=tail)
			{
				p=p.next;
			}
			p.next=null;
			tail=p;
		}
			
	}
	public void addAfter(Node n,int key)
	{
		Node middle=new Node(key);
		middle.next=n.next;
		n.next=middle;
		if (tail==n)
		{
			tail=middle;
		}
		
	}
	public void addBefore(Node n,int key)
	{
		Node middle=new Node(key);
		Node p=head;
		while(p.next!=n){
			p=p.next;
		}
		middle.next=p.next;
		p.next=middle;
		if (tail==n)
		{
			tail=middle;
		}
		
	}
	public boolean isEmpty(){
		if (head==null && tail==null){
			return true;
		}
		else{
			return false;
		}
	}
}
