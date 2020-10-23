//implementing a Queue in java using Arrays

class Queue
{
	int front, rear, size/*to check the current size of our queue*/;
	int capacity;
	int array[];

	//constructor
	public Queue(int capacity/*bounded queue types*/)
	{
		this.capacity=capacity;
		front=this.size=0;
		rear=this.capacity-1;
		array=new int[this.capacity];
	}

	//for queue overflow error that is when our queue is full
	//our queue will be full when our size will become == capacity
	boolean isFull(Queue queue)
	{
		return(queue.capacity==queue.size);
	}

	//our queue will be empty if the size is zero
	boolean isEmpty(Queue queue)
	{
		return(queue.size==0);
	}

	//method to add element
	void enqueue(int element)
	{
		if(isFull(this))
		{
			System.out.println("Queue Overflow");
			return;
		}

		this.rear=(this.rear + 1) % this.capacity;//calculating the poition of rear
		//maintaing a circularity in a sense
		this.array[this.rear]=element;//added
		this.size+=1;
		System.out.println(element+" enqued in the queue");
	}

	//removing elements
	int dequeue()
	{
		if(isEmpty(this))
			return Integer.MIN_VALUE;//return the minimum possible value from the array
		int item=this.array[this.front];
		this.front=(this.front + 1) % this.capacity;
		this.size-=1;
		return item;
	}

	//method to get front of the queue
	int front()
	{
		if(isEmpty(this))
			return Integer.MIN_VALUE;

		return this.array[this.front];
	}

	//method to get rear of the queue
	int rear()
	{
		if(isEmpty(this))
			return Integer.MIN_VALUE;

		return this.array[this.rear];
	}

}

public class QueueArray
{
	public static void main(String args[])
	{
		Queue q=new Queue(1000);

		//adding
		q.enqueue(1);
		q.enqueue(2);
		q.enqueue(3);
		q.enqueue(4);

		//printing front and rear
		System.out.println("\n\nFRONT= "+q.front());
		System.out.println("REAR= "+q.rear());

		//removing
		System.out.println("\n\nRemoved "+q.dequeue());
		System.out.println("Removed "+q.dequeue());

		//printing front and rear
		System.out.println("\n\nFRONT= "+q.front());
		System.out.println("REAR= "+q.rear());

		//after emptying the queue
		System.out.println("\n\nRemoved "+q.dequeue());
		System.out.println("Removed "+q.dequeue());
		System.out.println("Removed "+q.dequeue());//nothing could be removed

	}
}