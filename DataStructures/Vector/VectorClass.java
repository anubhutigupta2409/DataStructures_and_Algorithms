/*
Vector Class implements the List interface so we can use all the methods of the List interface. A vector implements a dynamic arrays
also just like arrays the elements of a vector can be accessed using a integer index. They are very similar to ArrayList but most of
its methods have a "synchronized" keyword to make it threadsafe, which it makes it to perform the operations like addition, deletion
etc. poorly. Also when we talk about the flexibility of the data structures. ArrayList increases it's size 1.5times while a Vector
increases it's size 2times. (Another reason why ArrayList is preferred over Vector).
Also The Iterators returned by the Vector class are fail-fast. In the case of concurrent modification, it fails and throws the
ConcurrentModificationException.

1.It extends AbstractList and implements List interfaces.
2.It implements Serializable, Cloneable, Iterable<E>, Collection<E>, List<E>, RandomAccess interfaces.
3.The directly known subclass is Stack.

Vector(): Creates a default vector of the initial capacity is 10.

using Vector class's methods-
*/

import java.util.*;

public class VectorClass
{
	public static void main(String args[])
	{
		Vector<Integer> vector=new Vector<Integer>(3);

		//adding
		for(int i=0;i<5;i++)
			vector.add(i);
		System.out.println(vector);
		/*

		vector.add(7,69);//gives an error since currently the size of Vector is 5

		*/
		vector.add(3,69);
		System.out.println(vector);
		//changing
		vector.set(2,55);
		System.out.println(vector);
		//removing
		vector.remove(new Integer(55));//removes the value "55"
		System.out.println(vector);
		vector.add(2);
		System.out.println(vector);
		vector.remove(2);//removes from index 2
		System.out.println(vector);

	}
}

