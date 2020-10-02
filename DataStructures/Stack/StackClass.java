/*

Getting familiar with the Stack Class of java and the methods it provides.
it follows The LAST IN FIRST OUT(LIFO), basically the element that enters the last ,gets out the first, and the element
which enters the first gets to stay in the stack for the longest.

The Stack class extends the vector class, which in turn implements the List Inteface which in turn extends the java collection
framework.


*/
import java.util.*;

public class StackClass
{
	//pushing elements at the top of our stack
	public static void stackPush(Stack <Integer> stack)
	{
		for(int i=0;i<5;i++)
			stack.push(i);
	}

	//popping elements from the stack, which obeys the LIFO operation
	public static void stackPop(Stack <Integer> stack)
	{
		System.out.println("Contents of your stack-");
		for(int i=0;i<5;i++)
		{
			//using the wrapper class for int
			Integer popped = (Integer) stack.pop();
			System.out.print(popped+" ");
		}
		System.out.println();
	}

	//peeking into the stack to get the element at the top
	public static void stackPeep(Stack <Integer> stack)
	{
		Integer topElement = (Integer) stack.peek();
		System.out.println("After peeking operation, we get the element at the top is: "+ topElement);
	}

	//searching an element inside the stack
	public static void stackSearch(Stack <Integer> stack, int element)
	{
		if (stack.empty()/*returns true if the stack is empty*/)
		{
			System.out.println("The stack is empty!");
			return;
		}
		Integer pos = (Integer) stack.search(element);
		if (pos==-1)
			System.out.println("Not part of your stack");

		else
			System.out.println("The element was found in your stack at position: "+pos);
	}

	//main method
	public static void main(String args[])
	{
		Stack <Integer> stack = new Stack <Integer> ();

		//using methods
		stackPush(stack);
		stackPop(stack);

		stackPush(stack);//as pop operation removes the element from the stack
		stackSearch(stack,3);
		stackSearch(stack,10);
		stackPop(stack);
		stackSearch(stack,3);
	}
}