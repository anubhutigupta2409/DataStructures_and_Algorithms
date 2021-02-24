/*
Find two non-repeating elements in an array where every element repeats twice
*/

import java.util.*;

public class TwoEleOthersTwice
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

		int res=0;
		for(int i=0;i<n;i++)
			res= res^a[i];//now if the two non-repeating elements are x and y, then res=x^y

		//our task is to separate x and y

		//step-1 find the position of the rightmost set bit of the result
		int i;
		for(i=0;i<invertedBinary(res).length;i++)
		{
			if(invertedBinary(res)[i]==1)
				break;
		}

		int setBitPos=i;

		//step-2 separate the elements of the array with different possible (0,1) bit at their setBitPos;
		int bucket1[] = new int[n];
		int bucket2[] = new int[n];

		for(i=0;i<n;i++)
		{
			if((invertedBinary(a[i]))[setBitPos]== 1)
				bucket1[i] = a[i];

			else
				bucket2[i] = a[i];
		}

		//now to continous XORs in them to find the result, that is , x and y separate
		int x = 0, y=0;
		for(i=0;i<bucket1.length;i++)
			x = x^bucket1[i];

		for(i=0;i<bucket2.length;i++)
			y = y^bucket2[i];

		//print the result
		System.out.println("\nThe only two non-repeating numbers are--> "+x+" , "+y);

	}
}