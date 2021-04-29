/*
Circular Queue is a linear data structure in which the operations are performed based on FIFO (First In First Out) principle
and the last position is connected back to the first position to make a circle. It is also called ‘Ring Buffer’.


circularqueues


In a normal Queue, we can insert elements until queue becomes full. But once queue becomes full, we can not insert the next
element even if there is a space in front of queue.


Operations-on-Circular queue

Operations on Circular Queue:





Front: Get the front item from queue.
Rear: Get the last item from queue.
enQueue(value) This function is used to insert an element into the circular queue. In a circular queue, the new element is
always inserted at Rear position.
Check whether queue is Full – Check ((rear == SIZE-1 && front == 0) || (rear == front-1)).
If it is full then display Queue is full. If queue is not full then, check if (rear == SIZE – 1 && front != 0) if it is true
then set rear=0 and insert element.
deQueue() This function is used to delete an element from the circular queue. In a circular queue, the element is always
deleted from front position.
Check whether queue is Empty means check (front==-1).
If it is empty then display Queue is empty. If queue is not empty then step 3
Check if (front==rear) if it is true then set front=rear= -1 else check if (front==size-1), if it is true then set front=0
and return the element.
*/

import java.util.*;

public class CircularQueue
{
	private int size,front,rear;

	private List<Integer> q = new ArrayList<Integer>();

	CircularQueue(int size)
	{
		this.size = size;
		this.front = this.rear = -1;
	}

	public void enQueue(int data)
	{
		if( (front==0 && rear==size-1) || rear==(front-1)%(size-1))
		{
			System.out.println("\nQueue Overflow");
			return;
		}

		//empty queue
		if(front == -1)
		{
			front = rear = 0;
			q.add(rear,data);
		}

		else if(rear==size-1 && front!=0)
		{
			rear = 0;
			q.set(rear,data);
		}

		else
		{
			rear++;

			if(front <= rear)
				q.add(rear,data);

			else
				q.set(rear,data);
		}
	}

	public int deQueue()
	{
		if(front == -1)
		{
			System.out.println("\nEmpty Queue");
			return -1;
		}

		int temp = q.get(front);

		if(front == rear)
			front=rear=-1;

		else if(front == size-1)
			front = 0;

		else
			front++;

		return temp;
	}

	public void displayQueue()
	{
		if(front == -1)
		{
			System.out.println("\nEmpty Queue");
			return ;
		}

		System.out.println("\nElements-->");

		if(front<=rear)
			for(int i=front ; i<=rear; i++)
				System.out.print(q.get(i) + " ");

		else
		{
			for(int i=front; i<size;i++)
				System.out.print(q.get(i)+ " ");

			for(int i=0;i<=rear;i++)
				System.out.print(q.get(i)+ " ");
		}
	}

	public static void main(String[] args)
	{

	    // Initialising new object of
	    // CircularQueue class.
	    CircularQueue q = new CircularQueue(5);

	    q.enQueue(14);
	    q.enQueue(22);
	    q.enQueue(13);
	    q.enQueue(-6);

	    q.displayQueue();

	    int x = q.deQueue();

	    // Checking for empty queue.
	    if(x != -1)
	    {
	        System.out.print("\nDeleted value = ");
	        System.out.println(x);
	    }

	    x = q.deQueue();

	    // Checking for empty queue.
	    if(x != -1)
	    {
	        System.out.print("\nDeleted value = ");
	        System.out.println(x);
	    }

	    q.displayQueue();

	    q.enQueue(9);
	    q.enQueue(20);
	    q.enQueue(5);

	    q.displayQueue();

	    q.enQueue(20);
}
}

/*
Time Complexity: Time complexity of enQueue(), deQueue() operation is O(1) as there is no loop in any of the operation.
Applications:


Memory Management: The unused memory locations in the case of ordinary queues can be utilized in circular queues.
Traffic system: In computer controlled traffic system, circular queues are used to switch on the traffic lights one by one
repeatedly as per the time set.
CPU Scheduling: Operating systems often maintain a queue of processes that are ready to execute or that are waiting for a
particular event to occur.
*/