

public class QueueLinkedList {
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
		QueueLinkedList QLL=new QueueLinkedList();
		QLL.enqueue(10);
		//QLL.enqueue(20);
		QLL.dequeue();
		System.out.println(QLL.isEmpty());
	}

	
	public void enqueue(int a){
		Node start=new Node(a);
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
	public int dequeue(){
		if (head==null)
		{
			System.out.println("Error: Empty List");
			return -1;
		}
		else if (head==tail){
			Node temp=head;
			head=tail=null;
			return temp.data;
		}
		else{
			Node p=head;
			while(p.next!=tail)
			{
				p=p.next;
			}
			p.next=null;
			tail=p;
			return head.data;
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