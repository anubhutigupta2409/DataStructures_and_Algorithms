//in this program we perform all the operations that can be done on ArrayList

import java.util.*;

public class ArrayListOperations
{
	public static void main(String args[])
	{
		int n=5;
		List <Integer> arrayList = new ArrayList <Integer> (n);
		//appending
		for(int i=0;i<n;i++)
			arrayList.add(i);

		//printing
		System.out.println(arrayList);

		//removing from index 2
		arrayList.remove(2);
		System.out.println(arrayList);

		//using, arrayList.size(), size would have been altered
		System.out.println(arrayList.size());

		//printing one by one
		//get() method gets element at the mentioned index
		for(int i=0;i<arrayList.size();i++)
			System.out.print(arrayList.get(i) +" ");

		//using addAll() method
		List <Integer> abc= new ArrayList <Integer> (List.of(50,51,53));
		arrayList.addAll(abc);
		System.out.println(arrayList);
		System.out.println("size-"+arrayList.size());

		//using add() method to add an element at specific index in the ArrayList
		arrayList.add(3,69);
		System.out.println(arrayList);
		System.out.println("size-"+arrayList.size());

		//using set() method to change elements
		arrayList.set(5,78);
		System.out.println(arrayList);
		System.out.println("size-"+arrayList.size());

		//using remove() method
		arrayList.remove(1);//from index
		System.out.println(arrayList);
		System.out.println("size-"+arrayList.size());
		//this calls the remove(object), and not remove(int)
		//for string integer it can be removed directly , since they don't want Wrapper class
		//arrayList.remove("anu");//like this
		arrayList.remove(new Integer(69));//particular element
		System.out.println(arrayList);
		System.out.println("size-"+arrayList.size());

		//using removeAll() method
		arrayList.removeAll(abc);
		System.out.println(arrayList);
		System.out.println("size-"+arrayList.size());

		//using the clear() method
		arrayList.clear();
		System.out.println(arrayList);
		System.out.println("size-"+arrayList.size());

		//using the isEmpty() method
		System.out.println("Empty-" + arrayList.isEmpty());

		//using contains() method
		arrayList.addAll(abc);
		System.out.println(arrayList);
		System.out.println("contains 51-"+ arrayList.contains(51));

		//using toArray() method
		//as Integer wrapper class needs to be used
		Integer arr[] = new Integer[arrayList.size()];
		arrayList.toArray(arr);
		for(Integer x: arr)
			System.out.print(x+" ");


	}
}