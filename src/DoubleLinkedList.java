
public class DoubleLinkedList {
		Node head;
		Node tail;
		static class Node{
			int data;
			Node next;
			Node prev;
			Node(int ele)
			{
				data=ele;
				next=null;
				prev=null;
			}
		}
		public static void main(String[] args) {
			DoubleLinkedList DLL=new DoubleLinkedList();
			DLL.head=new Node(10);
			Node Second=new Node(20);
			DLL.tail=new Node(30);
			DLL.head.next=Second;
			DLL.head.prev=null;
			Second.next=DLL.tail;
			Second.prev=DLL.head;
			DLL.tail.prev=Second;
			//System.out.println("head: "+SLL.head+"tail:"+ SLL.tail);
			DLL.pushFront(50);
			//SLL.pushFront(60);
			//SLL.printList();
			DLL.pushFront(60);
			DLL.printList();
			DLL.popFront();
			System.out.println("After pop first element:"); 
			DLL.printList();
			DLL.pushBack(40);
			System.out.println("After pushing element at back:");
			DLL.printList();
			DLL.popBack();
			System.out.println("After pop Last element:");
			DLL.printList();
			DLL.addAfter(Second, 15);
			System.out.println("Add element in middle after node n:");
			DLL.printList();
			DLL.addBefore(Second, 8);
			System.out.println("Add element in middle before node n:");
			DLL.printList();
				
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
			start.prev=null;
			start.next=head;
			head.prev=start;
			head=start;
			if (tail==null){
				tail=head;
			}	
		}
		public void popFront()
		{
			if (head!=null)
			{
				head=head.next;
				head.prev=null;
			}
			else
			{
				System.out.println("Error: Empty List");
			}
			if (head==null){
				tail=head;
			}	
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
				end.prev=tail;
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
					tail=tail.prev;
					tail.next=null;
			}
				
		}
		public void addAfter(Node n,int key)
		{
			Node middle=new Node(key);
			middle.next=n.next;
			middle.prev=n;
			n.next.prev=middle;
			n.next=middle;
			if (tail==n)
			{
				tail=middle;
			}
			
		}
		public void addBefore(Node n,int key)
		{
			Node middle=new Node(key);
			middle.next=n;
			n.prev.next=middle;
			middle.prev=n.prev;
			n.prev=middle;
			if (tail==n)
			{
				tail=middle;
			}
			
		}
		
}
