/*
Doubly Linked List(DLL)
Very similar to Singly Linked List, but instead has a pointer pointing to the previous node as well.
Advantages over Singly Linked List-
1. we can traverse the linked list, both from forward and backward positions
2. the deletion and insertion operations become more efficient
Disadvantages-
1. extra memory required for the previous pointer
2. previous pointer have to be maintained also now, for all the operations

//The following shows the insertion of a node in the DLL in four possible ways-
1. as the first node
2. as the last node
3. before a node
4. after a node
*/

import java.util.*;

public class DoublyLinkedList_I
{
	Node head;
	static class Node
	{
		int data ;
		Node prev;
		Node next;

		Node(int d)
		{
			data=d;
		}
	}

	//method to add a node at the front of the list(as the first node)
	public static void push(DoublyLinkedList_I dll,int data)
	{
		Node newHead = new Node(data);//creating the new node
		newHead.next= dll.head;
		newHead.prev= null;

		if(dll.head!=null)
			dll.head.prev=newHead;

		dll.head=newHead;
	}

	//method to add a node after a given node
	public static void insertionAfter(Node prevNode,int data)
	{
		//doing check of a situation which is not favourable
		if(prevNode==null)
		{
			System.out.println("Wrong input");
			return;
		}
		//creating a new node with given data
		Node afterNode=new Node(data);
		/*the next of our new node must be the next of the node given to us(after which new node had to be inserted)*/
		afterNode.next=prevNode.next;
		/*the next of the given node must be our new node*/
		prevNode.next=afterNode;
		/*the prev of our new node must be node given to us*/
		afterNode.prev=prevNode;
		if(afterNode.next!=null/*if our new node is not the last node in the list*/)
			afterNode.next.prev=afterNode;/*the node next to our new node, must have it's prev as our new node*/
	}

	//method to add a node at the end

	public static void append(DoublyLinkedList_I dll,int data)
	{
		Node newNode=new Node(data);
		Node last= dll.head;//to traverse the DLL, till the last node
		newNode.next=null;//this is our latest element
		//if the list is empty
		if(dll.head==null)
		{
			newNode.prev=null;
			dll.head=newNode;
			return;
		}
		//else

		while(last.next!=null)
			last=last.next;
		//the next of the last node must be our new node
		last.next=newNode;
		//the prev of our new node must be the previous last node
		newNode.prev=last;
	}

	//method to print the contents of our DLL, starting from a given node

	public static void printing(Node node)
	{
		Node last=null;
		System.out.println("Traversal in forward direction-");
		while(node!=null)
		{
			System.out.print(node.data+" ");
			last=node;
			node=node.next;
		}
		System.out.println("\nTraversal in backward direction-");
		while(last!=null)
		{
			System.out.print(last.data+" ");
			last=last.prev;
		}
	}

	//main method
	public static void main(String args[])
	{
		DoublyLinkedList_I dll= new DoublyLinkedList_I();
		push(dll,1);
		append(dll,2);
		push(dll,0);
		System.out.println("First insertion:");
		printing(dll.head);
		push(dll,-1);
		append(dll,3);
		append(dll,4);
		append(dll,5);
		append(dll,6);
		System.out.println("\nChanged:");
		printing(dll.head);
		insertionAfter(dll.head.next,8);
		System.out.println("\nChanged:");
		printing(dll.head);
		insertionAfter(dll.head.next.next.next.prev.next,9);
		System.out.println("\nChanged:");
		printing(dll.head);

	}
}
