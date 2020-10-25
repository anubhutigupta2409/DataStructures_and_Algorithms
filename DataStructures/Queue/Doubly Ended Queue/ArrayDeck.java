/*
ArrayDeque=array doubly ended queue, it is a concept which allows the removal and addition of elements from both the sides
of the queue, using an array, hence introduces the concept of resizable arrays.

It's Features=
1. Array Deques are not capacity bounded
2. Array deques are not thread safe
3. They are faster than stacks when used as stacks and faster than linked list when used as queue
4. null elements are prohibited in an array deque

#Interfaces
The Deque intefeace(doubly ended queue) extends the Queue interface(the linear queue) and both of these interface are implemented
by the ArrayDeque Class.

when we declare an arraydeque with no specified capacity, it calls the constructor which makes an object for the arraydeque class
and initilaise the capacity as 16, which can ofcourse be changed or modified later

performing different operations of our arraydeque
*/

import java.util.*;

public class ArrayDeck
{
	public static void main(String args[])
	{
		//since deque is an interface it's object has to be made by the class which implements it
		Deque<Integer> ad=new ArrayDeque<>();

		//adding elements using different kind of methods available
		ad.add(3);
		ad.addFirst(2);
		ad.addLast(4);
		ad.offer(5);
		ad.offerFirst(1);
		ad.offerLast(6);
		ad.push(55);

		//printing the list
		for(Integer element:ad)
		{
			System.out.println("Element= "+element);
		}

		//to get the head element
		System.out.println("\nHead Element= "+ad.peek());
		System.out.println("Head Element= "+ad.element());

		//accessing the elements
		System.out.println("\nFirst Element="+ad.getFirst());
		System.out.println("First Element="+ad.peekFirst());
		System.out.println("Last Element="+ad.getLast());
		System.out.println("Last Element="+ad.peekLast());

		//removing elements
		System.out.println("\nRemoving from end\n\n");
		System.out.println("\nRemoved= "+ad.removeLast());
		System.out.println("Deque now="+ad);
		System.out.println("\nRemoved= "+ad.pollLast());
		System.out.println("Deque now="+ad);

		System.out.println("\nRemoving from front");
		System.out.println("\n\nRemoved= "+ad.pollFirst());
		System.out.println("Deque now="+ad);
		System.out.println("\nRemoved= "+ad.remove());
		System.out.println("Deque now="+ad);
		System.out.println("\nRemoved= "+ad.poll());
		System.out.println("Deque now="+ad);
		System.out.println("\nRemoved= "+ad.removeFirst());
		System.out.println("Deque now="+ad);
		System.out.println("\nRemoved= "+ad.pop());
		System.out.println("Deque now="+ad);//as pop operation takes from top

		//accessing head of a null deque
		System.out.println("\nHead= "+ad.peek());

		//adding elements again
		ad.add(1);
		ad.add(2);
		ad.add(3);
		ad.add(4);
		ad.add(5);
		System.out.println("\n\nAdded more elements");
		System.out.println("Deque now= "+ad);
		System.out.println("\nConverting it into an array");
		/*
		he Object class is the parent class of all the classes in java by default.
		In other words, it is the topmost class of java.
		The Object class is beneficial if you want to refer any object whose type you don't know.
		*/
		Object[] array=ad.toArray();
		System.out.println("It's elements= ");
		for(int i=0;i<array.length;i++)
			System.out.print(array[i]+" ");



	}
}