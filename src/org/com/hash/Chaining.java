package org.com.hash;

class Link{
	private int data;
	private Link next;
	public Link(int data){
		this.data=data;
		next=null;
	}
	public int getData(){
		return data;
	}
	public Link getLink(){
		return next;
	}
	public void setLink(Link next){
		this.next=next;
	}
}

public class Chaining {
	private Link[] hashArray;
	private int arraySize;
	private Link root;
	public Chaining(){
		
	}
	public Chaining(int size){
		hashArray=new Link[size];
		arraySize=size;
		root=null;
	}
	public void insert(Link insertData){
		int index=hashFunc(insertData);
		while(hashArray[index]!=null){
			Link temp=new Link(insertData.getData());
			if(root==null){
				root=temp;
				hashArray[index].setLink(root);
			}
			else{
				Link p=root;
				while(p.getLink()!=null){
					p=p.getLink();
				}
				p.setLink(temp);
			}
		}
		hashArray[index]=insertData;
	}
	public int hashFunc(Link data){
		return data.getData()%arraySize;
	}
}
