//the different ways by which we can traverse a tree is the main reason why trees are a very important data structure
//for example the java compiler checks the operator priority through pre-order traversal of the tree
//----> Sample Tree
/*
	2
       / \
      4   1
     /	 / \
    7   8   3
*/
//--> doing traversals manually
//--> PreOrder Traversal 
/*
-->Follows Node(means now perform on the operation on the current node, example(printing)) Left Right
-->2 4 7 1 8 3
*/
//--> InOrder Traversal
/*
-->Follows Left Node Right
-->7 4 2 8 1 3
*/
//--> PostOrder Traversal 
/*
-->Follows Left Right Node
-->7 4 8 3 1 2
*/

import java.util.*;

class Node
{
	Node left, right;
	int data;
	Node(int data)
	{
		this.data = data;
	}
}

public class TreeTraversal
{
	static Scanner sc = null;
	public static void main(String args[])
	{
		sc = new Scanner(System.in);
		Node root= create();
		System.out.println("\nTraversals:");
		System.out.println("PreOrder-->");
		preOrder(root);
		System.out.println("\nInOrder-->");
		inOrder(root);
		System.out.println("\nPostOrder-->");
		postOrder(root);
	}

	static Node create()
	{
		Node root= null;
		System.out.println("Enter Data:");
		int data= sc.nextInt();
		if(data==-1)
			return null;
		root=new Node(data);
		System.out.println("Enter left of "+data);
		root.left= create();
		System.out.println("Enter right of "+data);
		root.right= create();

		return root;
	}
	//traversal methods
	static void preOrder(Node root)
	{
		if(root==null)
			return;
		System.out.print(root.data+" ");//Node
		preOrder(root.left);//left
		preOrder(root.right);//right
	}
	static void inOrder(Node root)
	{
		if(root==null)
			return;
		inOrder(root.left);//left
		System.out.print(root.data+" ");//Node
		inOrder(root.right);//right
	}
	static void postOrder(Node root)
	{
		if(root==null)
			return;
		postOrder(root.left);//left
		postOrder(root.right);//right
		System.out.print(root.data+" ");//Node
	}
}
