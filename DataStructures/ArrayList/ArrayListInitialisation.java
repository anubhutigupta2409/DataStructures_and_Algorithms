/*ArrayList is a class which implements the interface List which inturn extends the Collection Framework of java
It is basically Dynamic Arrays, though they can be slower than the standard arrays but are useful in programs
where a lot of manipulation with arrays is required.
It is found in java.util package*
*/

import java.util.*;

public class ArrayListInitialisation
{
	public static void main(String[] args)
	{
		Scanner sc= new Scanner(System.in);
		System.out.println("Enter the size-");
		int n= sc.nextInt();
		//although size can change if the collection shrinks or elements are added to it
		//therefore, doesn't matter what size the user has put
		//Declaration of ArrayList
		ArrayList<Integer>/*Type defined, Integer used as a wrapper class for int*/ arrayList = new ArrayList<Integer> (n);
		//initialisation
		//with add()
		arrayList.add(1);
		arrayList.add(2409);
		//printing Arraylist
		System.out.println(arrayList);
		//initialising using short hand add function-
		ArrayList<String> strArrList= new ArrayList<String> (/*size not mentioned*/)
		{
			{
				add("We");
				add("Code");
			}

		};
		System.out.println(strArrList);
		//initialise with asList method of Arrays class
		ArrayList<String> hello = new ArrayList<String> (Arrays.asList("Hello","World"));
		System.out.println(hello);
		//initialise with of method of List interface
		ArrayList<String> world= new ArrayList<String> (List.of("World","Hello"));
		System.out.println(world);
		//initialising using another collection
		List<Integer> integer_2 =new ArrayList<Integer> (arrayList);
		System.out.println(integer_2);
	}
}
