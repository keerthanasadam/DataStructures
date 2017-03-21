package org.com.tree;

class Node{
	int data;
	Node left;
	Node right;
	public Node(int data){
		this.data=data;
		left=null;
		right=null;
	}
}
public class BinarySearchTree {
	private static Node root;
	public BinarySearchTree(){
		root=null;
	}
	public static Node find(int searchEle){
		Node current=root;
		Node parent=current;
		while(true){
			if(current==null){
				return current;
			}
			if(current.data==searchEle){
				//System.out.println("Element found");
				return current;
			}
			if(searchEle<current.data){
				parent=current;
					if(current.left!=null){
						current=current.left;
					}
					else{
						//System.out.println("Element not found");
						return current;
					}
					
				}
			else{
					parent=current;
					if(current.right!=null){
						current=current.right;	
					}
					else{
						//System.out.println("Element not found");
						return current;
					}
					
				}
		}
		
	}
	
	public static void insert(int ele){
		Node current=find(ele);
		Node newNode=new Node(ele);
		if(current==null){
			root=newNode;
		}
		else if(current.data!=ele){
			if(ele<current.data){
				current.left=newNode;
			}
			else{
				current.right=newNode;
			}
		}
		else{
			return;
		}
		
	}
	public static void inOrder(Node localRoot){
		if(localRoot!=null){
			inOrder(localRoot.left);
			System.out.println(localRoot.data);
			inOrder(localRoot.right);
		}
		
	}
	public static void preOrder(Node localRoot){
		if(localRoot!=null){
			System.out.println(localRoot.data);
			preOrder(localRoot.left);
			preOrder(localRoot.right);
		}
		
	}
	public static void postOrder(Node localRoot){
		if(localRoot!=null){
			postOrder(localRoot.left);
			postOrder(localRoot.right);
			System.out.println(localRoot.data);
		}
		
	}
	public static boolean delete(int delEle){
		Node current=root;
		Node parent=current;
		boolean isLeftChild=true;
			while(current.data!=delEle){
				parent=current;
				if(current.data<delEle){
					isLeftChild=false;
					current=current.right;
				}
				else{
					isLeftChild=true;
					current=current.left;
				}
				if(current==null){
					return false;
				}
			}
		if(current.left==null && current.right==null){
				if(current==root){
					root=null;
				}
				else if(!isLeftChild){
					parent.right=null;
				}
				else{
					parent.left=null;
				}
			}
		else if(current.left!=null){
				if(current==root){
					root=current.left;
				}
				else if(!isLeftChild){
					parent.right=current.left;
				}
				else{
					parent.left=current.left;
				}
			}
		else if(current.right!=null){
				if(current==root){
					root=current.right;
				}
				else if(!isLeftChild){
					parent.right=current.right;
				}
				else{
					parent.left=current.right;
				}
			}
		else {
				Node[] successorArray=getSuccessor(current);
				Node succParent=successorArray[0];
				Node successor=successorArray[1];
					if (current==root){
						root=successor;
					}
					if(parent.data<delEle){
						parent.right=successor;
					}
					else{
						parent.left=successor;	
					}
					successor.left=current.left;
					successor.right=current.right;
					succParent.left=successor.right;
			}
		return true;
				
	}
	public static Node[] getSuccessor(Node node){
		Node currentRight=node.right;
		Node parentRight=currentRight;
		Node[] successor=new Node[2];
		if(currentRight!=null){
			while(currentRight.left!=null){
				parentRight=currentRight;
				currentRight=currentRight.left;
			}
			successor[0]= parentRight;
			successor[1]=currentRight;
					
		}
		
		return successor;
	}
		
	
	public static void main(String[] args) {
		BinarySearchTree.insert(63);
		BinarySearchTree.insert(47);
		BinarySearchTree.insert(71);
		BinarySearchTree.insert(22);
		BinarySearchTree.insert(53);
		BinarySearchTree.insert(67);
		BinarySearchTree.insert(11);
		BinarySearchTree.insert(33);
		BinarySearchTree.insert(50);
		BinarySearchTree.insert(60);
		BinarySearchTree.insert(17);
		BinarySearchTree.insert(48);
		BinarySearchTree.insert(51);
		//BinarySearchTree.display(root);
		Node found=find(48);
		if(found.data==48){
			System.out.println("Element found");
		}
		else{
			System.out.println("Element not exists");
		}
		BinarySearchTree.delete(47);
		BinarySearchTree.inOrder(root);
	}
	

}
