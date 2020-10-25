//implementing Queue in java using Linked list

class Node
{
	int data;
	Node next;

	public Node(int data)
	{
		this.data=data;
		this.next=null;
	}
}

class Queue
{
	Node front, rear;

	public Queue()
	{
		this.front=this.rear=null;
	}

	//method to add elemets
	void enqueue(int data)
	{
		Node temp=new Node(data);

		//if the queue is empty both rear and front are the new node
		if(this.rear==null)
		{
			this.rear=this.front=temp;
			return;
		}

		//if it's not empty
		this.rear.next=temp;//the new node is the element next to rear
		this.rear=temp;//change the rear
	}

	//removing method
	void dequeue()
	{
		//if we want to remove an element from the queue then the front must be
		//at some element and if it's null, that implies the queue is empty
		//and we can't remove any element from an empty queue
		if(this.front==null)
			return;

		Node tempFront= this.front;//storing the value of old front
		this.front=this.front.next;//we are unlinking the current front

		//now if the front becomes null then make the rear null too
		if(this.front==null)
			this.rear=null;
	}

}

//main class
public class QueueLL
{
	public static void main(String args[])
	{
		Queue q=new Queue();

		//adding
		q.enqueue(1);
		q.enqueue(2);
		q.enqueue(3);
		q.enqueue(4);

		System.out.println("FRONT="+q.front.data);
		System.out.println("REAR="+q.rear.data);

		//deleting
		q.dequeue();
		q.dequeue();

		System.out.println("\nRemoved two elements-");
		System.out.println("FRONT="+q.front.data);
		System.out.println("REAR="+q.rear.data);

		//emptying the list
		q.dequeue();
		q.dequeue();

		System.out.println("\nEmptied the queue-");
		//will throw null pointer exception
		System.out.println("FRONT="+q.front.data);
		System.out.println("REAR="+q.rear.data);


	}
}