

public class LinkedListlenIterative 
{
	public static void main(String[] args) {
		LinkedListlenIterative LLI=new LinkedListlenIterative();
		SingleLinkedList SLL=new SingleLinkedList();
		SLL.pushFront(10);
		SLL.pushBack(20);
		SLL.addAfter(SLL.head, 40);
		SLL.printList();
		int length=LLI.iterativeLength(SLL);
		int reclength=LLI.recurrsivelength(SLL.head);
		System.out.println("Iterative length of list:"+length);
		System.out.println("Recurrsive length of list:"+reclength);
	}
	public int iterativeLength(SingleLinkedList sll)
	{	
		int listlen=0;
		SingleLinkedList.Node temp=sll.head;
		if (sll.head==null){
			return 0;
		}
		else
		{
			while(temp!=null){
				temp=temp.next;
				listlen++;
			}
		}
		return listlen;
	}
	public int recurrsivelength(SingleLinkedList.Node head ){
		
		if (head==null){
			return 0;
		}
		
		else{
			return 1+ recurrsivelength(head.next);
		}
		
		
	}
}
