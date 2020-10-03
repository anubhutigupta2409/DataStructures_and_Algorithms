/*
Implementing a stack using array
*/

import java.util.*;

class MyStack
{
	static final int stackLength = 1000;
	int top;
	int a[]= new int[stackLength];//maximum size of the stack(had to be fixed, as array is used)

	//method to tell if the stack is empty
	boolean empty ()
	{
		return (top<0);
	}

	MyStack()
	{
		top = -1;//equivalent to making the top==null
	}

	//method to perform the push operation
	boolean push(int data)
	{
		if(top>=(stackLength-1))
		{
			System.out.println("Stack Overflow");
			return false;
		}

		else
		{
			a[++top]=data;
			System.out.println(data+" pushed into the stack");
			return true;
		}
	}

	//method to perform pop operation
	int pop()
	{
		if(top<0)
		{
			System.out.println("Stack Underflow");
			return 0;
		}

		else
		{
			int popped= a[top--];
			return popped;
		}
	}

	//method to peform the peek operation
	int peek()
	{
		if(top<0)
		{
			System.out.println("Stack Underflow");
			return 0;
		}
		else
		{
			int topElement= a[top];
			return topElement;
		}
	}

}

public class StackUsingArray
{
	//main method
	public static void main(String args[])
	{
		MyStack stack= new MyStack();

		System.out.println("Pushing elements");
		stack.push(1);
		stack.push(2);
		stack.push(3);
		stack.push(4);
		stack.push(5);

		int top=-1;
		top= stack.peek();
		System.out.println("\nTop of the stack: "+ top);

		System.out.println("\nPopping elements:");
		int popped= 0;
		popped= stack.pop();
		System.out.println(popped);

		popped= stack.pop();
		System.out.println(popped);

		popped= stack.pop();
		System.out.println(popped);

		top= stack.peek();
		System.out.println("\nTop of the stack: "+ top);

		System.out.println("\nIs the stack empty: "+stack.empty());

		System.out.println("\nPopping elements:");

		popped= stack.pop();
		System.out.println(popped);

		popped= stack.pop();
		System.out.println(popped);

		System.out.println("\nPopping elements:");
		popped= stack.pop();

		System.out.println("\nIs the stack empty: "+stack.empty());


	}
}