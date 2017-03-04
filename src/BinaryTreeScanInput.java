import java.util.Scanner;

public class BinaryTreeScanInput {
	Node root;
	class Node{
		int data;
		Node left,right;
		Node(int ele){
			data=ele;
			left=null;
			right=null;
		}
	}
	public static void main(String[] args) {
		BinaryTreeScanInput BSI=new BinaryTreeScanInput();
		Scanner scan=new Scanner(System.in);
		int size=scan.nextInt();
		int arr[]=new int[size];
		for(int i=0;i<size;i++){
			arr[i]=scan.nextInt();
		}
		
	}
	void createTree(int index,int arr[]){
		Node created[]=new Node[arr.length];
		for(int i=0;i<arr.length;i++){
			created[i]=null;
		}
		for(int i=0;i<created.length;i++){
			createNode(created,i,arr);
		}
	}
	void createNode(Node created[],int index, int parent[]){
		if(created[index]!=null){
			return;
		}
		created[index]=new Node(index);
		if(parent[index]==-1){
			root=created[index];
			return;
		}
		if(created[parent[index]]==null){
			createNode(created, parent[index], parent);
		}
		Node p=created[parent[index]];
		if(p.left==null){
			p.left=created[index];
		}
		else{
			p.right=created[index];
		}
		
	}
}
