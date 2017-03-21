package org.com.list;

class Node{
	int data;
	Node next;
	public Node(int ele){
		data=ele;
		next=null;
	}
}
public class LinkedInsertion {
	Node head;
	public void insertion(int ele){
		if(head==null){
			Node newNode=new Node(ele);
			head=newNode;
		}
		else{
			Node newNode=new Node(ele);
			Node temp=head;
			while(temp.next!=null){
				temp=temp.next;
			}
			temp.next=newNode;	
		}
	}
	public void afterInsertion(int ele, int pos){
		if(head==null){
			Node newNode=new Node(ele);
			head=newNode;
		}
		else{
			int count=0;
			Node newNode=new Node(ele);
			Node temp=head;
			Node prev=head;
			while(count!=pos && temp.next!=null){
				prev=temp;
				temp=temp.next;
				count++;
			}
			if(count==pos){
				prev.next=newNode;
				newNode.next=temp;
			}
			else{
				temp.next=newNode;
			}
		}
	}
	public void display(){
		Node temp=head;
		while(temp!=null){
			System.out.println(temp.data+","+temp.next);
			temp=temp.next;
		}
	}
	public static void main(String[] args) {
		LinkedInsertion li=new LinkedInsertion();
		li.insertion(10);
		li.insertion(20);
		li.insertion(40);
		li.afterInsertion(30,2);
		li.afterInsertion(35, 3);
		li.display();
	}
}
