//implemeting deletion of a node from a DLL
//the element to be deleted may be the head, node other than head or some node which doesn't exist only

import java.util.*;

public class DoublyLinkedList_D
{
	Node head;
	static class Node
	{
		int data;
		Node next;
		Node prev;

		Node(int d)
		{
			data=d;
		}
	}

	//pushing node in front
	public static void push(DoublyLinkedList_D dll,int data)
	{
		Node newNode= new Node(data);
		newNode.next= dll.head;
		newNode.prev=null;
		if(dll.head!=null)
			dll.head.prev=newNode;
		dll.head=newNode;
	}

	//insertion after a given node

	public static void insertionAfter(Node prevNode,int data)
	{
		if(prevNode==null)
		{
			System.out.println("Wrong input");
			return;
		}
		Node newNode= new Node(data);
		newNode.next=prevNode.next;
		prevNode.next=newNode;
		newNode.prev=prevNode;
		if(newNode.next!=null)
			newNode.next.prev=newNode;
	}

	//appending new node at the end

	public static void append(DoublyLinkedList_D dll,int data)
	{
		Node newNode= new Node(data);
		newNode.next=null;
		Node last= dll.head;
		if(dll.head==null)
		{
			newNode.prev=null;
			dll.head=newNode;
			return;
		}
		while(last.next!=null)
			last=last.next;
		last.next=newNode;
		newNode.prev=last;
	}

	//printing

	public static void printing(Node node)
	{
		Node last=null;
		System.out.println("Your List:");
		while(node!=null)
		{
			System.out.print(node.data+" ");
			last=node;
			node=node.next;
		}
		System.out.println();
	}

	//deletion

	public static void deletion(DoublyLinkedList_D dll,Node del)
	{
		//base case
		if(dll.head==null || del==null)
			return;
		//if the node to be deleted is head only
		if(del==dll.head)
			dll.head=del.next;
		//if there exists a node after the node to be deleted
		if(del.next!=null)
			del.next.prev=del.prev;/*the prev of the node next to the node to be deleted must be the prev of del */
		//if there exists a node previous to the node to be deleted
		if(del.prev!=null)
			del.prev.next=del.next;/*the next of the node previous to the node to be deleted must be the next of del*/
		return;
	}

	//main method

	public static void main(String args[])
	{
		DoublyLinkedList_D dll= new DoublyLinkedList_D();
		push(dll,1);
		append(dll,2);
		push(dll,0);
		printing( dll.head);
		append(dll,3);
		append(dll,4);
		append(dll,5);
		append(dll,6);
		push(dll,-1);
		printing(dll.head);
		insertionAfter(dll.head.next.prev.next.prev.next.next,56);
		printing(dll.head);
		//deletion
		deletion(dll,null);
		System.out.println("No change");
		printing(dll.head);

		deletion(dll,null);
		System.out.println("No change");
		printing(dll.head);

		deletion(dll,dll.head);
		System.out.println("head deleted");
		printing(dll.head);

		deletion(dll,dll.head.next.next.next.prev);
		System.out.println("Changed");
		printing(dll.head);

		deletion(dll,dll.head);
		System.out.println("New Head Deleted");
		printing(dll.head);
	}
}
