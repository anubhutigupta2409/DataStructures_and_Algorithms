//through this program we are going to create a binary tree, using recursion, clearly we will be following recursive leap of
//faith here, so hold your breath bois <3
//----> Sample input for our tree (REMEMBER a Binary Tree is a tree where every node has 0,1 or 2 children)
/*
       2
     /   \
    1     3
   / \   / \
  4   2 5   1
 /		   /
6         7

*/
//---> keep in mind that entering -1 as input data means that we are telling the program that we do not have anything to enter
//for the asked condition, which means that we donot have the particular asked child for that node

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

public class CreatingBinaryTree
{
	static Scanner sc = null;//to be able to access it
	public static void main(String args[])
	{
		sc= new Scanner(System.in);
		Node root = create();
	}

	static Node create()
	{
		Node root = null;
		System.out.println("Enter the data");
		int data= sc.nextInt();
		//base case
		if(data==-1)
			return null;
		root =new Node(data);
		System.out.println("Enter the left of "+data);
		//recursion ahead
		root.left= create();
		System.out.println("Enter the right of "+data);
		root.right= create();
		return root;
	}
}