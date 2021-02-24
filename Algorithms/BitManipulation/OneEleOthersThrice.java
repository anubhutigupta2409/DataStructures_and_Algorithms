/*
Find the only non-repeating element in an array where every other element repeats thrice(works for k times as well)
*/

import java.util.*;

public class OneEleOthersThrice
{
	public static int[] invertedBinary(int n)
	{
		int binN[] = new int[32];
 		int c=0;//counter variable
		while(n>0)
		{
			binN[c]=n%2;
			n/=2;
			c++;
		}
		//returns the inverted binary representation of the parameter

		return binN;
	}

	public static void main(String args[])
	{
		Scanner sc= new Scanner(System.in);
		System.out.println("Enter the number of elements inside the array-->");
		int n=sc.nextInt();
		int a[] = new int[n];
		System.out.println("Enter the contents of the array-->");
		for(int i=0;i<n;i++)
			a[i]=sc.nextInt();

		//making a count array (we will increment the number of times 1's and 0's have come)
		int count[] = new int[32];

		for(int i=0;i<n;i++)
		{
			for(int j=0;j<32;j++)
				count[j]+=(invertedBinary(a[i]))[j];
		}

		//now doing %k(3 here) for every element of the count array, to get the reversed binary representation of the
		//required number

		for(int i=0;i<32;i++)
			count[i]%=3;

		//converting into decimal
		int res=0;
		for(int i=0;i<32;i++)
			res += (int)(count[i]*Math.pow(2,i));

		//printing
		System.out.println("\nThe only non-repeating element is--> "+res);
	}
}