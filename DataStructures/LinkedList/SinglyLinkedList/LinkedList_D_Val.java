//implementing deletion of a node ,when the value to be deleted is given, from a LinkedList

import java.util.*;

public class LinkedList_D_Val
{
	Node head= null;
	static class Node
	{
		int data;
		Node next;
		Node(int d)
		{
			data=d;
			next= null;
		}
	}
	//method for insertion
	public static LinkedList_D_Val insertion(LinkedList_D_Val list, int data)
	{
		Node newNode= new Node(data);
		newNode.next= null;
		if(list.head==null)
			list.head= newNode;
		else
		{
			Node last=list.head;
			while(last.next!=null)
				last= last.next;
			last.next= newNode;
		}
		return list;
	}
	//printing method
	public static void printing(LinkedList_D_Val list)
	{
		Node curr= list.head;
		System.out.println("LinkedList:");
		if(curr==null)
			System.out.println("List is empty");
		else
		{
			while(curr!=null)
			{
				System.out.print(curr.data+" ");
				curr=curr.next;
			}
			System.out.println();
		}
	}
	//deletion of the node
	public static LinkedList_D_Val deletion(LinkedList_D_Val list,int val)
	{
		Node curr= list.head, prev=null;
		//if the value to be deleted is present at the head itself
		if(curr!=null && curr.data== val)
		{
			list.head=curr.next;//node changed
			System.out.println("Value "+val+" deleted, and list updated:");
			return list;
		}
		//if value is present at a position other than the head node
		//we are continuing if the value is not present
		//keeping track of the previous node as well
		while(curr!=null && curr.data!=val)
		{
			prev=curr;
			curr=curr.next;
		}
		//from the above loop we have traversed through our Linked List
		//if the value was present then it should be present at the current node only
		if(curr!=null)
		{
			prev.next=curr.next;//updating
			System.out.println("Value "+val+" deleted, and list updated");
			return list;
		}
		//but if the curr==null, means we have traversed till the end of the list and the value was not present
		if(curr==null)
			System.out.println("Value not present");

		return list;

	}
	//main method
	public static void main(String args[])
	{
		LinkedList_D_Val list= new LinkedList_D_Val();
		//inserting
		list=insertion(list,1);
		list=insertion(list,2);
		list=insertion(list,3);
		list=insertion(list,4);
		list=insertion(list,5);
		list=insertion(list,6);
		list=insertion(list,7);
		list=insertion(list,8);
		list=insertion(list,9);
		list=insertion(list,10);

		//printing
		printing(list);

		//deletion
		deletion(list,1);
		printing(list);
		deletion(list,7);
		printing(list);
		deletion(list,-3);
		printing(list);
	}
}


