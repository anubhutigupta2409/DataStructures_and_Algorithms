/*
The set interface extends the Collection Interface ,basically it implements a real life mathematical set.
This interface contains the methods inherited from the Collection interface and adds a feature which restricts the insertion of
the duplicate elements. There are two interfaces which extend the set implementation namely SortedSet and NavigableSet.

Set <----- SortedSet <----- NavigableSet <==== TreeSet
    implements	     implements		     extends

the navigable set extends the sorted set interface. Since a set doesn’t retain the insertion order, the navigable set interface
provides the implementation to navigate through the Set. The class which implements the navigable set is a TreeSet which is an
implementation of a self-balancing tree. Therefore, this interface provides us with a way to navigate through this tree.

Classes that implement the Set Interface-

1.HashSet
Hashset class which is implemented in the collection framework is an inherent implementation of the hash table datastructure.
The objects that we insert into the hashset does not guarantee to be inserted in the same order. The objects are inserted based
on their hashcode. This class also allows the insertion of NULL elements. But also only one null ,as set doesnot allows duplicate
values.

2.EnumSet
-----Talked about separately-----

3.LinkedHashSet
LinkedHashSet class which is implemented in the collections framework is an ordered version of HashSet that maintains a
doubly-linked List across all elements. When the iteration order is needed to be maintained this class is used. When iterating
through a HashSet the order is unpredictable, while a LinkedHashSet lets us iterate through the elements in the order in which
they were inserted.

4.TreeSet
-----Talked about separately-----

Using Set inteface through HashSet class here
*/

import java.util.*;

public class SetInterface
{
	public static void main(String args[])
	{
		Set<String> set=new HashSet<String>();
		//adding
		set.add("kiwi");
		set.add("Apple");
		set.add("Banana");
		set.add("Apple");
		System.out.println(set);
		//accessing elements
		String ele="D";
		System.out.println(set.contains(ele));
		set.add(ele);
		System.out.println(set);
		System.out.println(set.contains(ele));
		//removing
		set.remove("D");
		System.out.println(set);

		//performing set operations

		Set<Integer> x=new HashSet<>();
		x.add(23);
		x.add(1);
		x.add(6);
		Set<Integer> y=new HashSet<>();
		y.add(3);
		y.add(1);
		y.add(16);
		System.out.println("Set x= "+x);
		System.out.println("Set y= "+y);
		//performing union
		x.addAll(y);//adding elements of y which are not common  between x and y to x
		System.out.println("After union Set x= "+x+" & y= "+y);
		x.remove(3);
		x.remove(16);
		System.out.println("Set x= "+x);
		System.out.println("Set y= "+y);
		//performing intersection
		x.retainAll(y);//removing elements which are not common between x and y from x
		System.out.println("After intersection Set x= "+x+" & y= "+y);

		System.out.println("Set x= "+x);
		System.out.println("Set y= "+y);
		//performing subset operation
		System.out.println("Is x subset of y = "+y.containsAll(x));

		x.add(23);
		x.add(6);
		System.out.println("Set x= "+x);
		System.out.println("Set y= "+y);
		//performing difference
		x.removeAll(y);//removing elements which are common between x and y from x
		System.out.println("After difference Set x= "+x+" & y= "+y);

	}
}