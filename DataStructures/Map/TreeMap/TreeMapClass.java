/*
The TreeMap in Java is used to implement Map interface and NavigableMap along with the Abstract Class. The map is
sorted according to the natural ordering of its keys, or by a Comparator provided at map creation time, depending
on which constructor is used. This proves to be an efficient way of sorting and storing the key-value pairs. The 
storing order maintained by the treemap must be consistent with equals just like any other sorted map, 
irrespective of the explicit comparators.

The treemap implementation is not synchronized in the sense that if a map is accessed by multiple threads, 
concurrently and at least one of the threads modifies the map structurally, it must be synchronized externally.

Features of a TreeMap:

Some important features of the treemap are:

1.This class is a member of Java Collections Framework.
2.The class implements Map interfaces including NavigableMap, SortedMap and extends AbstractMap class.
3.TreeMap in Java does not allow null keys (like Map) and thus a NullPointerException is thrown. However, 
multiple null values can be associated with different keys.
4.Entry pairs returned by the methods in this class and its views represent snapshots of mappings at the time 
they were produced. They do not support the Entry.setValue method.

Synchronized TreeMap:

The implementation of a TreeMap is not synchronized. This means that if multiple threads access a tree set 
concurrently, and at least one of the threads modifies the set, it must be synchronized externally. This is
 typically accomplished by using the Collections.synchronizedSortedSet method. This is best done at the creation
 time, to prevent accidental unsynchronized access to the set. This can be done as:

SortedMap m = Collections.synchronizedSortedMap(new TreeMap(…));



//sorted on the basis of keys

*/
import java.util.*;

public class TreeMapClass
{
	public static void main(String args[])
	{
		Map <String,Integer> map=new TreeMap<String,Integer>();
		map.put("A",9);
		map.put("D",8);
		map.put("B",6);
		map.put("C",5);
		System.out.println(map);

		Map<Integer,String> map1=new TreeMap<Integer,String>();
		map1.put(9,"A");
		map1.put(8,"D");
		map1.put(6,"B");
		map1.put(5,"E");
		System.out.println(map1);
	}
}