/*
The process of AND(ing) or OR(ing) a number with some other number (in binary), in order to change the concerned number in a
certain way is called Bit Masking
*/

/*
valid value of i-->
the indexing starts from 0 from the extreme left of the binary representation of the number
also, number of bits in the binary representation of the decimal number n = (log(base 2)n + 1)
therefore valid i==>
0 <= i < (log(base 2)n + 1)

tip:
we can do calculation as follows-->
log2 N = log10 N / log10 2
*/

import java.util.*;

public class FindIthBit
{
	public static void binaryConversion(int n)
	{
		int binN[] = new int[32];
		int c=0;//counter variable
		while(n>0)
		{
			binN[c]=n%2;
			n/=2;
			c++;
		}

		//printing the binary representation(in reverse order)
		for(int j=c-1;j>=0;j--)
			System.out.print(binN[j]+" ");

		System.out.println();
	}

	public static boolean validateI(int i, int n)
	{
		if( i>=0 && i<(int)(Math.log(n)/Math.log(2)))
			return true;
		else
			return false;
	}

	public static void main(String args[])
	{
		//concept == anybit & 1=0 means anybit=0 else anybit=1
		Scanner sc= new Scanner(System.in);
		System.out.println("Enter the decimal number-->");
		int n= sc.nextInt();

		//decimal to binary conversion
		System.out.println("it's binary representation-->");
		binaryConversion(n);

		System.out.println("Enter the index of the bit to find-->");
		int i= sc.nextInt();

		//validating i
		if(validateI(i,n))
		{
			int mask= (1<<i);
			if((n&mask)==0)
				System.out.println("Ith bit=0");
			else
				System.out.println("Ith bit=1");
		}
		else
		{
			System.out.println("Invalid i");
		}
	}
}