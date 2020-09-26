/*
Like an array, linked list are also linear data structures, but unlike arrays they do not store data in a contiguous fashion.
Each element in a Linked List is referred to as a Node.
Every node has the data, and a refrence of class Node class type.
Implementing insertion operation here
*/

import java.util.*;

public class LinkedList_I
{
	Node head;//head of the list
	static/*for main to be able to access it*/class Node
	{
		int data;
		Node next;
		//constructor to create a node
		Node(int d)
		{
			next=null;
			data=d;
		}

	}
	//insertion is done at the end
	//we need to traverse in the linked list through the head
	public static LinkedList_I insertion(LinkedList_I list, int data)
	{	//new node with given data
		Node newNode= new Node(data);
		newNode.next = null;//since it is going to be the latest Node
		//if the list is empty
		//to prevent the null pointer exception
		if(list.head==null)
			list.head=newNode;

		else
		{	//traversing till the last Node
			Node curr= list.head;
			while(curr.next!=null)
				curr= curr.next;

			//appending the new Node
			curr.next= newNode;
		}
		return list;
	}

	//printing
	public static void printing(LinkedList_I list)
	{
		Node curr = list.head;
				System.out.println("Linked List:");
				if(curr==null)
					System.out.println("List is empty");
				else
				{//here we didn't use curr.next as if we do that the last value wont be printed
				while(curr!=null)
				{
					System.out.print(curr.data+" ");
					curr= curr.next;
				}
		}
	}
	public static void main(String args[])
	{
		LinkedList_I list= new LinkedList_I();

		list=insertion(list,1);
		list=insertion(list,2);
		list=insertion(list,3);
		list=insertion(list,4);
		list=insertion(list,5);
		list=insertion(list,6);
		list=insertion(list,7);
		list=insertion(list,8);
		list=insertion(list,9);

		printing(list);
	}

}
