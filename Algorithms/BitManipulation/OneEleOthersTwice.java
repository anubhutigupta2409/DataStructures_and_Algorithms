/*
Find the only non-repeating element in an array where every element repeats twice.

concept-->
(i) n^n=0
(ii)0^n=n
*/

import java.util.*;

public class OneEleOthersTwice
{
	public static void main(String args[])
	{
		Scanner sc= new Scanner(System.in);
		System.out.println("Enter the number of elements inside the array-->");
		int n=sc.nextInt();
		int a[] = new int[n];
		System.out.println("Enter the contents of the array-->");
		for(int i=0;i<n;i++)
			a[i]=sc.nextInt();

		int res=0;
		for(int i=0;i<n;i++)
			res= res^a[i];

		System.out.println("The only non repeating element is--> "+res);
	}
}

/*
Time Complexity=O(n)
Space Complexity=O(1)
*/