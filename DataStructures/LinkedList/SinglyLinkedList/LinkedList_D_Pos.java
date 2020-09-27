//implemention deletion of a node, from a position, from Linked List

import java.util.*;

public class LinkedList_D_Pos
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

	//insertion

	public static LinkedList_D_Pos insertion(LinkedList_D_Pos list, int data)
	{
		Node newNode= new Node(data);
		newNode.next=null;
		if(list.head==null)
			list.head=newNode;
		else
		{
			Node last= list.head;
			while(last.next!=null)
			{	last=last.next;
			}
			last.next= newNode;
		}
		return list;
	}

	//deletion from a index position

	public static LinkedList_D_Pos deletion(LinkedList_D_Pos list, int index)
	{
		Node curr=list.head, prev=null;
		//if the position is 0, that is; the head itself
		if(index==0 && curr!=null)
		{
			list.head= curr.next;
			System.out.println("Node at position "+index+" deleted, list updated");
			return list;
		}
		//if present at some other position
		int counter=0;
		while(curr!=null)
		{
		if(counter==index)
		{
			prev.next=curr.next;
			System.out.println("Node at position "+index+" deleted, list updated");
			break;
		}
		else
		{
			prev=curr;
			curr=curr.next;
			counter++;
		}
		}
		if(curr==null)
			System.out.println("No node is present at this position");
		return list;
	}

	//printing

	public static void printing(LinkedList_D_Pos list)
	{
		Node curr=list.head;
		System.out.println("Linked List:");
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
	//main method

	public static void main(String args[])
	{
		LinkedList_D_Pos list= new LinkedList_D_Pos();
		//insertion
		list= insertion(list,1);
		list= insertion(list,2);
		list= insertion(list,3);
		list= insertion(list,4);
		list= insertion(list,5);
		list= insertion(list,6);
		list= insertion(list,7);
		list= insertion(list,8);
		list= insertion(list,9);
		list= insertion(list,10);
		//printing
		printing(list);
		//deletion
		deletion(list,0);
		printing(list);
		deletion(list,4);
		printing(list);
		deletion(list,12);
		printing(list);
	}
}