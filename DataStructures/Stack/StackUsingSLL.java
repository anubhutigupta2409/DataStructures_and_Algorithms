// Implementing a stack in java using a singly linked list(sll)

import java.util.*;

class MyStack
{
	private class Node
	{
		int data;
		Node link;
	}

	Node top;//the top of the stack

	MyStack()
	{
		this.top=null;//intially the reference of the top element is nothing==null
	}

	//pushing operation
	//basically adding the elements at the top
	public  void push(int data)
	{
		Node newNode= new Node();

		if(newNode==null/*this will happen only when memory is not available*/)
		{
			System.out.println("Stack Overflow");
			return;
		}

		newNode.data= data;//data of the new element is the data we got as input

		newNode.link= top;//the link of the new node should be our old top element
		//since we are stacking elements at the top of eachother

		top= newNode;//our new node must be our new top
	}

	//method to check if our stack is empty or not
	public  boolean empty()
	{
		return top==null;//basically the expression "top==null", will be checked for true/false
	}

	//method to peek in to the stack
	//basically to see the element at the top of our stack
	public void peek()
	{
		if(!empty())
			System.out.println("The top element of the stack is: "+ top.data);
		else
			System.out.println("The Stack is empty!");
	}

	//method to pop elements from the stack in LIFO manner
	public  void pop()
	{
		if(top==null/*as this represents no element in the stack*/)
		{
			System.out.println("Stack Underflow");
			return;
		}

		top=top.link;//here we are linking our top element to it's next element
		//which basically removes the top element from our stack
	}

	//method to display our stack
	public  void display()
	{
		if(top==null)
		{
			System.out.println("Stack Underflow\n");
			return;
		}
		Node temp= top;//as we print from the top element
		System.out.println("Contents of the stack:");
		while(temp!=null)
		{
			System.out.print(temp.data+" ");
			temp=temp.link;//updating the temp node, with the next element
		}

		System.out.println();
	}


}

public class StackUsingSLL
{
	//main method
		public static void main(String args[])
		{
			MyStack stack= new MyStack();

			//inserting
			stack.push(1);
			stack.push(2);
			stack.push(3);
			stack.push(4);
			stack.push(5);

			//printing
			stack.display();

			//printing top element
			stack.peek();

			//popping(removing)
			stack.pop();
			stack.pop();

			System.out.println("After popping");
			stack.peek();

			stack.display();
			System.out.println("After popping");
			stack.pop();
			stack.pop();
			stack.pop();

			stack.display();
	}
}