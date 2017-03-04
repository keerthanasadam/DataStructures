
public class BinaryTree {
	Node root;
	static class Node{
		int data;
		Node left;
		Node right;
		Node(int ele)
		{
			data=ele;
			left=null;
			right=null;
		}
	}
	public BinaryTree(){
		root=null;
	}
	public void insert(int ele){
		root=insert(root,ele);
	}
	public Node insert(Node node, int data){
		if (node==null){
			node=new Node(data);
		}
		else{
			if(node.right==null){
				node.right=insert(node.right,data);
			}
			else{
				node.left=insert(node.left,data);
				}
			}
		return node;
	}
	public void inorder(){
		inorder(root);
	}
	public void inorder(Node n){
		if(n!=null){
			inorder(n.left);
            System.out.print(n.data +" ");
            inorder(n.right);
		}
	}
	public void preorder(Node n){
		if(n!=null){
			System.out.print(n.data +" ");
			inorder(n.left);
            inorder(n.right);
		}
	}
	public void postorder(Node n){
		if(n!=null){
			inorder(n.left);
            inorder(n.right);
            System.out.print(n.data +" ");
		}
	}
	public static void main(String[] args) {
		BinaryTree BT=new BinaryTree();
		BT.insert(10);
		BT.insert(20);
		BT.insert(12);
		BT.insert(15);
		BT.insert(25);
		BT.insert(27);
		BT.insert(40);
		BT.inorder();
	}
}
