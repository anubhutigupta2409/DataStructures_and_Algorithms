/*
Queue Interface in java.util.* extends Collection interface, now, the Deque Interface extends the Queue Interface
which in turn is implemented by classes ArrayDeque and LinkedList apart from these our Queue interface is implemented by
class PriorityQueue.
Elements inside a Queue are processed upon keeping in mind the First In First Out (FIFO) Operation

Now since our Queue is an interface we need a concrete class which creates it's objects, and most commonly used classes for it
are-PriorityQueue and LinkedList, both of these implementations are not thread safe, we have an alternative =
PriorityBlockingQueue if thread safe implementations are needed.

Some Characteristics-
1.The queues present in java.uti package are unbounded queues(not bounded by the capacity we need not specify the size)
2.The ones in java.uti.concurrent package are bounded queues(bounded for a particular no. of elements and queue overflow can occur)
3.All the queues support insertion at the rear/tail and deletion at the head except Deques.The deques support removal and
insertion at both the ends, basically because Deque->Doubly Ended Queue
*/

import java.util.*;

public class QueueDemo
{
	public static void main(String args[])
	{
		Queue<Integer> q=new LinkedList<>();
		//adding
		for(int i=0;i<5;i++)
			q.add(i);
		//printing
		System.out.println("Queue Created=\n"+q);
		//removing
		System.out.println("Removing using remove() method- "+q.remove());
		System.out.println("Removing using poll() method- "+q.poll());
		System.out.println("Queue Currently=\n"+q);
		//peeking
		System.out.println("Head of the queue using peek() method- "+q.peek());
		System.out.println("Head of the queue using element() method- "+q.element());
		//methods of collection framework
		System.out.println("Current size of our Queue is- "+q.size());
	}
}